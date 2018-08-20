package com.example.designpatterns;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:YMeng
 * Time:2018/8/6  10:55
 * This is ImageLoafer
 * 图片加载类
 */
public class ImageLoader {
    //内存缓存
    ImageCache mImageCache = new MemoryCache();
    //图片加载中显示的图片id
    int mLoadingImageId;
    //加载失败时显示的图片id
    int mLoadingFailedImageId;
    //图片加载策略

    //线程池,线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void setmImageCache(ImageCache cache){
        mImageCache = cache;
    }
    //设置加载时图片
    public void setmLoadingImage(int resId){
        mLoadingImageId = resId;
    }
    //设置加载失败图片
    public void setmLoadingFailedImage(int resId){
        mLoadingFailedImageId = resId;
    }



    public void displayImage(final String url, final ImageView imageView)  {

        Bitmap bitmap = mImageCache.get(url);
        if(bitmap==null){
            //图片没缓存,提交到线程池中下载图片
            submitLoadRequest(url,imageView);

        }else{
            imageView.setImageBitmap(bitmap);

        }

    }

    private void submitLoadRequest(final String url, final ImageView imageView) {
        //设置加载中图片
        imageView.setImageResource(mLoadingImageId);

        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    Log.e("TAG", "bitmap == null: ");
                    //加载失败
                    imageView.setImageResource(mLoadingFailedImageId);
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    Log.e("TAG", "imageView.getTag(): ");
                    imageView.setImageBitmap(bitmap);

                }
                mImageCache.put(url, bitmap);
            }
        });
    }



    public Bitmap downloadImage(String imageUrl) {
        Log.e("TAG", "downloadImage: ");
        Bitmap bitmap = null;
        try {
          URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();//执行完毕,断开调用

//            --------------
       /*     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("charset","UTF-8");
            StringBuilder s = new StringBuilder();
            String str;
            if (connection.getResponseCode()==200){
                InputStream in = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(in);
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}

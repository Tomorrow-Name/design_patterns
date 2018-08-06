package com.example.designpatterns;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
    Activity mActivity;
    //图片缓存
    LruCache<String, Bitmap> mImageCache;
    //线程池,线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {
        Log.e("TAG", "ImageLoader: ");
        initImageCache();
    }

    private void initImageCache() {

        Log.e("TAG", "initImageCache: ");
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }



    public Bitmap displayImage(final String url, final ImageView imageView)  {
        Log.e("TAG", "displayImage: ");
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    Log.e("TAG", "bitmap == null: ");
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    Log.e("TAG", "imageView.getTag(): ");
                   imageView.setImageBitmap(bitmap);
                /*    imageView.setVisibility(View.VISIBLE);
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setVisibility(View.GONE);
                            imageView.setVisibility(View.VISIBLE);
                        }
                    });*/
                }
                mImageCache.put(url, bitmap);
            }
        });
        return null;
    }

    public Bitmap downloadImage(String imageUrl) {
        Log.e("TAG", "downloadImage: ");
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();//执行完毕,断开调用
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}

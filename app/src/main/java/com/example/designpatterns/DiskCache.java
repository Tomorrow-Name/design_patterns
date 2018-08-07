package com.example.designpatterns;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:YMeng
 * Time:2018/8/7  14:49
 * This is DiskCache
 * 缓存到SD卡中
 */
public class DiskCache  implements ImageCache {
    static String cacheDir = Environment.getExternalStorageDirectory()+"/cache/";
    //从缓存中获取图片
    public Bitmap get(String url){
       return BitmapFactory.decodeFile(cacheDir+url);
        //  return BitmapFactory.decodeFile(cacheDir+"112233.jpg");
    }
    //将图片放到内存中
    public void put(String url,Bitmap bitmap){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

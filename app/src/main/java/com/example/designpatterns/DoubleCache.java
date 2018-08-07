package com.example.designpatterns;

import android.graphics.Bitmap;

/**
 * Author:YMeng
 * Time:2018/8/7  15:00
 * This is DoubleCache
 * 双缓存.获取图片时先从内存中获取,如果内存中没有缓存该图片,再从SD卡中获取
 */
public class DoubleCache implements ImageCache {
    ImageCache mMemoryCache = new MemoryCache();
    DiskCache mDiskCache = new DiskCache();

    //先从内存中获取图片,如果没有,再从SD卡中获取
    public Bitmap get(String url){
        Bitmap bitmap = mMemoryCache.get(url);
        if(bitmap==null){
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }
    //将图片缓存到SD卡和内存
    public void put(String url,Bitmap bmp){
        mMemoryCache.put(url,bmp);
        mDiskCache.put(url,bmp);
    }
}

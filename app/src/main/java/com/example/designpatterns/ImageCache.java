package com.example.designpatterns;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * Author:YMeng
 * Time:2018/8/7  10:17
 * This is ImageCache
 * 用于图片缓存,抽出来的父类接口,
 */
public interface ImageCache {
     Bitmap get(String url);
     void put(String url,Bitmap bitmap);
}

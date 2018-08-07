package com.example.designpatterns;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * Author:YMeng
 * Time:2018/8/7  16:06
 * This is MemoryCache
 * 内存缓存
 */
public class MemoryCache implements ImageCache{
    private LruCache<String, Bitmap> mMemoryCache;

    public MemoryCache() {

        Log.e("TAG", "initImageCache: ");
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url,Bitmap bitmap){
        mMemoryCache.put(url,bitmap);
    }
    public Bitmap get(String url){
        return mMemoryCache.get(url);
    }
}

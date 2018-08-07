package com.example.designpatterns;

import java.io.Closeable;
import java.io.IOException;

/**
 * Author: Administrator
 * Time: 2018/8/7/007 21
 * This is CloseUtils
 * 关闭Closeable对象
 */
public final class CloseUtils {
    private CloseUtils(){}
    public static void closeQuietly(Closeable closeable){
        if(closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

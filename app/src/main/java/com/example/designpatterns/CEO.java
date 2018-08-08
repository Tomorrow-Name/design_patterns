package com.example.designpatterns;

/**
 * Author:YMeng
 * Time:2018/8/8  15:34
 * This is CEO
 * 单例模式 -- CEO,饿汉单例模式
 */
public class CEO extends Staff{
    private static final CEO mCeo = new CEO();
    private CEO(){

    }

    //共有静态函数,对外暴露获取单例对象的接口
    public static CEO getCeo(){
        return mCeo;
    }
    @Override
    public void work(){
        //管理VP
    }
}
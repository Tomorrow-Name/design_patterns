package com.example.designpatterns;

/**
 * Author: Administrator
 * Time: 2018/8/9/009 23
 * This is Macbook
 * Builder模式 -- 具体的Builder类
 */
public class Macbook extends Computer {
    protected Macbook(){

    }
    @Override
    public void setOS() {
    mOS = "Windows10";
    }
}

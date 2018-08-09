package com.example.designpatterns;

/**
 * Author: Administrator
 * Time: 2018/8/9/009 23
 * This is Director
 * Builder模式 -- 负责构建Computer
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public void construct(String board , String display){
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}

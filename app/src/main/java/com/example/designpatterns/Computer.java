package com.example.designpatterns;

/**
 * 角色介绍
 * （产品的抽象类）         （抽象Builder类，规范产品的组件，一般由子类实现具体的组建过程）
 *     Driectro      ←←      Builder（abstract）
 *                                    ↑
 *                         （具体的Builder类）        （统一组装过程）
 *                          ConcreteBuilder     →→      Product
 *
 */
/**
 * Author: Administrator
 * Time: 2018/8/9/009 23
 * This is Computer
 * Builder模式 -- 计算器抽象类
 */
//计算机抽象类，即Product角色
public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    public Computer() {
    }
    //设置CPU核心数
    public void setBoard(String board){
        mBoard = board;
    }
    //设置内存
    public void setDisplay(String display){
        mDisplay = display;
    }
    //设置操作系统
    public  abstract void setOS();

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOS='" + mOS + '\'' +
                '}';
    }
}

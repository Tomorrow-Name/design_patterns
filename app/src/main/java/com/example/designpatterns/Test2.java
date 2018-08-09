package com.example.designpatterns;

/**
 * Author: Administrator
 * Time: 2018/8/9/009 23
 * This is Test2
 * Builder模式-测试
 */
public class Test2 {
    public static void main(String[] args){
        //构造器
        Builder builder = new MacbookBuilder();
        //Director
        Director pcDirector = new Director(builder);
        //封装构建过程，8核，内存16GB，Windows系统
        pcDirector.construct("组装主机","AOC显示器");
        //构建计算器，输出信息
        System.out.println("info : "+builder.create().toString());
    }
}

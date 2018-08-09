package com.example.designpatterns;

/**
 * Author: Administrator
 * Time: 2018/8/9/009 23
 * This is MacbookBuilder
 * Builder模式 -- 具体的Builder类
 */
public class MacbookBuilder extends Builder {
    private Computer mComputer = new Macbook();
    @Override
    public void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void buildOS() {
        mComputer.setOS();
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}

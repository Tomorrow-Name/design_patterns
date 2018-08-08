package com.example.designpatterns;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:YMeng
 * Time:2018/8/8  15:19
 * This is Company
 * 单例模式 -- 公司类
 */
public class Company {
    private List<Staff> allStaffs = new ArrayList<>();
    public void addStaff(Staff per){
        allStaffs.add(per);
    }

    public void showAllStaffs(){
        for (Staff per:allStaffs) {
           // Log.d("TAG", "showAllStaffs: "+per.toString());
            System.out.println("Obj:  " + per.toString());
        }
    }
}

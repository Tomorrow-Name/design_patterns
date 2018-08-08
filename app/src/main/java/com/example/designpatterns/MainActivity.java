package com.example.designpatterns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * 添加分支
 * dev更新到master
 * 18:42home
 */
public class MainActivity extends AppCompatActivity {
    private String mUrl = "http://img.redocn.com/sheji/20160124/keaixiaoshipinsucaiPSD_5800042.jpg";
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
       /* LeakThread leakThread = new LeakThread();
        leakThread.start();*/
        mImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground));
        ImageLoader imageLoader = new ImageLoader();
        ImageLoader imageLoader1 = new ImageLoader();
        // imageLoader.setmImageCache(new DoubleCache());
        imageLoader.displayImage(mUrl, mImageView);
        if("你好"=="你好"){
            Toast.makeText(this, "if", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "else", Toast.LENGTH_SHORT).show();
        }

    }

    private void initViews() {
         mImageView = findViewById(R.id.Main_Iamge);

    }

    public void onMainBtn(View view) {
        // startActivity(new Intent(this,MainActivitty2.class));
    }

}

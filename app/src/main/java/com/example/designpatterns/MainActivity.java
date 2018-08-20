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

        ImageLoader imageLoader = new ImageLoader();
        // imageLoader.setmImageCache(new DoubleCache());
        imageLoader.setmLoadingImage(R.drawable.jh);
        imageLoader.setmLoadingFailedImage(R.drawable.icon_zwjl);
        imageLoader.displayImage(mUrl, mImageView);


    }

    private void initViews() {
         mImageView = findViewById(R.id.Main_Iamge);

    }

    public void onMainBtn(View view) {
        // startActivity(new Intent(this,MainActivitty2.class));
    }

}

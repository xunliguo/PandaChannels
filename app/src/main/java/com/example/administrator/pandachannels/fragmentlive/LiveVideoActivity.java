package com.example.administrator.pandachannels.fragmentlive;


import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.VideoView;


import com.example.administrator.pandachannels.R;



public class LiveVideoActivity extends AppCompatActivity  {

    private VideoView vitamio_viedoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {

        Intent intent = getIntent();
        String url1 = intent.getStringExtra("url");
        Log.e("TAG","=============>"+url1);


    }





}


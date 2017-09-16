package com.example.administrator.pandachannels.fragmentlive;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.administrator.pandachannels.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private VideoView vitamio_viedoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        vitamio_viedoview = (VideoView) findViewById(R.id.vitamio_viedoview);
        Intent intent = getIntent();
        String url1 = intent.getStringExtra("url");

        Vitamio.isInitialized(this);
        String url="https://vfx.mtime.cn/Video/2017/07/27/mp4/170727100951771139.mp4";
        vitamio_viedoview.setVideoPath(url1);
        vitamio_viedoview.setOnPreparedListener(this);

        vitamio_viedoview.setMediaController(new MediaController(this));
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        vitamio_viedoview.start();
    }



}


package com.example.administrator.pandachannels.fragmentobserve.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.administrator.pandachannels.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
public class VideoActivity extends AppCompatActivity {

    private VideoView shi_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        Vitamio.isInitialized(this);
        initData();
    }

    private void initData() {
        shi_video.setVideoPath("http://video.jiecao.fm/11/23/xin/%E5%81%87%E4%BA%BA.mp4");
        shi_video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                shi_video.start();
            }
        });
        shi_video.setMediaController(new MediaController(VideoActivity.this));

    }

    private void initView() {
        shi_video = (VideoView) findViewById(R.id.shi_video);
    }
}

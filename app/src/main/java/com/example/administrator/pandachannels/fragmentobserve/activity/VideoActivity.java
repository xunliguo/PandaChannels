package com.example.administrator.pandachannels.fragmentobserve.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.pandachannels.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends AppCompatActivity {


    private JCVideoPlayer shi_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();

        initData();
    }

    private void initData() {

        shi_video.setUp("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4","毛毛");
    }

    private void initView() {
        shi_video = (JCVideoPlayer) findViewById(R.id.shi_video);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

    }
}

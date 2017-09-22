package com.example.administrator.pandachannels.fragmentculture.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.pandachannels.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class CuiActivity extends AppCompatActivity {

    private JCVideoPlayer video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cui);
        initView();
    }

    private void initView() {
        video = (JCVideoPlayer) findViewById(R.id.video);
        video.setUp("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4",
                "熊猫");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}

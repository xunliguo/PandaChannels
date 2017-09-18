package com.example.administrator.pandachannels.fragmentculture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.pandachannels.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class WenActivity extends AppCompatActivity {


    private JCVideoPlayer videoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen);
        initView();

        initData();

    }

    private void initData() {

    }

    private void initView() {
        videoController = (JCVideoPlayer) findViewById(R.id.video);

        videoController.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
                "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
    }
}

package com.example.administrator.pandachannels.fragmentculture.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.administrator.pandachannels.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class WenActivity extends AppCompatActivity {


    private JCVideoPlayer videoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wen);
        initView();

        initData();

    }

    private void initData() {

    }

    private void initView() {
        videoController = (JCVideoPlayer) findViewById(R.id.video);

        videoController.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
                "《特别节目》我们的友谊去那里");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}

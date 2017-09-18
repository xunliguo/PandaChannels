package com.example.administrator.pandachannels.fragmenthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeShiping;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.administrator.pandachannels.framework.utils.Urls;
import com.google.gson.Gson;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class Video extends AppCompatActivity {

    private VideoView video;
    private HomeShiping homeShiping;
    private JCVideoPlayer jcvideoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video);
        initView();

    }
    private void initView() {
        jcvideoplayer = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        String homelunbo = getIntent().getStringExtra("homeflunbo");
        final String homeTitile = getIntent().getStringExtra("homeTitile");
        OkHttpUtils.getInstance().getNetData(Urls.VIDEOPLAY + homelunbo, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                homeShiping = new Gson().fromJson(ss, HomeShiping.class);
                final String str = homeShiping.getVideo().getChapters().get(0).getUrl();
                System.out.println(str+"aaa");
                Log.e("AAAAA",str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        jcvideoplayer.setUp(str,homeTitile);
                    }
                });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}

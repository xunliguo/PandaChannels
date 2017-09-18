package com.example.administrator.pandachannels.fragmenthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.Livehome;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Homelive extends AppCompatActivity {

    private JCVideoPlayer homeocontroller1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_homelive);
        initView();
    }

    private void initView() {
        homeocontroller1 = (JCVideoPlayer) findViewById(R.id.homeocontroller1);
        final String livehome = getIntent().getStringExtra("livehome");
        final String livetitle = getIntent().getStringExtra("livetitle");
        final String str="http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+livehome+"&amp;client=androidapp";
        OkHttpUtils.getInstance().getNetData(str, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Livehome live = new Gson().fromJson(ss, Livehome.class);
                final String s=live.getHls_url().getHls1();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeocontroller1.setUp(s,livetitle);
                    }
                });
            }
        });
    }
//hhhh
    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}

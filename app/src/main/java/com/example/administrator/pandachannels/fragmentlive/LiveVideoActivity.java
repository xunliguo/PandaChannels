package com.example.administrator.pandachannels.fragmentlive;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.model.entity.LivedeoBean;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class LiveVideoActivity extends AppCompatActivity implements View.OnClickListener {
    public String urls = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    private VideoView vitamio_viedoview;
    private String url1;
    private JCVideoPlayer jCVideoPlayer;
    private String title;
    private ImageView live_videolist;
    private ImageView live_collection;
    private ImageView livepanda_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {
        OkHttpUtils.getInstance().getNetData(urls + url1, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson = new Gson();
                LivedeoBean livedeoBean = gson.fromJson(ss, LivedeoBean.class);
                LivedeoBean.VideoBean video = livedeoBean.getVideo();
                List<LivedeoBean.VideoBean.ChaptersBean> chapters = video.getChapters();
                String url = chapters.get(0).getUrl();
                String image = chapters.get(0).getImage();


                jCVideoPlayer.setUp(url, title);
            }
        });


    }

    private void initView() {
        Intent intent = getIntent();
        url1 = intent.getStringExtra("url");
        title = intent.getStringExtra("title");


        Log.e("TAG", "=============>" + url1);
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller1);


        live_videolist = (ImageView) findViewById(R.id.live_videolist);
        live_videolist.setOnClickListener(this);
        live_collection = (ImageView) findViewById(R.id.live_collection);
        live_collection.setOnClickListener(this);
        livepanda_share = (ImageView) findViewById(R.id.livepanda_share);
        livepanda_share.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        jCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View view) {
          switch (view.getId()){
            case   R.id.live_videolist:
                Toast.makeText(this, "没有更多了", Toast.LENGTH_SHORT).show();
              break;
              case R.id.live_collection:
                  live_collection.setImageResource(R.mipmap.collect_yes);
                  break;
              case R.id.livepanda_share:


          }
    }
}


package com.example.administrator.pandachannels.fragmentlive;


import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmentlive.model.entity.LivedeoBean;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;
import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class LiveVideoActivity extends AppCompatActivity implements View.OnClickListener {
    public String urls = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";

    private String url1;
    private JCVideoPlayer jCVideoPlayer;
    private String title;
    private ImageView live_videolist;
    private ImageView live_collection;
    private ImageView livepanda_share;
    private String liveimage;
    private String url;
  private int a=0;
    int aa = 0;
    private StudentsDao studentsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
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
                url = chapters.get(0).getUrl();
                liveimage = chapters.get(0).getImage() ;


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
                  switch (a){
                      case 0:
                          a=1;
                          live_collection.setImageResource(R.mipmap.collect_yes);
                          Toast toast=Toast.makeText(LiveVideoActivity.this,"已添加，请到【我的收藏中查看】",Toast.LENGTH_SHORT);
                          toast.setGravity(Gravity.CENTER, 0, 0);
                          toast.show();
                          if (aa == 0) {
                              DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(LiveVideoActivity.this, "aa.db", null);
                              DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
                              DaoSession daoSession = daoMaster.newSession();
                              studentsDao = daoSession.getStudentsDao();
                              studentsDao.queryBuilder().build().list();
                              studentsDao.insert(new Students(null, 0, title, liveimage));
                              Toast.makeText(LiveVideoActivity.this, "已收藏，请到【我的收藏】中查看", Toast.LENGTH_SHORT).show();

                              live_collection.setImageResource(R.drawable.collect_yes);
                              aa = 1;
                          }else {
                    /*Students stu1 = studentsDao.queryBuilder().where(StudentsDao.Properties.Title.eq(homeTitile)).build().unique();//查询单
                    if (stu1 != null) {
                        studentsDao.delete(stu1);
                    }*/
                              live_collection.setImageResource(R.drawable.collect_no);
                              Toast.makeText(LiveVideoActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                              aa = 0;
                          }

                          break;
                      case 1:
                          a=0;
                          live_collection.setImageResource(R.mipmap.collect_no);
                          Toast toast1=Toast.makeText(LiveVideoActivity.this,"已取消收藏",Toast.LENGTH_SHORT);
                          toast1.setGravity(Gravity.CENTER, 0, 0);
                          toast1.show();
                  }




                  break;
              case R.id.livepanda_share:

             share();

                  break;
          }
    }

    private void  share(){
        UMImage thumimage = new UMImage(LiveVideoActivity.this, liveimage);
        UMVideo video = new UMVideo(url);
        video.setTitle(title);//视频的标题
        video.setThumb(thumimage);//视频的缩略图
        video.setDescription("熊猫频道");//视频的描述




        new ShareAction(LiveVideoActivity.this)
                .withMedia(video).setPlatform(SHARE_MEDIA.QQ)
                .setCallback(shareListener)
                .share();

    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(LiveVideoActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(LiveVideoActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(LiveVideoActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}


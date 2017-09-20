package com.example.administrator.pandachannels.fragmentobserve.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener,UMShareListener {


    private JCVideoPlayer shi_video;
    private String name;
    int a=1;
    private ImageView video_three;
    private ImageView video_two;
    private ImageView video_share;
   String str="http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        initView();
        initData();
        //name = getIntent().getStringExtra("name");
    }

    private void initData() {

        shi_video.setUp(str, "熊猫特播");
    }

    private void initView() {
        shi_video = (JCVideoPlayer) findViewById(R.id.shi_video);
        video_three = (ImageView) findViewById(R.id.video_three);
        video_three.setOnClickListener(this);
        video_two = (ImageView) findViewById(R.id.video_two);
        video_two.setOnClickListener(this);
        video_share = (ImageView) findViewById(R.id.video_share);
        video_share.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video_share:
                share();
                break;
            case R.id.video_two:
                if (a == 0) {
                    video_two.setImageResource(R.drawable.collect_yes);
                    a = 1;
                    Toast.makeText(this, "已收藏，请到[我的收藏]去查看", Toast.LENGTH_SHORT).show();
                } else {
                    video_two.setImageResource(R.drawable.collect_no);
                    a = 0;
                    Toast.makeText(this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.video_three:
                break;
        }

    }

    private void share() {
        UMImage thumb = new UMImage(this, R.mipmap.ic_launcher);
        UMWeb web = new UMWeb(str);
        web.setTitle("熊猫特播");//标题
        new ShareAction(VideoActivity.this)
                .withMedia(web).setPlatform(SHARE_MEDIA.QQ)
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
            Toast.makeText(VideoActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VideoActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(VideoActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
}

package com.example.administrator.pandachannels.fragmentobserve.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

public class WebActivity extends AppCompatActivity implements View.OnClickListener, UMShareListener {

    private WebView webview;
    private ImageView web_cang;
    private ImageView web_fen;
    private ImageView web_img_s;
    int a = 0;
    private String url;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        webview.loadUrl(url);
    }

    private void initView() {
        web_img_s = (ImageView) findViewById(R.id.web_img_s);
        webview = (WebView) findViewById(R.id.webview);
        web_cang = (ImageView) findViewById(R.id.web_cang);
        web_fen = (ImageView) findViewById(R.id.web_fen);
        web_fen.setOnClickListener(this);
        web_cang.setOnClickListener(this);
        web_img_s.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.web_cang:
                if (a == 0) {
                    web_cang.setImageResource(R.drawable.collect_yes);
                    a = 1;
                    Toast.makeText(this, "已收藏，请到[我的收藏]去查看", Toast.LENGTH_SHORT).show();
                } else {
                    web_cang.setImageResource(R.drawable.collect_no);
                    a = 0;
                    Toast.makeText(this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.web_fen:

                share();
//                Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show();
//                UMWeb web = new UMWeb(url);
//                web.setTitle(title);
//                new ShareAction(WebActivity.this)
//                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
//                        .withMedia(web)//分享内容
//                        .setCallback(WebActivity.this)//回调监听器
//                        .share();
                break;
            case R.id.web_img_s:
                finish();

                break;
        }
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {
        //开始
    }

    private void share() {
        UMImage thumb = new UMImage(this, R.mipmap.ic_launcher
        );
        UMWeb web = new UMWeb(url);
        web.setTitle(title);//标题


        new ShareAction(WebActivity.this)
                .withMedia(web).setPlatform(SHARE_MEDIA.QQ)
                .setCallback(shareListener)
                .share();


    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        //结果
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
            Toast.makeText(WebActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(WebActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(WebActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        //失败
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        //取消
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}

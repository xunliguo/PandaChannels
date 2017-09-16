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

                UMWeb web = new UMWeb(url);
                web.setTitle(title);
                new ShareAction(WebActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(web)//分享内容
                        .setCallback(WebActivity.this)//回调监听器
                        .share();
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

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        //结果
    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        //失败
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        //取消
    }
}

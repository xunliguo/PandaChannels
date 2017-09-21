package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Set;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logimh;
    private TextView logreg;
    private RadioButton login_weixin;
    private RadioButton login_qqq;
    private RadioButton login_weibo;
    private EditText shoujihao;
    private EditText mima;
    private TextView forget_pass;
    private Button denglu;
    private ImageView qqlogo;
    private Button dengli_xun;
    private Button loginxx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author_xun);
        initView();
    }

    private void initView() {

        qqlogo = (ImageView) findViewById(R.id.qqlogo);
        qqlogo.setOnClickListener(this);
        dengli_xun = (Button) findViewById(R.id.shouquan);
        dengli_xun.setOnClickListener(this);
        loginxx = (Button) findViewById(R.id.loginxx);
        loginxx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouquan:
               UMShareAPI.get(this).doOauthVerify(LogInActivity.this, SHARE_MEDIA.QQ, authListener);
                 //  UMShareAPI.get(this).getPlatformInfo(LogInActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.loginxx:

           UMShareAPI.get(this).getPlatformInfo(LogInActivity.this, SHARE_MEDIA.QQ, umAuthListener);

                break;
        }


    }
    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Log.e("demo",data+"=================2<");
            Set<String> strings = data.keySet();

            for (String string:strings){
                //获取头像url
                if (string.equals("profile_image_url")){
                   String image_url = data.get(string);

                    Log.e("TAG", "image_url:"+image_url);
                }

                //获取昵称
                if (string.equals("screen_name")){
                   String  name = data.get(string);
                }

               /* Glide.with(PersonalCenterActivity.this).load(image_url).into(prPhp);
                prName.setText(name);*/
            }

            Toast.makeText(LogInActivity.this, "成功了你没", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LogInActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

            Toast.makeText(LogInActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }














}

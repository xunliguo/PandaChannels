package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class CentreActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout shi_login;
    private LinearLayout shi_history;
    private LinearLayout shi_collect;
    private LinearLayout shi_set;
    private ImageView back;
    private ImageView head_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

        setContentView(R.layout.login);
        initView();
    }

    private void initView() {
        //login 登录
        shi_login = (LinearLayout) findViewById(R.id.shi_login);
        //history 历史
        shi_history = (LinearLayout) findViewById(R.id.shi_history);
        //collect 收藏
        shi_collect = (LinearLayout) findViewById(R.id.shi_collect);
        //set 设置
        shi_set = (LinearLayout) findViewById(R.id.shi_set);
        head_image = (ImageView) findViewById(R.id.head_image);
        back = (ImageView) findViewById(R.id.back);

        shi_login.setOnClickListener(this);
        shi_history.setOnClickListener(this);
        shi_collect.setOnClickListener(this);
        shi_set.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shi_login:  //login 登录
                Intent intent_login=new Intent(CentreActivity.this,LogInActivity.class);
                startActivity(intent_login);

                break;
            case R.id.shi_history: //history 历史
                Intent intent_history=new Intent(CentreActivity.this,HistoryActivity.class);
                startActivity(intent_history);
                break;
            case R.id.shi_collect://collect 收藏
                  Intent intent_collect=new Intent(CentreActivity.this,CollectActivity.class);
                startActivity(intent_collect);
                break;
            case R.id.shi_set://set 设置
                Intent intent_set=new Intent(CentreActivity.this,SetActivity.class);
                startActivity(intent_set);
                break;
            case R.id.back:
                finish();
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

            Toast.makeText(CentreActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(CentreActivity.this, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(CentreActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

}

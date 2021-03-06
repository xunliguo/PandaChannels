package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class CentreActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout shi_login;
    private LinearLayout shi_history;
    private LinearLayout shi_collect;
    private LinearLayout shi_set;
    private ImageView back;
    private ImageView head_image;
    private ImageView headimage;
    private TextView headname;
    private  boolean islogin=false;
    private  int a=0;
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
        headimage = (ImageView) findViewById(R.id.head_image);
        headname = (TextView) findViewById(R.id.head_name);
        shi_login.setOnClickListener(this);
        shi_history.setOnClickListener(this);
        shi_collect.setOnClickListener(this);
        shi_set.setOnClickListener(this);
        back.setOnClickListener(this);
        long l = System.currentTimeMillis();
        shi_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a==0){
                    UMShareAPI.get(CentreActivity.this).getPlatformInfo(CentreActivity.this, SHARE_MEDIA.QQ, authListener);

                    a=1;
                }else {
                    Toast.makeText(CentreActivity.this, "已是登录状态无需登录", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

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
            Log.e("TAG","======>"+data);
            Toast.makeText(CentreActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            String expiration = data.get("expiration");

            String name = data.get("name");
            String iconurl = data.get("iconurl");
            SharedPreferences sp = getSharedPreferences("seeeting", Activity.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("name",name);
            edit.putString("imagehead",iconurl);
            edit.putString("token",expiration);
            edit.commit();
            Glide.with(CentreActivity.this).load(iconurl).into(head_image);
            headname.setText(name);



        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(CentreActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}

package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initquanxian();
        initView();
    }

    private void initView() {
        logimh = (ImageView) findViewById(R.id.logimh);
        logreg = (TextView) findViewById(R.id.logreg);
        login_weixin = (RadioButton) findViewById(R.id.login_weixin);
        login_qqq = (RadioButton) findViewById(R.id.login_qqq);
        login_weibo = (RadioButton) findViewById(R.id.login_weibo);
        shoujihao = (EditText) findViewById(R.id.shoujihao);
        mima = (EditText) findViewById(R.id.mima);
        forget_pass = (TextView) findViewById(R.id.forget_pass);
        denglu = (Button) findViewById(R.id.denglu);

        shoujihao.setOnClickListener(this);
        mima.setOnClickListener(this);
        denglu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shoujihao:



                break;
            case R.id.mima:

                break;
            case R.id.denglu:

                break;
            case R.id.login_qqq:
                //QQ登录
                UMShareAPI.get(LogInActivity.this).getPlatformInfo(LogInActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });

                break;
        }
    }

    private void submit() {
        // validate
        String shoujihaoString = shoujihao.getText().toString().trim();
        if (TextUtils.isEmpty(shoujihaoString)) {
            Toast.makeText(this, "账号：请输入邮箱或手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String mimaString = mima.getText().toString().trim();
        if (TextUtils.isEmpty(mimaString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    private void initquanxian() {
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            boolean b = checkPermission(mPermissionList);
            if(b){
                //执行业务代码
            }else{
                ActivityCompat.requestPermissions(this,mPermissionList,123);
            }
        }

    }
    //=============================================================2
    public boolean checkPermission(String[] permission){
        for(String p:permission){
            if(ContextCompat.checkSelfPermission(this,p)== PackageManager.PERMISSION_GRANTED){
                return true;
            }
        }
        return false;
    }
    //===================================================================3.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i("TAG",grantResults.toString());
        boolean b = checkPermission(permissions);
        if(true){
            //业务代码
        }else{
            finish();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}

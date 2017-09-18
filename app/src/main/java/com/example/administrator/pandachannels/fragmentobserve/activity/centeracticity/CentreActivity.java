package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.pandachannels.R;

public class CentreActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout shi_login;
    private LinearLayout shi_history;
    private LinearLayout shi_collect;
    private LinearLayout shi_set;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}

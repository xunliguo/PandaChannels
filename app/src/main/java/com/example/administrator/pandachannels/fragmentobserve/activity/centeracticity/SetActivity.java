package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity.setactivity.SetOneActivity;
import com.zhy.android.percent.support.PercentRelativeLayout;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView set_back;
    private CheckBox accept_box;
    private CheckBox automatic_box;
    private TextView laji;
    private PercentRelativeLayout clear;
    private PercentRelativeLayout user_tickling;
    private PercentRelativeLayout upgrade;
    private PercentRelativeLayout goodreputation;
    private PercentRelativeLayout about_pandachannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }

    private void initView() {
        set_back = (ImageView) findViewById(R.id.set_back);
        accept_box = (CheckBox) findViewById(R.id.accept_box);
        automatic_box = (CheckBox) findViewById(R.id.automatic_box);
        laji = (TextView) findViewById(R.id.laji);
        clear = (PercentRelativeLayout) findViewById(R.id.clear);
        user_tickling = (PercentRelativeLayout) findViewById(R.id.user_tickling);
        upgrade = (PercentRelativeLayout) findViewById(R.id.upgrade);
        goodreputation = (PercentRelativeLayout) findViewById(R.id.goodreputation);
        about_pandachannel = (PercentRelativeLayout) findViewById(R.id.about_pandachannel);

        set_back.setOnClickListener(this);
        accept_box.setOnClickListener(this);
        automatic_box.setOnClickListener(this);
        laji.setOnClickListener(this);
        clear.setOnClickListener(this);
        user_tickling.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        goodreputation.setOnClickListener(this);
        about_pandachannel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.set_back:
                finish();
                break;
            case R.id.accept_box:
                break;
            case R.id.automatic_box:
                break;
            case R.id.laji:
                break;
            case R.id.clear:

                final AlertDialog dialog = new AlertDialog.Builder(this).create();
                View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_layout,null);
                TextView message = (TextView) inflate.findViewById(R.id.message);
                Button quxiao_butt = (Button) inflate.findViewById(R.id.quxiao_butt);
                Button quedin_butt = (Button) inflate.findViewById(R.id.quedin_butt);
                message.setText("确认清楚缓存吗？");
                quedin_butt.setTextColor(Color.parseColor("#d1d0d0"));
                dialog.setView(inflate);
                quedin_butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        laji.setText("0.00M");
                        dialog.dismiss();
                    }
                });
                quxiao_butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                dialog.show();

                break;
            case R.id.user_tickling:

                Intent intent=new Intent(SetActivity.this,SetOneActivity.class);
                startActivity(intent);
                break;
            case R.id.upgrade:

                final ProgressDialog dialog1 = new ProgressDialog(this);
                dialog1.show();
                dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(SetActivity.this, "已是最新版本", Toast.LENGTH_SHORT).show();
                                dialog1.dismiss();
                            }

                        });

                    }
                }).start();

                break;
            case R.id.goodreputation:
                break;
            case R.id.about_pandachannel:
                break;
        }

    }
}

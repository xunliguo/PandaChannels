package com.example.administrator.pandachannels;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.fragmentchinese.Fragment_Chinese;
import com.example.administrator.pandachannels.fragmentculture.Fragment_culture;
import com.example.administrator.pandachannels.fragmenthome.Fragment_home;
import com.example.administrator.pandachannels.fragmenthome.Original;
import com.example.administrator.pandachannels.fragmentlive.Fragment_live;
import com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity.CentreActivity;
import com.example.administrator.pandachannels.fragmentobserve.fragemnt.Fragment_observe;
import com.example.administrator.pandachannels.framework.baseview.BaseActivity;
import com.example.administrator.pandachannels.framework.utils.Netwoke;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout framlayout;
    private RadioButton rb_01;
    private RadioButton rb_02;
    private RadioButton rb_03;
    private RadioButton rb_04;
    private RadioButton rb_05;
    private Fragment_home fragment1;
    private Fragment_observe fragment2;
    private Fragment_culture fragment3;
    private Fragment_live fragment4;
    private Fragment_Chinese fragment5;
    private TextView text;
    private ImageView image1;
    private ImageView image3;
    private ImageView imageView;
    private long firstTime = 0;
    private ImageView image;
    private Netwoke netwoke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        getlayoutID();
        initView();
        initShowFisrtFragment();//默认显示第一个Fragment
        initData();
    }

    private void initShowFisrtFragment() {
        //动态添加Fragment ,获取Fragment 管理器
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        image3.setVisibility(View.VISIBLE);
        image1.setVisibility(View.VISIBLE);
        text.setText("  ");
        if (fragment1 == null) {
            fragment1 = new Fragment_home();
            transaction.add(R.id.framlayout, fragment1);
        } else {
            transaction.show(fragment1);
        }
        transaction.commit();
    }

    @Override
    protected void initData() {
        getnetwoke();
    }

    private void getnetwoke() {
        if (netwoke == null) {
            netwoke = new Netwoke();
        }

        String getnetwoke = netwoke.getnetwoke(HomeActivity.this);

        Toast.makeText(HomeActivity.this, getnetwoke, Toast.LENGTH_SHORT).show();

        if (getnetwoke.equals("网络无连接")) {
            setNetwork();
        }
 if (!getnetwoke.equals("网络无连接")&&!getnetwoke.equals("WIFI")) {
            setNetwork2();
        }


    }

    private void setNetwork2() {
         final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("您正在使用移动数据网络，所产生的流量费由当地运营商收取，是否继续？");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

            }

        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {


            }

        });

        builder.create();

        builder.show();

    }

    private void setNetwork() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.mipmap.logo_ipnda);

        builder.setMessage("您的网络未连接，如果继续，请先设置网络！");

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Intent intent = null;

                /**

                 * 判断手机系统的版本！如果API大于10 就是3.0+

                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同

                 */

                if (Build.VERSION.SDK_INT > 10) {

                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);

                } else {

                    intent = new Intent();

                    ComponentName component = new ComponentName(

                            "com.android.settings",

                            "com.android.settings.WirelessSettings");

                    intent.setComponent(component);

                    intent.setAction("android.intent.action.VIEW");

                }

                startActivity(intent);

            }

        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {


            }

        });

        builder.create();

        builder.show();

    }

    @Override
    protected void initClick() {

    }

    @Override
    protected void initView() {

        framlayout = (FrameLayout) findViewById(R.id.framlayout);

        rb_01 = (RadioButton) findViewById(R.id.rb_01);
        rb_01.setOnClickListener(this);
        rb_02 = (RadioButton) findViewById(R.id.rb_02);
        rb_02.setOnClickListener(this);
        rb_03 = (RadioButton) findViewById(R.id.rb_03);
        rb_03.setOnClickListener(this);
        rb_04 = (RadioButton) findViewById(R.id.rb_04);
        rb_04.setOnClickListener(this);
        rb_05 = (RadioButton) findViewById(R.id.rb_05);
        rb_05.setOnClickListener(this);

        text = (TextView) findViewById(R.id.text);
        image1 = (ImageView) findViewById(R.id.image1);
        image3 = (ImageView) findViewById(R.id.image3);
        image = (ImageView) findViewById(R.id.image);
        //点击登录
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, CentreActivity.class);
                startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Original.class));
            }
        });
    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {
        //动态添加Fragment ,获取Fragment 管理器
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        switch (v.getId()) {
            case R.id.rb_01:
                image3.setVisibility(View.VISIBLE);
                image1.setVisibility(View.VISIBLE);
                text.setText("  ");

                if (fragment1 == null) {
                    fragment1 = new Fragment_home();
                    transaction.add(R.id.framlayout, fragment1);
                } else {
                    transaction.show(fragment1);
                }


                break;
            case R.id.rb_02:
                image3.setVisibility(View.INVISIBLE);
                text.setText("熊猫直播");
                image1.setVisibility(View.GONE);

                if (fragment4 == null) {
                    fragment4 = new Fragment_live();
                    transaction.add(R.id.framlayout, fragment4);
                } else {
                    transaction.show(fragment4);
                }

                break;
            case R.id.rb_03:
                image3.setVisibility(View.INVISIBLE);
                text.setText("滚滚视频");
                image1.setVisibility(View.GONE);
                if (fragment3 == null) {
                    fragment3 = new Fragment_culture();
                    transaction.add(R.id.framlayout, fragment3);
                } else {
                    transaction.show(fragment3);
                }

                break;
            case R.id.rb_04:
                image3.setVisibility(View.INVISIBLE);
                text.setText("熊猫播报");
                image1.setVisibility(View.GONE);
                if (fragment2 == null) {
                    fragment2 = new Fragment_observe();
                    transaction.add(R.id.framlayout, fragment2);
                } else {
                    transaction.show(fragment2);
                }

                break;
            case R.id.rb_05:
                image3.setVisibility(View.INVISIBLE);
                text.setText("直播中国");
                image1.setVisibility(View.GONE);
                if (fragment5 == null) {
                    fragment5 = new Fragment_Chinese();
                    transaction.add(R.id.framlayout, fragment5);
                } else {
                    transaction.show(fragment5);
                }
                break;
        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        if (fragment3 != null) {
            transaction.hide(fragment3);
        }
        if (fragment4 != null) {
            transaction.hide(fragment4);
        }
        if (fragment5 != null) {
            transaction.hide(fragment5);
        }

    }
    //对返回键进行监听
    private static boolean isExit = false;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "连续点击两次退出应用！",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }


}

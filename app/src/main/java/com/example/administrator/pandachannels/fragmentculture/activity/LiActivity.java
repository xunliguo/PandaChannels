package com.example.administrator.pandachannels.fragmentculture.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentculture.fragment.PerfectFragment;
import com.example.administrator.pandachannels.fragmentculture.fragment.HinghtFragment;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class LiActivity extends AppCompatActivity implements View.OnClickListener,UMShareListener {


    private ImageView li_img;
    private TextView li_text;
    private ImageView li_image;
    private ImageView li_imageview;
    private ImageView li_fan;
    int a = 0;
    private String title;
    private TextView li_tv;
    private String url;
    private JCVideoPlayer jCVideoPlayer;
    private ViewPager viewpagers;
    private TabLayout tab;
    List<Fragment> fragmentList=new ArrayList<Fragment>();
    List<String> titleList=new ArrayList<String>();

    private boolean isImageview = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li);
        initView();

        //接受传值
        Intent intent=getIntent();
        title = intent.getStringExtra("title");
        url = intent.getStringExtra("url");
        li_tv.setText(title);

    }


    private void initView() {
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.video);
        jCVideoPlayer.setUp("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4",
                "熊猫");
        li_img = (ImageView) findViewById(R.id.li_img);
        li_fan = (ImageView) findViewById(R.id.li_fan);
        li_text= (TextView) findViewById(R.id.li_text);
        li_image = (ImageView) findViewById(R.id.li_image);
        li_imageview = (ImageView) findViewById(R.id.li_imageview);
        li_tv= (TextView) findViewById(R.id.li_tv);
        tab= (TabLayout) findViewById(R.id.tab);
        viewpagers = (ViewPager) findViewById(R.id.viewpagers);
        li_img.setOnClickListener(this);
        li_image.setOnClickListener(this);
        li_imageview.setOnClickListener(this);
        li_fan.setOnClickListener(this);
        initTitles();
        tab.addTab(tab.newTab().setText(titleList.get(0)));
        tab.addTab(tab.newTab().setText(titleList.get(1)));
        initFragmets();

        MyAdapters ada=new MyAdapters(getSupportFragmentManager());
        viewpagers.setAdapter(ada);
        tab.setupWithViewPager(viewpagers);


    }


    private void initTitles() {
        titleList.add("高清完整");
        titleList.add("精彩看点");
    }

    private void initFragmets() {
        fragmentList.add(new HinghtFragment());
        fragmentList.add(new PerfectFragment());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.li_img:


                if(isImageview){
                    li_text.setVisibility(View.VISIBLE);
                    isImageview = false;
                }else {
                    li_text.setVisibility(View.GONE);
                    isImageview = true;
                }

                break;
            case R.id.li_image:

                if (a == 0) {
                    li_image.setImageResource(R.drawable.collect_yes);
                    a = 1;
                    Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT).show();

                } else {
                    li_image.setImageResource(R.drawable.collect_no);
                    a = 1;
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.li_imageview:
                //分享
                UMWeb web = new UMWeb(url);
                web.setTitle(title);
                new ShareAction(LiActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withText("hello")//分享内容
                        .withMedia(web)
                        .setCallback(LiActivity.this)//回调监听器
                        .share();

                break;
            case R.id.li_fan:
                finish();
                break;
        }
    }


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


    private class MyAdapters extends FragmentPagerAdapter {
        public MyAdapters(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}

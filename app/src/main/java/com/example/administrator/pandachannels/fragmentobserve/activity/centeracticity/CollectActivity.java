package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentobserve.fragemnt.collectfrgment.KanDianFragment;
import com.example.administrator.pandachannels.fragmentobserve.fragemnt.collectfrgment.ZhiBoFragment;

import java.util.ArrayList;

public class CollectActivity extends AppCompatActivity {

    private TabLayout shi_tab;
    private ArrayList<String> shi_list = new ArrayList<>();
    private ArrayList<Fragment> fraglist = new ArrayList<>();
    private ViewPager shi_pager;
    private ImageView shi_collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();
        initData();
    }

    private void initData() {
        shi_list.add("直播");
        shi_list.add("精彩看点");

        ZhiBoFragment zhiBoFragment=new ZhiBoFragment();
        KanDianFragment kanDianFragment=new KanDianFragment();
        fraglist.add(zhiBoFragment);
        fraglist.add(kanDianFragment);

        shi_tab.addTab(shi_tab.newTab().setText(shi_list.get(0)));
        shi_tab.addTab(shi_tab.newTab().setText(shi_list.get(1)));

        MpagerAdapter adapter = new MpagerAdapter(getSupportFragmentManager());
        shi_pager.setAdapter(adapter);
        //设置viewpager不能滑动
        shi_pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        shi_pager.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        shi_pager.requestDisallowInterceptTouchEvent(false);
                    default:
                        break;
                }
                return true;
            }
        });

           shi_collect.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   finish();
               }
           });

    }

    private void initView() {
        shi_tab = (TabLayout) findViewById(R.id.shi_tab);
        shi_pager = (ViewPager) findViewById(R.id.shi_pager);
        shi_collect = (ImageView) findViewById(R.id.shi_collect);
    }

    private class MpagerAdapter extends FragmentPagerAdapter{
        public MpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fraglist.get(position);
        }

        @Override
        public int getCount() {
            return fraglist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return shi_list.get(position);
        }
    }
}

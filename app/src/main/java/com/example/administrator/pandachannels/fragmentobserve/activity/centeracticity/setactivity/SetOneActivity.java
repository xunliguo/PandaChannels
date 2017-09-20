package com.example.administrator.pandachannels.fragmentobserve.activity.centeracticity.setactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentobserve.fragemnt.setfragment.SetOneFragment;
import com.example.administrator.pandachannels.fragmentobserve.fragemnt.setfragment.SetTwoFragment;

import java.util.ArrayList;

public class  SetOneActivity extends AppCompatActivity {
    private ArrayList<String> set_list = new ArrayList<>();
    private ArrayList<Fragment> set_frag = new ArrayList<>();
    private ImageView set_one_back;
    private TabLayout set_one_tab;
    private ViewPager set_one_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_one);
        initView();
        initDaat();
    }

    private void initDaat() {
        set_list.add("遇见的问题");
        set_list.add("常见问题");
        set_one_tab.addTab(set_one_tab.newTab().setText(set_list.get(0)));
        set_one_tab.addTab(set_one_tab.newTab().setText(set_list.get(1)));
        SetOneFragment one=new SetOneFragment();
        SetTwoFragment two=new SetTwoFragment();
        set_frag.add(one);
        set_frag.add(two);

        SetsPagerAdapter adap=new SetsPagerAdapter(getSupportFragmentManager());
        set_one_tab.setupWithViewPager(set_one_pager);
        set_one_pager.setAdapter(adap);

    }

    private void initView() {
        set_one_back = (ImageView) findViewById(R.id.set_one_back);
        set_one_tab = (TabLayout) findViewById(R.id.set_one_tab);
        set_one_pager = (ViewPager) findViewById(R.id.set_one_pager);
        set_one_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private class SetsPagerAdapter extends FragmentPagerAdapter{
        public SetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return set_frag.get(position);
        }

        @Override
        public int getCount() {
            return set_frag.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return set_list.get(position);
        }
    }
}

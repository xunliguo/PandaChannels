package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class FragmentAdapters extends FragmentPagerAdapter {
    private List<Fragment>  mlist=new ArrayList<>();
    private  List<String> list=new ArrayList<>();

    public FragmentAdapters(FragmentManager fm,List<Fragment> mlist) {
        super(fm);
        this.mlist=mlist;
        list.add("直播");
        list.add("精彩一刻");
        list.add("当熊不让");
        list.add("超萌滚滚秀");
        list.add("熊猫档案");
        list.add("熊猫TOP榜");
        list.add("熊猫那些事");
        list.add("特别节目");

        list.add("原创新闻");



    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}

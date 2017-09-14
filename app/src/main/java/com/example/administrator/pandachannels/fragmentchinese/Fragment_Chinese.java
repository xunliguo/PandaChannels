package com.example.administrator.pandachannels.fragmentchinese;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.Funghwang_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountEmei_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountHang_fragment;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.MountTai_fragment;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;

import java.util.ArrayList;

public class Fragment_Chinese extends BaseFragment implements View.OnClickListener {


    private ImageView img_persion;
    private ImageView img_add;
    private TabLayout tablayout_chinese;
    private ViewPager viewpager_chinese;

    ArrayList<String> titlelist = new ArrayList<>();
    ArrayList<Fragment> framlist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment like bottom ... and run LayoutCreator again
        View view = View.inflate(getActivity(), R.layout.fragment_fragment__chinese, null);
        initView(view);
        initData();
        return view;
    }

    @Override
    protected void initView(View view) {

//        img_persion = (ImageView) view.findViewById(R.id.img_persion);
//        img_persion.setOnClickListener(this);
        img_add = (ImageView) view.findViewById(R.id.img_add);
        img_add.setOnClickListener(this);
        tablayout_chinese = (TabLayout) view.findViewById(R.id.tablayout_chinese);
        viewpager_chinese = (ViewPager) view.findViewById(R.id.viewpager_chinese);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment__chinese;
    }

    @Override
    protected void initData() {
        titlelist.add("泰山");
        titlelist.add("黄山");
        titlelist.add("凤凰古城");
        titlelist.add("峨眉山");
//titlelist.add("张家界");
//titlelist.add("黄果树");
//titlelist.add("天涯海角");
//titlelist.add("中央电视塔");
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(0)));
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(1)));
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(2)));
        tablayout_chinese.addTab(tablayout_chinese.newTab().setText(titlelist.get(3)));
framlist.add(new MountTai_fragment());
framlist.add(new MountHang_fragment());
framlist.add(new Funghwang_fragment());
framlist.add(new MountEmei_fragment());

        Myadap myadap=new Myadap(getFragmentManager());
        tablayout_chinese.setupWithViewPager(viewpager_chinese);
        viewpager_chinese.setAdapter(myadap);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.img_persion:
//                Toast.makeText(getActivity(), "个人中心", Toast.LENGTH_SHORT).show();
//
//                break;
            case R.id.img_add:
                Toast.makeText(getActivity(), "添加", Toast.LENGTH_SHORT).show();
                break;

        }
    }


    private class Myadap  extends FragmentPagerAdapter{
        public Myadap(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return framlist.get(position);
        }

        @Override
        public int getCount() {
            return framlist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }
    }
}

package com.example.administrator.pandachannels.fragmentlive;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.adapter.FragmentAdapters;
import com.example.administrator.pandachannels.fragmentlive.fragment.Burang_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.Original_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.PanadafileFrament;
import com.example.administrator.pandachannels.fragmentlive.fragment.Specs_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.Supercute_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.Thatthing_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.Top_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.Wonderful_fragment;
import com.example.administrator.pandachannels.fragmentlive.fragment.Xianlive_subfragment;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_live extends BaseFragment implements MainContract.SubView {
private List<Fragment> mlist=new ArrayList<>();
    private ViewPager viewpager;
    private TabLayout tabLayout;


    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_live;
    }

    @Override
    protected void initData() {
      mlist.add(new Xianlive_subfragment());
        mlist.add(new Wonderful_fragment());
        mlist.add(new Burang_fragment());
        mlist.add(new Supercute_fragment());
        mlist.add(new PanadafileFrament());
        mlist.add(new Top_fragment());
        mlist.add(new Thatthing_fragment());
        mlist.add(new Specs_fragment());
        mlist.add(new Original_fragment());

        FragmentPagerAdapter adapter=new FragmentAdapters(getChildFragmentManager(),mlist);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(8);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(View.SCROLLBAR_POSITION_DEFAULT);


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void showData(ArrayList<BeanTaishan.LiveBean> list) {

    }

    @Override
    public void showrror() {

    }

    @Override
    public void showDataChina(ArrayList<BeanChinese> list111) {

    }
}

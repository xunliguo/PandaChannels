package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter;

import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.framework.contract.MainContract;

import java.util.ArrayList;

/**
 * Author:111
 * Time:2017/9/17
 * Motto: where my heart get peace,where my self get home.
 */
public class Fragment_ChineseimplMain implements MainContract.SubPresenter {
    MainContract.SubView subview;
    ArrayList<BeanChinese.AlllistBean> list111=new ArrayList<>();
    ArrayList<BeanChinese.TablistBean> list222=new ArrayList<>();

//V层和P层关联起来
    public Fragment_ChineseimplMain(MainContract.SubView subview) {
        this.subview = subview;
    }

    @Override
    public void requsetData() {


    }
}

package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter;

import android.app.ProgressDialog;

import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:111
 * Time:2017/9/14
 * Motto: where my heart get peace,where my self get home.
 */                                   //实现P层接口，实现请求数据方法
public class SubPresenterimpl_MountTai implements MainContract.SubPresenter {
    MainContract.SubView subview;
    ArrayList<BeanTaishan.LiveBean> list = new ArrayList<>();
    String s;

    public SubPresenterimpl_MountTai(MainContract.SubView subview, String s) {
        this.subview = subview;
        this.s = s;
    }


    @Override
    public void requsetData() {

        OkHttpUtils.getInstance().getNetData(s, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                subview.showLoading();
                Gson gson = new Gson();
                BeanTaishan beanTaishan = gson.fromJson(ss, BeanTaishan.class);
                List<BeanTaishan.LiveBean> live = beanTaishan.getLive();
                list.addAll(live);
                //p层请求完数据，调用V层方法展示数据
                subview.showData(list);

                subview.dissmissLoading();
            }
        });

    }
}

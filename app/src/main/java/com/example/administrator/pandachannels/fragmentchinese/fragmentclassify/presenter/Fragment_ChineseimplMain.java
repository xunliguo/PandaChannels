package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter;

import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.fragmentchinese.Fragment_Chinese;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

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
    ArrayList<BeanChinese> list111=new ArrayList<>();

//V层和P层关联起来




    public Fragment_ChineseimplMain(MainContract.SubView subview) {
        this.subview=subview;
    }

    @Override
    public void requsetData() {

        OkHttpUtils.getInstance().getNetData("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                BeanChinese beanChinese = gson.fromJson(ss, BeanChinese.class);
               list111.add(beanChinese);
                subview.showDataChina(list111);



            }
        });

    }
}

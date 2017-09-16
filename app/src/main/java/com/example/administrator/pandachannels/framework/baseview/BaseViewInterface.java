package com.example.administrator.pandachannels.framework.baseview;

import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/13.
 */

public interface BaseViewInterface {
    void showLoading();

    void dissmissLoading();

    void showData(ArrayList<BeanTaishan.LiveBean> list);


    void  showrror();



}

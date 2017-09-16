package com.example.administrator.pandachannels.fragmenthome;

import com.example.administrator.pandachannels.fragmenthome.bean.PandaLiveBean;

/**
 * Created by lenovo on 2017/9/14.
 */
//阿萨德按时
public interface HomeViewInterface {
    void showLoading();

    void dissmissLoading();
    void  showDate(PandaLiveBean pandaLiveBean);
}

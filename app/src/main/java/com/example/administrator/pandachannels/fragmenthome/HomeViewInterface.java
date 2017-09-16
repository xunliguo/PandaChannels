package com.example.administrator.pandachannels.fragmenthome;

import com.example.administrator.pandachannels.fragmenthome.Bean.PandaLiveBean;

/**
 * Created by lenovo on 2017/9/14.
 */

public interface HomeViewInterface {
    void showLoading();

    void dissmissLoading();
    void  showDate(PandaLiveBean pandaLiveBean);

}

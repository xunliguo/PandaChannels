package com.example.administrator.pandachannels.framework.contract;

import com.example.administrator.pandachannels.fragmentobserve.ShiViewInterface;
import com.example.administrator.pandachannels.framework.basepresenter.BasePresenter;
import com.example.administrator.pandachannels.framework.baseview.BaseViewInterface;

/**
 * Created by Administrator on 2017/9/13.
 */
   //全局管理接口
public interface MainContract  {

    interface SubView extends BaseViewInterface{//定义V层子接口，

    }
    interface ShiView extends ShiViewInterface {

    }

    interface  SubPresenter extends BasePresenter{   //定义P层子接口，定义方法请求数据

    }

}

package com.example.administrator.pandachannels.framework.contract;

import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmenthome.HomeViewInterface;
import com.example.administrator.pandachannels.framework.basepresenter.BasePresenter;
import com.example.administrator.pandachannels.framework.baseview.BaseViewInterface;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
   //全局管理接口
public interface MainContract  {

    interface SubView extends BaseViewInterface{
        //定义V层子接口

    }
    interface  SubHome extends HomeViewInterface{

    }
    interface XSubView extends BaseViewInterface{//定义V层子接口，
       void   showDatas(PandaLiveBean pandaLiveBean);
       void   showDatas1(List<ManyBean.ListBean> list);
       void   showDatasWond(List<WondBean.VideoBean> videolist);
        void  showDataBurang();
    }

    interface  SubPresenter extends BasePresenter{   //定义P层子接口，定义方法请求数据

    }

}

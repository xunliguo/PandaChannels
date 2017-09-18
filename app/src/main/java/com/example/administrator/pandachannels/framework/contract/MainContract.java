package com.example.administrator.pandachannels.framework.contract;

import com.example.administrator.pandachannels.fragmentobserve.ShiViewInterface;
import com.example.administrator.pandachannels.fragmentculture.LiViewInterface;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.fragmenthome.HomeViewInterface;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.framework.basepresenter.BasePresenter;
import com.example.administrator.pandachannels.framework.baseview.BaseViewInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
   //全局管理接口
public interface MainContract  {
        //李强subView 接口
    interface SubView extends BaseViewInterface{//定义V层子接口，
            void showDataChina(ArrayList<BeanChinese> list111);


    }
    interface ShiView extends ShiViewInterface {

    }
        }
    interface  XSubView extends BaseViewInterface{
        void  showDatasWond(List<WondBean.VideoBean> video);
        void showDatas(PandaLiveBean pandaLiveBean);
        void showDatas1(List<ManyBean.ListBean> list);
        void  showPinlun(List<PinBean.DataBean.ContentBean> content);

    }
    interface  LiView extends LiViewInterface {



    }
    interface  SubHome extends HomeViewInterface {

    }



    interface  SubPresenter extends BasePresenter{   //定义P层子接口，定义方法请求数据

    }


}

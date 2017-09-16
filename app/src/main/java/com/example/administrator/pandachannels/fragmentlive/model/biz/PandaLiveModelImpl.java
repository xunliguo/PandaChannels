package com.example.administrator.pandachannels.fragmentlive.model.biz;


import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.utils.net.callback.MyNetWorkCallback;
import com.example.administrator.pandachannels.framework.utils.Urls;

/**
 * Created by xingge on 2017/7/11.
 */

public class PandaLiveModelImpl implements IPandaLiveModel {

    @Override
    public void getPadDaLive(MyNetWorkCallback<PandaLiveBean> callback) {
        //发送网络请求
        iHttp.get(Urls.PANDALIVE,null,callback);


    }
}

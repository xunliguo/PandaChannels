package com.example.administrator.pandachannels.fragmentlive.model.biz;

import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.utils.net.callback.MyNetWorkCallback;

/**
 * Created by xingge on 2017/7/11.
 */

public interface IPandaLiveModel extends BaseModel{

    void getPadDaLive(MyNetWorkCallback<PandaLiveBean> callback);
}

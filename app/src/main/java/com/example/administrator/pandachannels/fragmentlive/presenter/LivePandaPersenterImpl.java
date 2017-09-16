package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.model.biz.PandaLiveModelImpl;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.utils.net.callback.MyNetWorkCallback;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

import static android.os.Build.VERSION_CODES.O;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class LivePandaPersenterImpl implements MainContract.SubPresenter {
    MainContract.XSubView xSubview;
    private final PandaLiveModelImpl pandaLiveModel;

    public LivePandaPersenterImpl(MainContract.XSubView xSubview) {
        this.xSubview = xSubview;

        pandaLiveModel = new PandaLiveModelImpl();
    }

    @Override
    public void requsetData() {
           xSubview.showLoading();
        OkHttpUtils.getInstance().getNetData("http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json", new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                PandaLiveBean pandaLiveBean = gson.fromJson(ss, PandaLiveBean.class);
                  xSubview.showDatas(pandaLiveBean);
                xSubview.dissmissLoading();

            }
        });

    }
}
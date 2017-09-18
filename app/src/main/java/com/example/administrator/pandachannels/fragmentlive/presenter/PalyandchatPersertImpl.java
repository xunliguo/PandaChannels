package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.fragment.PlayandChatFragment;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/18.
 */

public class PalyandchatPersertImpl implements MainContract.SubPresenter {
MainContract.XSubView xSubview;
    private String url="http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page=";

    public PalyandchatPersertImpl( MainContract.XSubView xSubview) {
        this.xSubview=xSubview;
    }

    @Override
    public void requsetData() {
        OkHttpUtils.getInstance().getNetData(url+ App.PAGE, new OkHttpUtils.CallBacks() {

            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                PinBean pinBean = gson.fromJson(ss, PinBean.class);
                PinBean.DataBean data = pinBean.getData();
                List<PinBean.DataBean.ContentBean> content = data.getContent();
                xSubview.showPinlun(content);


            }
        });



    }
}

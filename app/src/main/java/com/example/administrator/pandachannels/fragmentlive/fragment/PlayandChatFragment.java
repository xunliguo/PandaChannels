package com.example.administrator.pandachannels.fragmentlive.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.adapter.PinAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class PlayandChatFragment extends BaseFragment implements MainContract.XSubView {

    private ListView listview;
    private Button send;
    private EditText ed_pin;
    private List<PinBean> list=new ArrayList<>();
    @Override
    protected void initView(View view) {
        listview = view.findViewById(R.id.live_listview);
        send = view.findViewById(R.id.live_send);
        ed_pin = view.findViewById(R.id.ed_pinglun);


    }

    @Override
    protected int getLayout() {
        return R.layout.frm_1;
    }

    @Override
    protected void initData() {
        for (int i = 0; i <100 ; i++) {
            PinBean  pin=new PinBean("央视网网友:","滚滚好逗啊"+i);
            list.add(pin);
        }
        PinAdapters adapters=new PinAdapters(getActivity(),R.layout.pin_item,list);
        listview.setAdapter(adapters);


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void showData(ArrayList<BeanTaishan.LiveBean> list) {

    }

    @Override
    public void showrror() {

    }

    @Override
    public void showDatas(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void showDatas1(List<ManyBean.ListBean> list) {

    }
//zhesih
    @Override
    public void showDatasWond(List<WondBean.VideoBean> videolist) {

    }


}

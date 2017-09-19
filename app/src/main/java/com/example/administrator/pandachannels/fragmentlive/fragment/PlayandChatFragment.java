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
import com.example.administrator.pandachannels.fragmentlive.presenter.PalyandchatPersertImpl;
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
    private List<PinBean.DataBean.ContentBean> pin_list=new ArrayList<>();
     PalyandchatPersertImpl palyandchatPersert=new PalyandchatPersertImpl(this);

    @Override
    protected void initView(View view) {
        listview = (ListView) view.findViewById(R.id.live_listview);
        send = (Button) view.findViewById(R.id.live_send);
        ed_pin = (EditText) view.findViewById(R.id.ed_pinglun);
        palyandchatPersert.requsetData();


    }

    @Override
    protected int getLayout() {
        return R.layout.frm_1;
    }

    @Override
    protected void initData() {

//        PinAdapters adapters=new PinAdapters(getActivity(),R.layout.pin_item,list);
//       listview.setAdapter(adapters);


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

    @Override
    public void showPinlun(List<PinBean.DataBean.ContentBean> content) {
        pin_list.addAll(content);
        PinAdapters adapters=new PinAdapters(getActivity(),R.layout.pin_item,pin_list);
        listview.setAdapter(adapters);





    }

    //zhesih
    @Override
    public void showDatasWond(List<WondBean.VideoBean> videolist) {


    }


}

package com.example.administrator.pandachannels.fragmentlive.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.adapter.PinAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.PalyandchatPersertImpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class PlayandChatFragment extends BaseFragment implements MainContract.XSubView {

    private ListView listview;
    private Button send;
    private EditText ed_pin;

     PalyandchatPersertImpl palyandchatPersert=new PalyandchatPersertImpl(this);
    private XRecyclerView recycle;
    private PinAdapters adapters;
   private List<PinBean.DataBean.ContentBean> mlist=new ArrayList<>();
    @Override
    protected void initView(View view) {
        recycle = (XRecyclerView)  view.findViewById(R.id.live_listview);
        adapters = new PinAdapters(getActivity(),mlist);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recycle.setAdapter(adapters);

        send = (Button) view.findViewById(R.id.live_send);
        ed_pin = (EditText) view.findViewById(R.id.ed_pinglun);
        palyandchatPersert.requsetData();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s = ed_pin.getText().toString();
                Log.e("tag","=======>"+s);
                PinBean.DataBean.ContentBean demo=new  PinBean.DataBean.ContentBean();
                demo.setAuthor("QQ用户");
                demo.setMessage(s);
                mlist.add(demo);
                adapters.notifyDataSetChanged();
                ed_pin.setText(" ");
            }
        });


    }

    @Override
    protected int getLayout() {
        return R.layout.frm_1;
    }

    @Override
    protected void initData() {

//       PinAdapters adapters=new PinAdapters(getActivity(),R.layout.pin_item,list);
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
        Log.e("GTAG","===========>"+content);
       mlist.addAll(content);
        adapters.notifyDataSetChanged();
        recycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                App.PAGE=1;
                mlist.clear();
                palyandchatPersert.requsetData();
                recycle.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                App.PAGE++;
                palyandchatPersert.requsetData();
                recycle.loadMoreComplete();

            }
        });





    }

    //zhesih
    @Override
    public void showDatasWond(List<WondBean.VideoBean> videolist) {


    }


}

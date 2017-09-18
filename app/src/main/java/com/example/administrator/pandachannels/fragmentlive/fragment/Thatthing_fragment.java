package com.example.administrator.pandachannels.fragmentlive.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.LiveVideoActivity;
import com.example.administrator.pandachannels.fragmentlive.adapter.WondfulAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.ThatthFrPersenterImpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Thatthing_fragment extends BaseFragment implements MainContract.XSubView {
      ThatthFrPersenterImpl thatthFrPersenter=new ThatthFrPersenterImpl(this);

    private XRecyclerView recyclerView;
      private List<WondBean.VideoBean> mlist=new ArrayList<>();
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
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.that_recycle);
        thatthFrPersenter.requsetData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_thatthing_fragment;

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showDatas(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void showDatas1(List<ManyBean.ListBean> list) {

    }

    @Override
    public void showPinlun(List<PinBean.DataBean.ContentBean> content) {

    }



    @Override
    public void showDatasWond(List<WondBean.VideoBean> videolist) {
        mlist.addAll(videolist);
        WondfulAdapters adapters=new WondfulAdapters(mlist,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapters);
        adapters.setOnclick(new WondfulAdapters.Listener() {
            @Override
            public void Onclick(int position, View view) {
                Intent intent=new Intent(getActivity(), LiveVideoActivity.class);
                String vid = mlist.get(position).getVid();
                String t =mlist.get(position).getT();
                intent.putExtra("url",vid);
                intent.putExtra("title",t);
                startActivity(intent);
            }
        });
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mlist.clear();
                App.PAGE=1;
                thatthFrPersenter.requsetData();
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                App.PAGE++;
                thatthFrPersenter.requsetData();
                recyclerView.loadMoreComplete();
            }
        });

    }





}

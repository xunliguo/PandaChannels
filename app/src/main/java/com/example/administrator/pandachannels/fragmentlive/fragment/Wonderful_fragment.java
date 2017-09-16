package com.example.administrator.pandachannels.fragmentlive.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.VideoActivity;
import com.example.administrator.pandachannels.fragmentlive.adapter.DataAdapters;
import com.example.administrator.pandachannels.fragmentlive.adapter.WondfulAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.WonfulPersenterImpl;
import com.example.administrator.pandachannels.framework.A;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wonderful_fragment extends BaseFragment implements MainContract.XSubView {
         WonfulPersenterImpl wonfulPersenter=new WonfulPersenterImpl(this);
       private XRecyclerView recyclerView;
    private WondfulAdapters adapters;

    @Override
    protected void initView(View view) {

        recyclerView = view.findViewById(R.id.won_recycle);
        wonfulPersenter.requsetData();


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_wonderful_fragment;

    }

    @Override
    protected void initData() {


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
    public void showDatasWond(final List<WondBean.VideoBean> mlists) {

        adapters = new WondfulAdapters(mlists,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapters);


        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                App.PAGE=1;
                mlists.clear();
                wonfulPersenter.requsetData();
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                App.PAGE++;
                wonfulPersenter.requsetData();
                recyclerView.loadMoreComplete();
            }
        });
        adapters.setOnclick(new WondfulAdapters.Listener() {
            @Override
            public void Onclick(int position, View view) {
                Intent intent=new Intent(getActivity(), VideoActivity.class);
                String url = mlists.get(position).getUrl();
                String vid = mlists.get(position).getVid();
                intent.putExtra("url",url+vid);
                startActivity(intent);
            }
        });

    }
    private  void setResult(List<WondBean.VideoBean> list){






    }

    @Override
    public void showDataBurang() {

    }
}

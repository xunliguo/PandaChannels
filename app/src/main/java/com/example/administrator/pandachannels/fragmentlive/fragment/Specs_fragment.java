package com.example.administrator.pandachannels.fragmentlive.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.VideoActivity;
import com.example.administrator.pandachannels.fragmentlive.adapter.WondfulAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.SpecPresenterImpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Specs_fragment extends BaseFragment implements MainContract.XSubView {
    SpecPresenterImpl specPresenter=new SpecPresenterImpl(this);
 private List<WondBean.VideoBean>  mlisrt=new ArrayList<>();
    private XRecyclerView recyclerView;

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
        recyclerView = view.findViewById(R.id.spec_recycle);
        specPresenter.requsetData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_specs_fragment;
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
    public void showDatasWond(List<WondBean.VideoBean> videolist) {
        mlisrt.addAll(videolist);
        WondfulAdapters adapters=new WondfulAdapters(mlisrt,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapters);
        adapters.setOnclick(new WondfulAdapters.Listener() {
            @Override
            public void Onclick(int position, View view) {
                Intent intent=new Intent(getActivity(), VideoActivity.class);
                String url = mlisrt.get(position).getUrl();
                String vid = mlisrt.get(position).getVid();
                intent.putExtra("url",url+vid);
                startActivity(intent);
            }
        });
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mlisrt.clear();
                App.PAGE=1;
                specPresenter.requsetData();
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                App.PAGE++;
                specPresenter.requsetData();
                recyclerView.loadMoreComplete();
            }
        });

    }


}

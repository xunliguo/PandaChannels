package com.example.administrator.pandachannels.fragmentlive.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.VideoActivity;
import com.example.administrator.pandachannels.fragmentlive.adapter.WondfulAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.OrigPresenterimpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Original_fragment extends BaseFragment implements MainContract.XSubView{
   OrigPresenterimpl origPresenterimpl=new OrigPresenterimpl(this);
   private List<WondBean.VideoBean> mlsit=new ArrayList<>();
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
        recyclerView = view.findViewById(R.id.or_recycle);
        origPresenterimpl.requsetData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_original_fragment;


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
        mlsit.addAll(videolist);
        WondfulAdapters adapters=new WondfulAdapters(videolist,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapters);
        adapters.setOnclick(new WondfulAdapters.Listener() {
            @Override
            public void Onclick(int position, View view) {
                Intent intent=new Intent(getActivity(), VideoActivity.class);
                String url = mlsit.get(position).getUrl();
                String vid = mlsit.get(position).getVid();
                intent.putExtra("url",url+vid);
                startActivity(intent);
            }
        });
     recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
      @Override
      public void onRefresh() {
         mlsit.clear();
       App.PAGE=1;
       origPresenterimpl.requsetData();
       recyclerView.refreshComplete();


      }

      @Override
      public void onLoadMore() {
          App.PAGE++;
       origPresenterimpl.requsetData();
       recyclerView.loadMoreComplete();
      }
     });

    }

    @Override
    public void showDataBurang() {

    }
}



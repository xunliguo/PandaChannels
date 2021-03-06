package com.example.administrator.pandachannels.fragmentlive.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.adapter.Xian_WathAdapter;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.ManyFraPersenterImpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class ManyFragment extends BaseFragment implements MainContract.XSubView{
  private List<ManyBean.ListBean> mlist=new ArrayList<>();
    private GridView gridView;
    ManyFraPersenterImpl manyFraPersenter=new ManyFraPersenterImpl(this);
  private RecyclerView recycle;
  private Xian_WathAdapter adapter;

  @Override
    protected void initView(View view) {
    recycle = (RecyclerView) view.findViewById(R.id.recycleview);
    adapter = new Xian_WathAdapter(getActivity(),mlist);
    recycle.setLayoutManager(new GridLayoutManager(getActivity(),3));
    recycle.setAdapter(adapter);

    }

    @Override
    protected int getLayout() {
        return R.layout.frm_2;
    }

    @Override
    protected void initData() {
        manyFraPersenter.requsetData();

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
      Log.e("TAG" ,"==============>"+list);
        mlist.addAll(list);
      adapter.notifyDataSetChanged();

      adapter.setOnclick(new Xian_WathAdapter.Listener() {
        @Override
        public void onclick(int position) {
          Intent intent=new Intent();
          intent.setAction("data");
          String title = mlist.get(position).getTitle();
            String live_image = mlist.get(position).getImage();
            String icard =  mlist.get(position).getId();
            intent.putExtra("aa",title);
            intent.putExtra("imageurl",live_image);
           intent.putExtra("ids",icard);

            getActivity().sendBroadcast(intent);



        }
      });


    }

  @Override
  public void showPinlun(List<PinBean.DataBean.ContentBean> content) {

  }



  @Override
  public void showDatasWond(List<WondBean.VideoBean> videolist) {

  }


}

package com.example.administrator.pandachannels.fragmenthome;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.Presen.PresentImp;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeListAdap;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeReayAdap;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeRecycleAdapter;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeWobder;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeRolling;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeWobderfulBean;
import com.example.administrator.pandachannels.fragmenthome.bean.PandaLiveBean;

import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class Fragment_home extends BaseFragment implements MainContract.SubHome {


    private XRecyclerView xRecyclerView;
    private Banner banner;
    private RecyclerView homerecycle;
    private RecyclerView homewobderful;
    private RecyclerView homeRoing;
    private RecyclerView homelive;
    private ProgressDialog lo;

    @Override
    protected void initView(View view) {
        lo = new ProgressDialog(getActivity());
        lo.setMessage("");
     PresentImp presentImp = new PresentImp(this);
        presentImp.requsetData();
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.homexrecycle);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {
        lo = new ProgressDialog(getActivity());
        lo.setMessage("正在拼命加载中");
        lo.show();
    }

    @Override
    public void dissmissLoading() {
        lo.dismiss();
    }

    @Override
    public void showDate(final PandaLiveBean pandaLiveBean) {
        View inflate = View.inflate(getActivity(), R.layout.homhead, null);
        xRecyclerView.addHeaderView(inflate);
        banner = (Banner) inflate.findViewById(R.id.homebanner);
        TextView home_birthday = (TextView) inflate.findViewById(R.id.home_birthday);
        TextView attention = (TextView) inflate.findViewById(R.id.attention);
        home_birthday.setText(pandaLiveBean.getData().getPandaeye().getItems().get(0).getTitle());
        attention.setText(pandaLiveBean.getData().getPandaeye().getItems().get(1).getTitle());
        home_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Homevoid.class);
                intent.putExtra("homeflunbo", pandaLiveBean.getData().getPandaeye().getItems().get(0).getPid());
                intent.putExtra("homeTitile", pandaLiveBean.getData().getPandaeye().getItems().get(0).getTitle());
                intent.putExtra("homimg",pandaLiveBean.getData().getPandaeye().getItems().get(0).getUrl());

                startActivity(intent);
            }
        });
        attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Homevoid.class);
                intent.putExtra("homeflunbo", pandaLiveBean.getData().getPandaeye().getItems().get(1).getPid());
                intent.putExtra("homeTitile", pandaLiveBean.getData().getPandaeye().getItems().get(1).getTitle());
                intent.putExtra("homimg",pandaLiveBean.getData().getPandaeye().getItems().get(1).getUrl());

                startActivity(intent);

            }
        });

        //轮播图
        homhead(pandaLiveBean);
        homerecycle = (RecyclerView) inflate.findViewById(R.id.home_recycleview);
        homewobderful = (RecyclerView) inflate.findViewById(R.id.home_wonderful);
        homeRoing = (RecyclerView) inflate.findViewById(R.id.home_Roing);
        homelive = (RecyclerView) inflate.findViewById(R.id.homeliveChid);
        //直播秀场   精彩一刻
        initWoudefl(pandaLiveBean);
        //滚滚视屏    直播中国
        Rolling(pandaLiveBean);
    }

    private void Rolling(final PandaLiveBean pandaLiveBean) {
        String str = pandaLiveBean.getData().getList().get(0).getListUrl();
        OkHttpUtils.getInstance().getNetData(str, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                HomeRolling homeRolling = new Gson().fromJson(ss, HomeRolling.class);
                final List<HomeRolling.ListBean> arr = new ArrayList<HomeRolling.ListBean>();
                arr.addAll(homeRolling.getList());
                homeRoing.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                HomeListAdap adap = new HomeListAdap(getActivity(), arr);
                RecyclerAdapterWithHF wit=new RecyclerAdapterWithHF(adap);
                homeRoing.setAdapter(wit);
                wit.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
                    @Override
                    public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                        Intent intent = new Intent(getActivity(), Homevoid.class);
                        intent.putExtra("homeflunbo", arr.get(position).getPid());
                        intent.putExtra("homeTitile", arr.get(position).getTitle());
                        intent.putExtra("homimg",arr.get(position).getImage());

                        startActivity(intent);

                    }
                });
            }
        });

        final List<PandaLiveBean.DataBean.ChinaliveBean.ListBeanX> list = new ArrayList<>();
        list.addAll(pandaLiveBean.getData().getChinalive().getList());
        xRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        final HomeRecycleAdapter homeAdap = new HomeRecycleAdapter(getActivity(), list);
        //直播中国
        RecyclerAdapterWithHF Chinalivewith=new RecyclerAdapterWithHF(homeAdap);
        xRecyclerView.setAdapter(Chinalivewith);
        Chinalivewith.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent liveintent=new Intent(getActivity(),Homelive.class);
                liveintent.putExtra("livehome",list.get(position-2).getId());
                liveintent.putExtra("livetitle",list.get(position-2).getTitle());
                liveintent.putExtra("liveimm",list.get(position-2).getImage());
                startActivity(liveintent);
            }
        });
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                homeAdap.notifyDataSetChanged();
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRecyclerView.loadMoreComplete();
            }
        });
    }

    private void initWoudefl(PandaLiveBean pandaLiveBean) {
        homerecycle.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        final List<PandaLiveBean.DataBean.PandaliveBean.ListBean> lists = new ArrayList<>();
        lists.addAll(pandaLiveBean.getData().getPandalive().getList());
        HomeReayAdap adap = new HomeReayAdap(getActivity(), lists);
        //直播秀场
        RecyclerAdapterWithHF xiuchan=new RecyclerAdapterWithHF(adap);
        homerecycle.setAdapter(xiuchan);
        xiuchan.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent liveintent=new Intent(getActivity(),Homelive.class);
                liveintent.putExtra("livehome",lists.get(position).getId());
                liveintent.putExtra("livetitle",lists.get(position).getTitle());
                liveintent.putExtra("liveimm",lists.get(position).getImage());
                startActivity(liveintent);
            }
        });
        homewobderful.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        OkHttpUtils.getInstance().getNetData(pandaLiveBean.getData().getCctv().getListurl(), new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                HomeWobderfulBean homeWobderfulBean = new Gson().fromJson(ss, HomeWobderfulBean.class);
                final List<HomeWobderfulBean.ListBean> homelist = new ArrayList<>();
                homelist.addAll(homeWobderfulBean.getList());
                HomeWobder adap = new HomeWobder(getActivity(), homelist);
                RecyclerAdapterWithHF withH=new RecyclerAdapterWithHF(adap);
                homewobderful.setAdapter(withH);
                withH.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
                    @Override
                    public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                        Intent intent = new Intent(getActivity(), Homevoid.class);
                        intent.putExtra("homeflunbo", homelist.get(position).getPid());
                        intent.putExtra("homeTitile", homelist.get(position).getTitle());
                        startActivity(intent);
                    }
                });
            }
        });

    }

    private void homhead(final PandaLiveBean pandaLiveBean) {
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        List<String> title = new ArrayList<>();
        for (int i = 0; i < pandaLiveBean.getData().getBigImg().size(); i++) {
            images.add(pandaLiveBean.getData().getBigImg().get(i).getImage());
            title.add(pandaLiveBean.getData().getBigImg().get(i).getTitle());
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(title);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), Homevoid.class);
                intent.putExtra("homeflunbo", pandaLiveBean.getData().getBigImg().get(position).getPid());
                intent.putExtra("homeTitile", pandaLiveBean.getData().getBigImg().get(position).getTitle());
                intent.putExtra("homimg",pandaLiveBean.getData().getBigImg().get(position).getImage());

                startActivity(intent);

            }
        });
    }
}

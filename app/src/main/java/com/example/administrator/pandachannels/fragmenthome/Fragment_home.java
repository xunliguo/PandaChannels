package com.example.administrator.pandachannels.fragmenthome;


import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.Bean.HomeRolling;
import com.example.administrator.pandachannels.fragmenthome.Bean.HomeWobderfulBean;
import com.example.administrator.pandachannels.fragmenthome.Bean.PandaLiveBean;
import com.example.administrator.pandachannels.fragmenthome.Presen.PresentImp;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeListAdap;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeReayAdap;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeRecycleAdapter;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeWobder;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

//十大按时打算的
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
        xRecyclerView = view.findViewById(R.id.homexrecycle);

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
        lo.show();
    }

    @Override
    public void dissmissLoading() {
        lo.dismiss();
    }

    @Override
    public void showDate(PandaLiveBean pandaLiveBean) {
        View inflate = View.inflate(getActivity(), R.layout.homhead, null);
        xRecyclerView.addHeaderView(inflate);
        banner = inflate.findViewById(R.id.homebanner);
        TextView home_birthday = inflate.findViewById(R.id.home_birthday);
        TextView  attention= inflate.findViewById(R.id.attention);
        home_birthday.setText(pandaLiveBean.getData().getPandaeye().getItems().get(0).getTitle());
        attention.setText(pandaLiveBean.getData().getPandaeye().getItems().get(1).getTitle());
        //轮播图
        homhead(pandaLiveBean);
        homerecycle = inflate.findViewById(R.id.home_recycleview);
        homewobderful = inflate.findViewById(R.id.home_wonderful);
        homeRoing = inflate.findViewById(R.id.home_Roing);
        homelive = inflate.findViewById(R.id.homeliveChid);
        //直播秀场   精彩一刻
        initWoudefl(pandaLiveBean);
        //滚滚视屏    直播中国
        Rolling(pandaLiveBean);

    }

    private void Rolling(PandaLiveBean pandaLiveBean) {
        String str=pandaLiveBean.getData().getList().get(0).getListUrl();
        OkHttpUtils.getInstance().getNetData(str, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                HomeRolling homeRolling = new Gson().fromJson(ss, HomeRolling.class);
                List<HomeRolling.ListBean> arr=new ArrayList<HomeRolling.ListBean>();
                arr.addAll(homeRolling.getList());
                homeRoing.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                HomeListAdap adap=new HomeListAdap(getActivity(),arr);
                homeRoing.setAdapter(adap);
            }
        });
        List<PandaLiveBean.DataBean.ChinaliveBean.ListBeanX> list = new ArrayList<>();
        list.addAll(pandaLiveBean.getData().getChinalive().getList());
        xRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        final HomeRecycleAdapter homeAdap = new HomeRecycleAdapter(getActivity(), list);
        xRecyclerView.setAdapter(homeAdap);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                homeAdap.notifyDataSetChanged();
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "加载完成", Toast.LENGTH_SHORT).show();
                xRecyclerView.loadMoreComplete();
            }
        });
    }

    private void initWoudefl(PandaLiveBean pandaLiveBean) {
        homerecycle.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        List<PandaLiveBean.DataBean.PandaliveBean.ListBean> lists = new ArrayList<>();
        lists.addAll(pandaLiveBean.getData().getPandalive().getList());
        HomeReayAdap adap = new HomeReayAdap(getActivity(), lists);
        homerecycle.setAdapter(adap);
        homewobderful.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        OkHttpUtils.getInstance().getNetData(pandaLiveBean.getData().getCctv().getListurl(), new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                HomeWobderfulBean homeWobderfulBean = new Gson().fromJson(ss, HomeWobderfulBean.class);
                List<HomeWobderfulBean.ListBean> homelist = new ArrayList<>();
                homelist.addAll(homeWobderfulBean.getList());
                HomeWobder adap = new HomeWobder(getActivity(), homelist);
                homewobderful.setAdapter(adap);
            }
        });

    }

    private void homhead(PandaLiveBean pandaLiveBean) {
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        List<String> title = new ArrayList<>();
        for (int i = 0; i < pandaLiveBean.getData().getBigImg().size(); i++) {
            images.add(pandaLiveBean.getData().getBigImg().get(i).getImage());
            title.add(pandaLiveBean.getData().getBigImg().get(i).getTitle());
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(title);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}

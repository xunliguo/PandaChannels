package com.example.administrator.pandachannels.fragmenthome;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.pandachannels.MainActivity;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeRolling;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeWobderfulBean;
import com.example.administrator.pandachannels.fragmenthome.bean.PandaLiveBean;
import com.example.administrator.pandachannels.fragmenthome.presen.PresentImp;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeListAdap;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeReayAdap;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeRecycleAdapter;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeWobder;
import com.example.administrator.pandachannels.fragmenthome.Bean.PandaLiveBean;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;



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
        @Override
        protected void initView(View view) {
            lo = new ProgressDialog(getActivity());
            lo.setMessage("");


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

        }

        @Override
        public void dissmissLoading() {

        }

    @Override
    public void showDate(PandaLiveBean pandaLiveBean) {
        View inflate = View.inflate(getActivity(), R.layout.homhead, null);
        xRecyclerView.addHeaderView(inflate);
        banner = inflate.findViewById(R.id.homebanner);
        TextView home_birthday = inflate.findViewById(R.id.home_birthday);
        TextView attention = inflate.findViewById(R.id.attention);
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
        @Override
        public void showDate(PandaLiveBean pandaLiveBean) {

        }
    }
    }

    private void Rolling(PandaLiveBean pandaLiveBean) {
        String str = pandaLiveBean.getData().getList().get(0).getListUrl();
        OkHttpUtils.getInstance().getNetData(str, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                HomeRolling homeRolling = new Gson().fromJson(ss, HomeRolling.class);
                List<HomeRolling.ListBean> arr = new ArrayList<HomeRolling.ListBean>();
                arr.addAll(homeRolling.getList());
                homeRoing.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
                HomeListAdap adap = new HomeListAdap(getActivity(), arr);
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

    private void homhead(final PandaLiveBean pandaLiveBean) {
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
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("homelunbo",pandaLiveBean.getData().getBigImg().get(position).getPid());
                startActivity(intent);
            }
        });
    }
}

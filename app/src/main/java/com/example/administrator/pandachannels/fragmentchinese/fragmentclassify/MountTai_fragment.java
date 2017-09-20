package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter.MyAdapter_TaiShan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Beanlive;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter.SubPresenterimpl_MountTai;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */                                                   //实现v层的接口
public class MountTai_fragment extends BaseFragment implements MainContract.SubView {

    private TextView fragment_tvtv1;
    private XRecyclerView mountai_recy;
    private ProgressDialog dialog;
    String s;
    private ProgressDialog dialog1;
    private Beanlive.FlvUrlBean flv_url;
    private Beanlive.FlvUrlBean flv_url1;
    private String flv1;

    public MountTai_fragment(String s) {
        this.s=s;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mount_tai_fragment,null);
        dialog = new ProgressDialog(getActivity());
        initView(view);
        getLayout();
        dialog1 = new ProgressDialog(getActivity());

        return view;

    }

    @Override
    protected void initView(View view) {
        //p层有了，怎么关联，把this传进来,调用请求数据方法
        SubPresenterimpl_MountTai subPresenterimpl_mountTai = new SubPresenterimpl_MountTai(this,s);
        subPresenterimpl_mountTai.requsetData();

        mountai_recy = (XRecyclerView) view.findViewById(R.id.mountai_recy);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mount_tai_fragment;
    }

    @Override
    protected void initData() {


    }

    @Override
    public void showLoading() {

      dialog.show();
    }

    @Override
    public void dissmissLoading() {
 dialog.dismiss();

    }

    @Override
    public void showData(final ArrayList<BeanTaishan.LiveBean> list) {
        //TODO  例如两个直播网址怎么穿进去
        for (int i = 0; i < list.size(); i++) {
            String id = list.get(0).getId();
            String liveurl="http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+id+"&amp;client=androidapp";
            OkHttpUtils.getInstance().getNetData(liveurl, new OkHttpUtils.CallBacks() {
                @Override
                public void getString(String ss) {
                    Gson gson2=new Gson();
                    Beanlive beanlive = gson2.fromJson(ss, Beanlive.class);

                    Beanlive.HlsUrlBean hls_url = beanlive.getHls_url();

                    flv1 = hls_url.getHls1();
///////////////////////////////////////////////////////////////////////////////////////


                    final MyAdapter_TaiShan myAdapter_taiShan = new MyAdapter_TaiShan(getActivity(), list, flv1);
                    mountai_recy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    mountai_recy.setAdapter(myAdapter_taiShan);

                    mountai_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
                        @Override
                        public void onRefresh() {
                            myAdapter_taiShan.notifyDataSetChanged();
                            mountai_recy.refreshComplete();
                            mountai_recy.setLoadingMoreEnabled(true);//允许下拉刷新
                        }

                        @Override
                        public void onLoadMore() {
                            myAdapter_taiShan.notifyDataSetChanged();
                            mountai_recy.loadMoreComplete();
                            mountai_recy.setLoadingMoreEnabled(false);//不允许上拉加载
                        }
                    });




                    myAdapter_taiShan.setonitenclicklistener(new MyAdapter_TaiShan.Listener() {
                        @Override
                        public void setonduanclick(View v, int postion) {
                            dialog1.show();
                        }

                        @Override
                        public void setonlongclick(View v, int postion) {

                        }
                    });
                }
            });
        }





    }


    @Override
    public void showrror() {

    }


    @Override
    public void showDataChina(ArrayList<BeanChinese> list111) {

    }
}

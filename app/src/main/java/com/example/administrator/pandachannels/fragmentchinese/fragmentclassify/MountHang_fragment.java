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
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter.MyAdapter_TaiShan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanChinese;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter.SubPresenterimpl_MountHuangshan;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MountHang_fragment extends BaseFragment  implements MainContract.SubView {

    private TextView fragment_tvtv1;
    private XRecyclerView mountai_recy;
    private ProgressDialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mount_tai_fragment,null);
        dialog = new ProgressDialog(getActivity());
        initView(view);
        getLayout();
        return view;

    }

    @Override
    protected void initView(View view) {
        //p层有了，怎么关联，把this传进来,调用请求数据方法
        SubPresenterimpl_MountHuangshan subPresenterimpl_mountTai = new SubPresenterimpl_MountHuangshan(this);
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
    public void showData(ArrayList<BeanTaishan.LiveBean> list) {
        final MyAdapter_TaiShan myAdapter_taiShan = new MyAdapter_TaiShan(getActivity(), list);
        mountai_recy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mountai_recy.setAdapter(myAdapter_taiShan);
        mountai_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                myAdapter_taiShan.notifyDataSetChanged();
                mountai_recy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                myAdapter_taiShan.notifyDataSetChanged();
                mountai_recy.loadMoreComplete();
            }
        });




        myAdapter_taiShan.setonitenclicklistener(new MyAdapter_TaiShan.Listener() {
            @Override
            public void setonduanclick(View v, int postion) {
                Toast.makeText(getActivity(), "1111111", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setonlongclick(View v, int postion) {

            }
        });
    }


    @Override
    public void showrror() {

    }

    @Override
    public void showDataChina(ArrayList<BeanChinese> list111) {

    }
}

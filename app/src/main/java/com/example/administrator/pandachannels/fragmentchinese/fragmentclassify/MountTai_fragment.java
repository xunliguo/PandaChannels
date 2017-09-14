package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter.MyAdapter_TaiShan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter.SubPresenterimpl_MountTai;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */                                                   //实现v层的接口
public class MountTai_fragment extends BaseFragment implements MainContract.SubView{

    private TextView fragment_tvtv1;
    private RecyclerView mountai_recy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragment_mount_tai_fragment, null);
        initView(view);
        //p层有了，怎么关联，把this传进来,调用请求数据方法
        SubPresenterimpl_MountTai  subPresenterimpl_mountTai=new SubPresenterimpl_MountTai(this);
        subPresenterimpl_mountTai.requsetData();
        initData();
        return view;

    }

    @Override
    protected void initView(View view) {


        mountai_recy = (RecyclerView) view.findViewById(R.id.mountai_recy);


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

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void showData(ArrayList<BeanTaishan.LiveBean> list) {
        MyAdapter_TaiShan myAdapter_taiShan=new MyAdapter_TaiShan(getActivity(),list);
        mountai_recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mountai_recy.setAdapter(myAdapter_taiShan);
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
}

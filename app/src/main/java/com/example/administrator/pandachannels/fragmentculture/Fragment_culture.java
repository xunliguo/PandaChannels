package com.example.administrator.pandachannels.fragmentculture;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_culture extends BaseFragment implements MainContract.LiView {


    private Banner banner;
    private List<LiBean.ListBean> listsbe = new ArrayList<>();

    int a = 1;
    private RecyclerView recyclerview;
    private ImageView li_img;
    private TextView li_text;
    private PtrFrameLayout ptrclassics;
    private MyAdapter adapter;


    @Override
    protected void initView(View view) {
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        li_img = (ImageView) view.findViewById(R.id.li_img);
        li_text = (TextView) view.findViewById(R.id.li_text);
        ptrclassics = (PtrFrameLayout) view.findViewById(R.id.ptrclassics);

        li_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),WenActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_culture;
    }


    @Override
    protected void initData() {
        LiPresenter liPresenter = new LiPresenter(this);
        liPresenter.requsetData();
    }

    @Override
    public void showData(LiBean liBean) {
        //请求的图片
        List<LiBean.BigImgBean> bigImg = liBean.getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            Glide.with(getContext().getApplicationContext()).load(bigImg.get(i).getImage()).into(li_img);
            li_text.setText(bigImg.get(i).getTitle());
        }


        //请求recyclerview数据
        final List<LiBean.ListBean> listbe = liBean.getList();
        listsbe.addAll(listbe);


        adapter = new MyAdapter(getContext(), listsbe);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setAdapter(adapter);

        //条目点击事件跳转到视频播放界面
        adapter.Dianji(new MyAdapter.OnItemClickLiener() {
            @Override
            public void OnItemClickLiener(View v, int position) {
                Intent i=new Intent(getActivity(),LiActivity.class);
              i.putExtra("title",listbe.get(position).getTitle());

           i.putExtra("url",listbe.get(position).getUrl());

                getActivity(). startActivity(i);
            }
        });
        //刷新
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
        ptrclassics.setHeaderView(header);
        ptrclassics.addPtrUIHandler(header);

        ptrclassics.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                a = 1;
                listsbe.clear();
                OkHttpUtils.getInstance().getNetData("http://www.ipanda.com/kehuduan/video/index.json", new OkHttpUtils.CallBacks() {
                    @Override
                    public void getString(String ss) {
                        Gson gson = new Gson();
                        LiBean liBeans = gson.fromJson(ss, LiBean.class);
                        List<LiBean.ListBean> lblist = liBeans.getList();
                        listsbe.addAll(lblist);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });
    }

    public void onPrepared(MediaPlayer mediaPlayer) {

    }
}
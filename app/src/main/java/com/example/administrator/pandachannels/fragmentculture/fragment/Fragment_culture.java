package com.example.administrator.pandachannels.fragmentculture.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;
import com.example.administrator.pandachannels.fragmentculture.LiBean;
import com.example.administrator.pandachannels.fragmentculture.LiPresenter;
import com.example.administrator.pandachannels.fragmentculture.activity.LiActivity;
import com.example.administrator.pandachannels.fragmentculture.activity.WenActivity;
import com.example.administrator.pandachannels.fragmentculture.adapter.MyAdapter;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.greendao1.DaoMaster;
import com.example.greendao1.DaoSession;
import com.example.greendao1.StudentsDao;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_culture extends BaseFragment implements MainContract.LiView {


    private Banner banner;
    private List<LiBean.ListBean> listsbe = new ArrayList<>();

    int a = 1;
    private XRecyclerView recyclerview;
    private ImageView li_img;
    private TextView li_text;
    private PtrFrameLayout ptrclassics;
    private MyAdapter adapter;
    private LiPresenter liPresenter;
    private ProgressDialog dialog;
    private StudentsDao studentsDao;


    @Override
    protected void initView(View view) {

        recyclerview = (XRecyclerView) view.findViewById(R.id.recyclerview);

        View headviews = View.inflate(getActivity(), R.layout.headview, null);
        recyclerview.addHeaderView(headviews);
        li_img = (ImageView) headviews.findViewById(R.id.lili_img);
        li_text = (TextView) headviews.findViewById(R.id.lili_text);
        adapter = new MyAdapter(getContext(), listsbe);

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerview.setAdapter(adapter);
        li_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), WenActivity.class);

                startActivity(i);
            }
        });
        //////////////////////////
        recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyclerview.loadMoreComplete();
            }
        });
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_culture;
    }


    @Override
    protected void initData() {

        liPresenter = new LiPresenter(this);
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
        adapter.notifyDataSetChanged();

        //条目点击事件跳转到视频播放界面
        adapter.Dianji(new MyAdapter.OnItemClickLiener() {
            @Override
            public void OnItemClickLiener(View v, int position) {
                Intent i = new Intent(getActivity(), LiActivity.class);
                i.putExtra("title", listbe.get(position).getTitle());

                i.putExtra("url", listbe.get(position).getUrl());
                i.putExtra("imgg", listbe.get(position).getImage());
                getActivity().startActivity(i);
                //点击播放插入数据库
                DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "ss.db", null);

                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());

                DaoSession daoSession = daoMaster.newSession();

                studentsDao = daoSession.getStudentsDao();
                studentsDao.insert(new Students(null,111,listbe.get(position).getTitle(),listbe.get(position).getImage()));

            }
        });

    }

    @Override
    public void showLoading() {
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("正在拼命加载中");
        dialog.show();
    }

    @Override
    public void dissmissLoading() {
    dialog.dismiss();
    }
}
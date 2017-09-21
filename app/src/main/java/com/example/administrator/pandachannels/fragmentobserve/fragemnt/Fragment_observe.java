package com.example.administrator.pandachannels.fragmentobserve.fragemnt;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentobserve.Mp;
import com.example.administrator.pandachannels.fragmentobserve.activity.ItemActivity;
import com.example.administrator.pandachannels.fragmentobserve.activity.VideoActivity;
import com.example.administrator.pandachannels.fragmentobserve.adapter.RecyAdapter;
import com.example.administrator.pandachannels.fragmentobserve.entity.PandaBean;
import com.example.administrator.pandachannels.fragmentobserve.entity.PandaViewBean;
import com.example.administrator.pandachannels.fragmentobserve.entity.WenBean;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_observe extends BaseFragment implements MainContract.ShiView {


    private ImageView img;
    private TextView img_text;
    private ArrayList<PandaViewBean.ListBean> list;
    private ArrayList<PandaBean.DataBean.BigImgBean> lists;
    private XRecyclerView recy;
    private RecyAdapter adapter;
    private PtrFrameLayout ptrclassic;
    private int a = 1;
    private RelativeLayout relative;
    private ProgressDialog dialog;

    @Override
    protected void initView(View view) {

        recy = (XRecyclerView) view.findViewById(R.id.recy);
        View in = View.inflate(getActivity(), R.layout.zhuzihead, null);
        recy.addHeaderView(in);
        img = (ImageView) in.findViewById(R.id.img);
        img_text = (TextView) in.findViewById(R.id.img_text);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fragment_observe;
    }

    @Override
    protected void initData() {
        Mp shiViewInterface = new Mp(this);
        shiViewInterface.requsetData();

//        //头布局操作
//        relative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), VideoActivity.class);
//                getActivity().startActivity(intent);
//            }
//        });


    }


    @Override
    public void showData(final PandaViewBean pandaBean) {
        list = new ArrayList<>();
        list.addAll(pandaBean.getList());
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyAdapter(getActivity(), list);
        recy.setAdapter(adapter);
        recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recy.loadMoreComplete();
            }
        });


//通过接口回调实现点击事件
        adapter.Dianji(new RecyAdapter.OnItemClickLiener() {

            private String htmlid;

            @Override
            public void OnItemClickLiener(View v, int position) {
                Intent intent = new Intent(getContext(), ItemActivity.class);
                PandaViewBean.ListBean listBean = list.get(position);
                htmlid = listBean.getId();
                intent.putExtra("id", htmlid);
                getActivity().startActivity(intent);

            }

        });

//
//        //头
//        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
//        //脚
//        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getContext());
//        ptrclassic.setHeaderView(header);
//        ptrclassic.setFooterView(footer);
//        ptrclassic.addPtrUIHandler(header);
//        ptrclassic.addPtrUIHandler(footer);
//
//        ptrclassic.setPtrHandler(new PtrDefaultHandler2() {
//            @Override
//            public void onLoadMoreBegin(PtrFrameLayout frame) {
//                //a为条目索引 判断a如果到了最后一条 提示无新数据
//                if (a == 14) {
//                    frame.refreshComplete();
//                    Toast.makeText(getActivity(), "暂无新数据。", Toast.LENGTH_SHORT).show();
//                } else {
//                    //如果不是 那么执行a++ 自动加载吓一条
//                    a++;
//                    OkHttpUtils.getInstance().getNetData("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=" + a, new OkHttpUtils.CallBacks() {
//                        @Override
//                        public void getString(String ss) {
//                            Gson gson = new Gson();
//                            PandaViewBean pandaViewBean = gson.fromJson(ss, PandaViewBean.class);
//                            list.addAll(pandaViewBean.getList());
//                            getActivity().runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    adapter.notifyDataSetChanged();
//                                }
//                            });
//                        }
//                    });
//                    frame.refreshComplete();
//                }
//            }
//
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                a = 1;
//                list.clear();
//                OkHttpUtils.getInstance().getNetData("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=" + a, new OkHttpUtils.CallBacks() {
//                    @Override
//                    public void getString(String ss) {
//                        Gson gson = new Gson();
//                        PandaViewBean pandaViewBean = gson.fromJson(ss, PandaViewBean.class);
//                        list.addAll(pandaViewBean.getList());
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                adapter.notifyDataSetChanged();
//                            }
//                        });
//                    }
//                });
//                frame.refreshComplete();
//            }
//        });


    }

    @Override
    public void showPan(PandaBean pandaBean) {
        lists = new ArrayList<>();
        lists.addAll(pandaBean.getData().getBigImg());
        for (int i = 0; i < lists.size(); i++) {
            Glide.with(getActivity().getApplication()).load(lists.get(i).getImage()).into(img);
            img_text.setText(lists.get(i).getTitle());
        }
    }

    @Override
    public void showWen(WenBean wenBean) {

    }

    @Override
    public void showLoading() {
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("正在拼命加载中");
        dialog.show();
    }

    @Override
    public void diassLoading() {
dialog.dismiss();
    }


}

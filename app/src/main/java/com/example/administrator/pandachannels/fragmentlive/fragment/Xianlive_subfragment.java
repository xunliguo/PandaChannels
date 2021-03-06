package com.example.administrator.pandachannels.fragmentlive.fragment;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentlive.adapter.MyAdapters;
import com.example.administrator.pandachannels.fragmentlive.model.entity.LivexiongBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.LivePandaPersenterImpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class Xianlive_subfragment extends BaseFragment implements MainContract.XSubView, View.OnClickListener {
    LivePandaPersenterImpl livePandaPersenter = new LivePandaPersenterImpl(this);
    int a = 0;


    ArrayList<String> lists = new ArrayList<>();
    MyAdapters adapters;

    private JCVideoPlayer videoController;
    private TextView title_textView;

    private ListView listView;
    ManyFragment aFrm;
    PlayandChatFragment bFrm;
    private TextView title;
    private ImageView up;
    private String title1;
    private String brief;
    private ProgressDialog dialog;
    private String image;
    private ReceiveBroadCast receiveBroadCast;
    private List<String > lsitstring=new ArrayList<>();

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


    }
    public class ReceiveBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //得到广播中得到的数据，并显示出来
            String message = intent.getStringExtra("aa");
            String ids = intent.getStringExtra("ids");
            Log.e("tavd","===========>"+ids);
            title_textView.setText("[正在直播]" + message);
            OkHttpUtils.getInstance().getNetData("http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+ids+"&amp;client=androidapp", new OkHttpUtils.CallBacks() {

                private LivexiongBean.HlsUrlBean hls_url;

                @Override
                public void getString(String ss) {
                    Gson gson=new Gson();
                    LivexiongBean livexiongBean = gson.fromJson(ss, LivexiongBean.class);
                    String hls1 = livexiongBean.getHls_url().getHls1();
                    videoController.setUp("http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel379.m3u8?AUTH=DoNe66UuL9xIffwpMKrk7jAhRTM4E4ZIdMgs82armq9b0olACW5Gy6WiPXbvGqP85qx0qYD/k91CgqEtecaUZg==" ,"直播");
                }


            });


        }
    }
        @Override
    public void showrror() {

    }

    @Override
    protected void initView(View view) {
        videoController = (JCVideoPlayer) view.findViewById(R.id.videocontroller1sss);
        View view1 = View.inflate(getActivity(), R.layout.livemudel_wathch, null);
        listView = (ListView) view.findViewById(R.id.xian_listView);

        listView.addHeaderView(view1);
        up = (ImageView) view.findViewById(R.id.up);
        title_textView = (TextView) view.findViewById(R.id.xian_text);
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction("data");    //只有持有相同的action的接受者才能接收此广播
       getActivity(). registerReceiver(receiveBroadCast, filter);

//      ----------------------------------------------

        title = (TextView) view1.findViewById(R.id.titlename);

        adapters = new MyAdapters(getActivity(), lists);
        listView.setAdapter(adapters);

        Button but1s = (Button) view1.findViewById(R.id.but1s);
        Button but2s = (Button) view1.findViewById(R.id.but2s);
        but1s.setOnClickListener(this);
        but2s.setOnClickListener(this);
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("正在拼命加载中");

        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        aFrm = new ManyFragment();
        transaction.add(R.id.framlayouts, aFrm);
        transaction.commit();
        livePandaPersenter.requsetData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_xianlive_subfragment;
    }

    @Override
    protected void initData() {

        videoController.setUp("hls_url ","直播");

        //videoController.ivThumb.setImageResource(R.drawable.panda);
        videoController.setThumbImageViewScalType(ImageView.ScaleType.CENTER_CROP);

        intDate();


    }

    private void intDate() {



        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (a) {
                    case 0:
                        a = 1;
                        title.setVisibility(View.VISIBLE);
                        up.setImageResource(R.drawable.lpanda_off);

                        break;
                    case 1:
                        a = 0;
                        up.setImageResource(R.drawable.lpanda_show);
                        title.setVisibility(View.GONE);

                        break;
                }
            }
        });

    }

    @Override
    public void showDatas(PandaLiveBean pandaLiveBean) {
        List<PandaLiveBean.LiveBean> live = pandaLiveBean.getLive();
        brief = live.get(0).getBrief();
        image = live.get(0).getImage();
        title1 = live.get(0).getTitle();
        Log.e("tag", "================>" + brief);
        title_textView.setText("[正在直播]" + title1);
        title.setText(brief);
        title.setVisibility(View.GONE);

    }

    @Override
    public void showDatas1(List<ManyBean.ListBean> list) {

    }

    @Override
    public void showPinlun(List<PinBean.DataBean.ContentBean> content) {


    }

    @Override
    public void showDatasWond(List<WondBean.VideoBean> videolist) {


    }


    @Override
    public void onClick(View view) {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        hideAll(transaction);
        switch (view.getId()) {
            case R.id.but1s:
                if (aFrm == null) {
                    aFrm = new ManyFragment();
                    transaction.add(R.id.framlayouts, aFrm);
                } else {
                    transaction.show(aFrm);
                }
                break;
            case R.id.but2s:
                if (bFrm == null) {
                    bFrm = new PlayandChatFragment();
                    transaction.add(R.id.framlayouts, bFrm);
                } else {
                    transaction.show(bFrm);
                }

                break;

        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (aFrm != null) {
            transaction.hide(aFrm);
        }
        if (bFrm != null) {
            transaction.hide(bFrm);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}

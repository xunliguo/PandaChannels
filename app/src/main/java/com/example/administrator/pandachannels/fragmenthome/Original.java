package com.example.administrator.pandachannels.fragmenthome;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.format.Time;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeOrginal;
import com.example.administrator.pandachannels.fragmenthome.adap.HomeOrginaAdap;
import com.example.administrator.pandachannels.framework.baseview.BaseActivity;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.administrator.pandachannels.framework.utils.Url;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//阿萨德阿萨德按时
public class Original extends BaseActivity {

    private ImageView homeorigimage;
    private XRecyclerView homeorigxdrecycle;
    List<HomeOrginal.InteractiveBean> list=new ArrayList<HomeOrginal.InteractiveBean>();
    private ProgressDialog lo;
    private RecyclerAdapterWithHF withHF;
    private TextView time;

    @Override
    protected int getlayoutID() {
        lo = new ProgressDialog(Original.this);
        return R.layout.activity_original;
    }
    @Override
    protected void initData() {
        lo.show();
        OkHttpUtils.getInstance().getNetData(Url.HUDONG, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                HomeOrginal homeOrginal = new Gson().fromJson(ss, HomeOrginal.class);
                list.addAll(homeOrginal.getInteractive());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      withHF.notifyDataSetChanged();
                    }
                });
                lo.dismiss();
            }
        });
        homeorigxdrecycle.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        HomeOrginaAdap adap=new HomeOrginaAdap(Original.this,list);
        withHF = new RecyclerAdapterWithHF(adap);
        homeorigxdrecycle.setAdapter(withHF);
        withHF.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                Intent intent=new Intent(Original.this,HomeWebView.class);
                intent.putExtra("homename",list.get(position-1).getTitle());
                intent.putExtra("homeurl",list.get(position-1).getUrl());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initClick() {
        homeorigimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        homeorigimage = (ImageView) findViewById(R.id.homeorigimage);
        homeorigxdrecycle = (XRecyclerView) findViewById(R.id.homeorigxdrecycle);
        time = (TextView) findViewById(R.id.hometime);

        homeorigxdrecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshComplate();
                withHF.notifyDataSetChanged();
                homeorigxdrecycle.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                homeorigxdrecycle.loadMoreComplete();
            }
        });

    }
    public void refreshComplate(){
        //注释的是时间文本  有需要可以去掉  也是在布局里改可见属性
//        mHeaderTimeView.setText(friendlyTime(new Date()));
        time.setText(friendlyTime(new Date()));
    }
    //刷新时间计算
    public static String friendlyTime(Date time) {
        //获取time距离当前的秒数
        Time t=new Time();
        t.setToNow();
        int year = t.year;
        int month = t.month;
        int date = t.monthDay;
        int hour = t.hour;
        int minute = t.minute;
        int second = t.second;
        String str=year+"年"+month+"月"+date+"日"+hour+":"+minute+":"+second;
        return str;
    }

}

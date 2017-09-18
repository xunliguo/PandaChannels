package com.example.administrator.pandachannels.fragmentlive.fragment;


import android.app.ProgressDialog;
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
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PandaLiveBean;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.fragmentlive.presenter.LivePandaPersenterImpl;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;
import com.example.administrator.pandachannels.framework.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class Xianlive_subfragment extends BaseFragment implements MainContract.XSubView, View.OnClickListener {
     LivePandaPersenterImpl livePandaPersenter=new LivePandaPersenterImpl(this);
         int a = 0;


    ArrayList<String> lists = new ArrayList<>();
    MyAdapters adapters ;

      private JCVideoPlayer videoController;
    private TextView textView;
    TextView text1;
    private ListView listView;
    ManyFragment aFrm;
    PlayandChatFragment bFrm;
    private TextView title;
    private ImageView up;
    private String title1;
    private String brief;
    private ProgressDialog dialog;
    private String image;


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

    @Override
    public void showrror() {

    }

    @Override
    protected void initView(View view) {
        videoController = view.findViewById(R.id.videocontroller1);

//        listView = view.findViewById(R.id.listView);
        text1 = view.findViewById(R.id.text1);
        up = view.findViewById(R.id.up);
        textView = view.findViewById(R.id.text);

//      ----------------------------------------------

        title = view.findViewById(R.id.titlename);
//        adapters = new MyAdapters(getActivity(),lists);
//        listView.setAdapter(adapters);
        Button but1s = view.findViewById(R.id.but1s);
        Button but2s = view.findViewById(R.id.but2s);
        but1s.setOnClickListener(this) ;
        but2s.setOnClickListener(this);
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("正在加载....");

        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        aFrm=new ManyFragment();
        transaction.add(R.id.framlayouts,aFrm);
        transaction.commit();
        livePandaPersenter.requsetData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_xianlive_subfragment;
    }

    @Override
    protected void initData() {

             videoController.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4\"","");

              videoController.ivThumb.setImageResource(R.drawable.panda);
              videoController.setThumbImageViewScalType(ImageView.ScaleType.CENTER_CROP);

        intDate();


    }

    private void intDate() {
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (a){
                    case 0:
                        a=1;
                        title.setVisibility(View.VISIBLE);
                        up.setImageResource(R.drawable.lpanda_off);

                        break;
                    case 1:
                        a=0;
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
        Log.e("tag","================>"+ brief);
        textView.setText("[正在直播]"+ title1);
        title.setText(brief);
        title.setVisibility(View.GONE);

    }

    @Override
    public void showDatas1(List<ManyBean.ListBean> list) {

    }

    @Override
    public void showDatasWond(List<WondBean.VideoBean> videolist) {

    }



    @Override
    public void onClick(View view) {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
            hideAll(transaction);
        switch (view.getId()){
            case R.id.but1s:
                if (aFrm==null) {
                   aFrm= new ManyFragment();
                    transaction.add(R.id.framlayouts, aFrm);
                }else{
                    transaction.show(aFrm);
                }
                break;
            case  R.id.but2s:
                if (bFrm==null) {
                 bFrm=new PlayandChatFragment();
                    transaction.add(R.id.framlayouts,bFrm);
                }else{
                    transaction.show(bFrm);
                }

                break;

        }
        transaction.commit();
    }
   private void hideAll(FragmentTransaction transaction){
       if (aFrm!=null){
          transaction.hide(aFrm);
       }
       if (bFrm!=null){
           transaction.hide(bFrm);
       }
   }

    @Override
    public void onPause() {
        super.onPause();

        videoController.releaseAllVideos();

    }
}

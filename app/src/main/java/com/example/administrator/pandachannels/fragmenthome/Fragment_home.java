package com.example.administrator.pandachannels.fragmenthome;


import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.pandachannels.R;
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

        }
    }

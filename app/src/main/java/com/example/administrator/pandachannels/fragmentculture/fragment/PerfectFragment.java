package com.example.administrator.pandachannels.fragmentculture.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentculture.LiBean;
import com.example.administrator.pandachannels.fragmentculture.OkhttpUtils;
import com.example.administrator.pandachannels.fragmentculture.activity.CuiActivity;
import com.example.administrator.pandachannels.fragmentculture.adapter.LiAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.administrator.pandachannels.R.id.recyclerview;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfectFragment extends Fragment {
    private RecyclerView rece;
    LiAdapter adapter;
    private List<LiBean.ListBean> list = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getContext(), R.layout.fragment_perfect, null);
        initView(view);
        initData();
        return view;
    }


    private void initData () {

        OkhttpUtils.getUtil().send("http://www.ipanda.com/kehuduan/video/index.json", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                //System.out.println(string.toString() + "2222222222");
                Gson gson = new Gson();
                LiBean bean = gson.fromJson(string, LiBean.class);
                list.addAll(bean.getList());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

        adapter = new LiAdapter(getActivity(), list);
        rece.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        rece.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        rece.setAdapter(adapter);
        adapter.setItemOnClick(new LiAdapter.Listener() {
            @Override
            public void click(View v, int position) {
                Intent intent = new Intent(getActivity(), CuiActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initView(View view) {
        rece = (RecyclerView) view.findViewById(R.id.rece);
    }
}

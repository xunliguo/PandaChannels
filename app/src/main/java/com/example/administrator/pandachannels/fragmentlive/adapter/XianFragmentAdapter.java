package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class XianFragmentAdapter extends AbsAdapter<ManyBean.ListBean> {


    public XianFragmentAdapter(Context context, int layoutId, List<ManyBean.ListBean> datas) {
        super(context, layoutId, datas);



    }

    @Override
    public void bindResponse(ViewHolder holder, ManyBean.ListBean data) {
        TextView title= (TextView) holder.getView(R.id.xianTitle);
        ImageView thum = (ImageView) holder.getView(R.id.xianImg);
        title.setText(data.getTitle());
        Glide.with(App.context).load(data.getUrl()).into(thum);



    }
}
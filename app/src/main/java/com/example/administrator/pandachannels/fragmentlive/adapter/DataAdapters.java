package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class DataAdapters extends AbsAdapter<WondBean.VideoBean> {
    public DataAdapters(Context context, int layoutId, List<WondBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, WondBean.VideoBean data) {
       ImageView wond_image= (ImageView) holder.getView(R.id.wond_image);
       TextView timer = (TextView) holder.getView(R.id.wond_time);
       TextView  title= (TextView) holder.getView(R.id.wond_title);
        Glide.with(App.context).load(data.getImg()).into(wond_image);
        timer.setText(data.getT());
        title.setText(data.getT());


    }
}

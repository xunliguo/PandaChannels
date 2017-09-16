package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class PinAdapters extends AbsAdapter<PinBean> {

    public PinAdapters(Context context, int layoutId, List<PinBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, PinBean data) {
    TextView name= (TextView) holder.getView(R.id.pin_name);
       TextView contont = (TextView) holder.getView(R.id.pin_contont);
        name.setText(data.getName());
        contont.setText(data.getContont());

    }
}

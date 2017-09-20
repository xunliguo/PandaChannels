package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/19.
 */

public class HowAdaperts extends AbsAdapter<String> {

    private TextView jia_text;

    public HowAdaperts(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, String data) {
        jia_text = (TextView) holder.getView(R.id.jia_text);
        jia_text.setVisibility(View.GONE);
        jia_text.setText("d");


    }
}

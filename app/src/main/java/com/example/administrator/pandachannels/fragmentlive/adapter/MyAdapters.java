package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;

import java.util.ArrayList;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class MyAdapters extends BaseAdapter {
    Context context;
    ArrayList<String> lists ;

    public MyAdapters(Context context, ArrayList<String> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.manyitem,null);
       TextView names = (TextView) view.findViewById(R.id.names);
        names.setText(lists.get(i));
        return view;
    }
}

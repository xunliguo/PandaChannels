package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;

import java.util.List;

/**
 * Author:111
 * Time:2017/9/18
 * Motto: where my heart get peace,where my self get home.
 */
public class MyGridAdapter1 extends BaseAdapter {
    Context context;
    List<Students> list;
    private ViewHolder holder;
    String s;
    public MyGridAdapter1(){}
    public MyGridAdapter1(Context context, List<Students> lists11,String s) {
        this.context = context;
        this.list = lists11;
        this.s=s;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_poprecy1, null);
            holder.poprecy1_but1 = view.findViewById(R.id.poprecy1_but1);
            holder.imageView888= view.findViewById(R.id.imageView888);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.poprecy1_but1.setText( list.get(i).getTitle());

        return view;
    }
    class ViewHolder {
        TextView poprecy1_but1;
        ImageView imageView888;
    }
}

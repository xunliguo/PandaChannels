package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.pandachannels.R;

import java.util.ArrayList;

/**
 * Author:111
 * Time:2017/9/16
 * Motto: where my heart get peace,where my self get home.
 */
public class PopRecyAdapter1 extends RecyclerView.Adapter<PopRecyAdapter1.ViewHolder> {
    Context context;
    ArrayList<String> list;

    public PopRecyAdapter1(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_poprecy1, null);
        ViewHolder viewholder = new ViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
holder.poprecy1_but1.setText(list.get(position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //设置长按
                listen.setonlongclick(v, position);
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   设置短按
                listen.setonduanclick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button poprecy1_but1;
        ImageView poprecy1_img1;
        public ViewHolder(View itemView) {
            super(itemView);
            poprecy1_but1=itemView.findViewById(R.id.poprecy1_but1);
            poprecy1_img1=itemView.findViewById(R.id.poprecy1_img1);
        }
}
    //定义接口
    public interface Listener {
        void setonduanclick(View v, int postion);

        void setonlongclick(View v, int postion);
    }

    private Listener listen;

    //暴漏接口
    public void setonitenclicklistener(Listener listen) {
        this.listen = listen;
    }

}


package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;

import java.util.ArrayList;

/**
 * Author:111
 * Time:2017/9/14
 * Motto: where my heart get peace,where my self get home.
 */
public class MyAdapter_TaiShan extends RecyclerView.Adapter<MyAdapter_TaiShan.ViewHolder> {
    Context context;
    ArrayList<BeanTaishan.LiveBean> list;


    public MyAdapter_TaiShan(Context context, ArrayList<BeanTaishan.LiveBean> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_taishan, null);
        ViewHolder viewholder = new ViewHolder(view);

        return viewholder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getImage()).error(R.mipmap.ic_launcher).into(holder.img1_taishan);
        holder.tv1_taishan.setText(list.get(position).getTitle());


        // holder.itemView.setTag(position);///把position 设置给tag
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
        ImageView img1_taishan;
        TextView tv1_taishan;


        public ViewHolder(View itemView) {

            super(itemView);
            img1_taishan = (ImageView) itemView.findViewById(R.id.img1_taishan);
            tv1_taishan = (TextView) itemView.findViewById(R.id.tv1_taishan);

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
    ////////////////////
// 在mainActivity 调用
// adapter.setonitenclicklistener();
}

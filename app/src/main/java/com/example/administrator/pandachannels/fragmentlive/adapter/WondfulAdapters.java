package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class WondfulAdapters extends RecyclerView.Adapter<WondfulAdapters.ViewHolder> {
private List<WondBean.VideoBean> list;
    private Context context;
  private Listener listener;
    public WondfulAdapters(List<WondBean.VideoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.wondful_item, null);
        ViewHolder vholder=new ViewHolder(view);

        return vholder;
    }
//绑定数据
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.wond_name.setText(list.get(position).getT());
         holder.wond_timer.setText(list.get(position).getPtime());
        holder.lenght.setText(list.get(position).getLen());
        Glide.with(context).load(list.get(position).getImg()).into(holder.wond_imagea);


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.Onclick(position,v);
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView wond_name;
        private final TextView wond_timer;
        private final ImageView wond_imagea;
        private final TextView lenght;

        public ViewHolder(View itemView) {
            super(itemView);
            wond_name = (TextView) itemView.findViewById(R.id.wond_title);
            wond_timer = (TextView) itemView.findViewById(R.id.wond_time);
            wond_imagea = (ImageView) itemView.findViewById(R.id.wond_image);
            lenght = (TextView) itemView.findViewById(R.id.wond_length);
        }
    }
    public interface  Listener{
        void Onclick(int position, View view);

    }
    public  void setOnclick(Listener listeners){
        this.listener=listeners;

    }
}

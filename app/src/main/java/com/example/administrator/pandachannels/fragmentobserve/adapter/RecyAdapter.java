package com.example.administrator.pandachannels.fragmentobserve.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentobserve.entity.PandaViewBean;

import java.util.ArrayList;

/**
 * Created by DELL on 2017/9/15.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private Context context;
    ArrayList<PandaViewBean.ListBean> pandaBean;

    public RecyAdapter(Context context, ArrayList<PandaViewBean.ListBean> pandaBean) {
        this.context = context;
        this.pandaBean = pandaBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.listitem,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context.getApplicationContext()).load(pandaBean.get(position).getPicurl()).into(holder.img);
        holder.name.setText(pandaBean.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liener.OnItemClickLiener(view,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pandaBean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView info;
        public ViewHolder(View itemView) {
            super(itemView);
          img= (ImageView) itemView.findViewById(R.id.list_img);
           name= (TextView) itemView.findViewById(R.id.list_name);
           info= (TextView) itemView.findViewById(R.id.list_info);
        }
    }
    //全局变量
    private  OnItemClickLiener liener;
    //自定义接口
    public interface OnItemClickLiener{
        void OnItemClickLiener(View v,int position);
    }
    //自定义接口方法
    public void Dianji(OnItemClickLiener liener){
        this.liener =liener;
    }
}

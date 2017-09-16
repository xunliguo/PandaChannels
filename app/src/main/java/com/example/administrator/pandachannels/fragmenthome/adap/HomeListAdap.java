package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeRolling;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */
//敖德萨所按时的
public class HomeListAdap extends RecyclerView.Adapter {
    private Context context;
    private List<HomeRolling.ListBean> list;

    public HomeListAdap(Context context, List<HomeRolling.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.homeitem, null);
        return new ViewHould(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHould holde = (ViewHould) holder;
        Glide.with(context).load(list.get(position).getImage()).into(holde.image);
        holde.Leng.setText(list.get(position).getVideoLength());
        holde.name.setText(list.get(position).getTitle());
        holde.time.setText(list.get(position).getDaytime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHould extends RecyclerView.ViewHolder{
            ImageView image;
             TextView Leng, name, time;
        public ViewHould(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.homeimage4);
            Leng = itemView.findViewById(R.id.hometext6);
            name = itemView.findViewById(R.id.hometext7);
            time = itemView.findViewById(R.id.hometext8);
        }
    }
}

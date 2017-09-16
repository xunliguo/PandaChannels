package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.Bean.HomeOrginal;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */
//阿迪萨斯啊是的
public class HomeOrginaAdap extends RecyclerView.Adapter {

    private Context context;
    private List<HomeOrginal.InteractiveBean> list;

    public HomeOrginaAdap(Context context, List<HomeOrginal.InteractiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.orginitem, null);
        return new ViewHole(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHole holde = (ViewHole) holder;
        Glide.with(context).load(list.get(position).getImage()).into(holde.image);
        holde.tv1.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHole extends RecyclerView.ViewHolder {
        TextView tv1;
        ImageView image;

        public ViewHole(View itemView) {
            super(itemView);
            tv1=   itemView.findViewById(R.id.homeorigtext);
            image=   itemView.findViewById(R.id.homeoriga);
        }
    }
}

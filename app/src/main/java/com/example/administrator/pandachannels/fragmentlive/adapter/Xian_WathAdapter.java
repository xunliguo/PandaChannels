package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class Xian_WathAdapter extends RecyclerView.Adapter<Xian_WathAdapter.ViewHolder> {
    private Context context;
    private List<ManyBean.ListBean> mlist=new ArrayList<>();

    public Xian_WathAdapter(Context context, List<ManyBean.ListBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public Xian_WathAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.xian_watchitem, null);
        ViewHolder viewHolders=new ViewHolder(view);

        return viewHolders;
    }

    @Override
    public void onBindViewHolder(Xian_WathAdapter.ViewHolder holder, int position) {
              holder.title.setText(mlist.get(position).getTitle());
              Glide.with(context).load(mlist.get(position).getImage()).into(holder.thum);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView thum;
        private final TextView title;


        public ViewHolder(View itemView) {
            super(itemView);
             thum = itemView.findViewById(R.id.xianImg);
             title = itemView.findViewById(R.id.xianTitle);


        }
    }
}

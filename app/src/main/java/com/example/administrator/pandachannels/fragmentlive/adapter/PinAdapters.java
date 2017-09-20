package com.example.administrator.pandachannels.fragmentlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentlive.model.entity.PinBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class PinAdapters extends RecyclerView.Adapter<PinAdapters.ViewHolder>{
 private Context context;
    private List<PinBean.DataBean.ContentBean> mlist=new ArrayList<>();

    public PinAdapters(Context context, List<PinBean.DataBean.ContentBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.pin_item, null);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.contont.setText(mlist.get(position).getMessage());
        holder.name.setText(mlist.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView contont;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.pin_name);
            contont = (TextView) itemView.findViewById(R.id.pin_contont);

        }
    }
}

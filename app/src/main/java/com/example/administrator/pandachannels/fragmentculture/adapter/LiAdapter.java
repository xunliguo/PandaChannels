package com.example.administrator.pandachannels.fragmentculture.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentculture.LiBean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/18.
 */

public class LiAdapter extends RecyclerView.Adapter<LiAdapter.ViewHolder> {
    private Context context;
    private List<LiBean.ListBean> listsbe;
    private Listener listener;
    public LiAdapter(Context context, List<LiBean.ListBean> listsbe) {
        this.context = context;
        this.listsbe = listsbe;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_li,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        LiBean.ListBean listBean = listsbe.get(position);
        Glide.with(context).load(listBean.getImage()).error(R.mipmap.ic_launcher).into(viewHolder.RollingImage);
        viewHolder.RollingTitle.setText(listBean.getTitle());
        viewHolder.RollingContent.setText(listBean.getBrief());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listsbe.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView RollingImage;
        private final TextView RollingTitle;
        private final TextView RollingContent;
        public ViewHolder(View itemView) {
            super(itemView);
            RollingImage = (ImageView) itemView.findViewById(R.id.RollingImage);
            RollingTitle = (TextView) itemView.findViewById(R.id.RollingTitle);
            RollingContent = (TextView) itemView.findViewById(R.id.RollingContent);
        }
    }
    public interface Listener {
        void click(View v, int position);
    }

    public void setItemOnClick(Listener listener) {

        this.listener = listener;
    }
}

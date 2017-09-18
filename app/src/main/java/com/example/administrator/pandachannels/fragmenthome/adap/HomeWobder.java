package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeWobderfulBean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */
//奥术大师的按时
public class HomeWobder extends RecyclerView.Adapter {

    private Context context;
    private List<HomeWobderfulBean.ListBean> list;

    public HomeWobder(Context context, List<HomeWobderfulBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.wobder, null);
        return new ViewHoe(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHoe holde = (ViewHoe) holder;
        Glide.with(context).load(list.get(position).getImage()).into(holde.image);
        holde.tv_duration.setText(list.get(position).getVideoLength());
        holde.tv_name.setText(list.get(position).getTitle());
        holde.tv_time.setText(list.get(position).getDaytime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  ViewHoe extends RecyclerView.ViewHolder{
            ImageView image;
            TextView tv_duration,tv_name,tv_time;


        public ViewHoe(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.homeimageView3);
            tv_duration = itemView.findViewById(R.id.textView3);
            tv_name = itemView.findViewById(R.id.textView4);
            tv_time = itemView.findViewById(R.id.textView5);
        }
    }
}

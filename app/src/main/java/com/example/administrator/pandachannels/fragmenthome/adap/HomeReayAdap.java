package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.PandaLiveBean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */
//阿萨德按时按时
public class HomeReayAdap extends RecyclerView.Adapter {
    private Context context;
    private List<PandaLiveBean.DataBean.PandaliveBean.ListBean> list;

    public HomeReayAdap(Context context, List<PandaLiveBean.DataBean.PandaliveBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.homerecyitem, null);

        return new ViewHodle(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHodle hodel  = (ViewHodle) holder;
        Glide.with(context).load(list.get(position).getImage()).into(hodel.image);
        hodel.tvtitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHodle extends RecyclerView.ViewHolder{
        ImageView image;
        TextView tvtitle;

        public ViewHodle(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.homelive);
            tvtitle=itemView.findViewById(R.id.textView);
        }
    }
}

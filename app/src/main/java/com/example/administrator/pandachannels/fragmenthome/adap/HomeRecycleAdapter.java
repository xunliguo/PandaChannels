
package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.Bean.PandaLiveBean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */
//爱迪生ad按时 阿萨德
public class HomeRecycleAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<PandaLiveBean.DataBean.ChinaliveBean.ListBeanX> list;

    public HomeRecycleAdapter(Context context, List<PandaLiveBean.DataBean.ChinaliveBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.homelivechin, null);
        return new viewHolde(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            viewHolde holde= (viewHolde) holder;
            holde.name.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holde.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

class  viewHolde extends RecyclerView.ViewHolder{
    TextView name;
    ImageView image;

    public viewHolde(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView5);
        name=itemView.findViewById(R.id.textView7);
    }
}
}
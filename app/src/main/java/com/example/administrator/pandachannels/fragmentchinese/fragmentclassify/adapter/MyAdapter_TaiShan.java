package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;

import java.util.ArrayList;

/**
 * Author:111
 * Time:2017/9/14
 * Motto: where my heart get peace,where my self get home.
 */
public class MyAdapter_TaiShan extends RecyclerView.Adapter<MyAdapter_TaiShan.ViewHolder> {
    Context context;
    ArrayList<BeanTaishan.LiveBean> list;
    int a=0;
    private ProgressDialog dialog;

    public MyAdapter_TaiShan(Context context, ArrayList<BeanTaishan.LiveBean> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_taishan, null);
        ViewHolder viewholder = new ViewHolder(view);

        return viewholder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getImage()).error(R.mipmap.ic_launcher).into(holder.img1_taishan);
        holder.tv1_taishan.setText("     [正在直播]" + list.get(position).getTitle());
        holder.tv2_taishan.setText(list.get(position).getBrief());

        holder.relayout_taishan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //判断控件是否隐藏，如果隐藏就显示
                if (holder.layout_taishan.getVisibility()==View.GONE ){
                    holder.layout_taishan.setVisibility(View.VISIBLE);//可见
                    holder.img3_taishan.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);

                }else {
                    holder.layout_taishan.setVisibility(View.GONE);//隐藏
                    holder.img3_taishan.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                }

            }
        });

//TODO=====================
        holder.img2_taishan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.img2_taishan.setVisibility(View.GONE);
                dialog = new ProgressDialog(context);

            }
        });
        // holder.itemView.setTag(position);///把position 设置给tag
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //设置长按
                listen.setonlongclick(v, position);
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   设置短按
                listen.setonduanclick(v, position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1_taishan;
        ImageView img2_taishan;
        TextView tv1_taishan;
        RelativeLayout relayout_taishan;
        LinearLayout layout_taishan;
        TextView tv2_taishan;
ImageView img3_taishan;
        public ViewHolder(View itemView) {

            super(itemView);
            img1_taishan = itemView.findViewById(R.id.img1_taishan);
            img2_taishan = itemView.findViewById(R.id.img2_taishan);

            tv1_taishan = (TextView) itemView.findViewById(R.id.tv1_taishan);

            relayout_taishan = itemView.findViewById(R.id.relayout_taishan);
            layout_taishan = itemView.findViewById(R.id.layout_taishan);
            tv2_taishan = itemView.findViewById(R.id.tv2_taishan);
            img3_taishan = itemView.findViewById(R.id.img3_taishan);

        }
    }

    //定义接口
    public interface Listener {
        void setonduanclick(View v, int postion);

        void setonlongclick(View v, int postion);
    }

    private Listener listen;

    //暴漏接口
    public void setonitenclicklistener(Listener listen) {
        this.listen = listen;
    }
    ////////////////////
// 在mainActivity 调用
// adapter.setonitenclicklistener();
}

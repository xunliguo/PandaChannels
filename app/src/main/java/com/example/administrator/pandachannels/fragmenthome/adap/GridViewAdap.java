package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.PandaLiveBean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */
///打打实打实ad
public class GridViewAdap extends BaseAdapter {
    private Context context;
    private List<PandaLiveBean.DataBean.PandaliveBean.ListBean> list;

    public GridViewAdap(Context context, List<PandaLiveBean.DataBean.PandaliveBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
           public View getView(int position, View convertView, ViewGroup parent) {
           ViowHould hould = new ViowHould();
               if(convertView==null){
                   convertView=View.inflate(context, R.layout.homerecyitem,null);
                   hould.image= (ImageView) convertView.findViewById(R.id.homelive);
                   hould.textView= (TextView) convertView.findViewById(R.id.textView);
                   convertView.setTag(hould);
               }else{
                   hould = (ViowHould) convertView.getTag();
               }
        Glide.with(context).load(list.get(position).getImage()).into(hould.image);
            hould.textView.setText(list.get(position).getTitle());
               return convertView;
           }
           static  class ViowHould{
            ImageView image;
               TextView textView;
           }
}

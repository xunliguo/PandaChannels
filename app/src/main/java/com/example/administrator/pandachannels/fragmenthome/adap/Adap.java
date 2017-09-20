package com.example.administrator.pandachannels.fragmenthome.adap;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmenthome.bean.HomeShou;

import java.util.List;

/**
 * Created by lenovo on 2017/9/20.
 */

public class Adap extends BaseAdapter {

    private Context context;
    private List<HomeShou> list;

    public Adap(Context context, List<HomeShou> list) {
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
                   convertView=View.inflate(context, R.layout.shoucangitem,null);
                   hould.image= (ImageView) convertView.findViewById(R.id.shoucanimage);
                   hould.tv = convertView.findViewById(R.id.shoucahngtext);
                   convertView.setTag(hould);
               }else{
                   hould = (ViowHould) convertView.getTag();
               }
        Glide.with(context).load(list.get(position).getHoo()).error(R.mipmap.com_facebook_close).into(hould.image);
        System.out.println(list.get(position).getHo()+"abc");
        hould.tv.setText(list.get(position).getHo());

               return convertView;
           }
           static  class ViowHould{
            ImageView image;
            TextView tv;
            }
}

package com.example.administrator.pandachannels.fragmentobserve.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.Students;

import java.util.List;

/**
 * Author:111
 * Time:2017/9/22
 * Motto: where my heart get peace,where my self get home.
 */
public class Myadapter111 extends BaseAdapter {
    Context context;
    List<Students> list11;

    public Myadapter111(Context context, List<Students> list11) {
        this.context = context;
        this.list11 = list11;
    }

    @Override
    public int getCount() {
        return list11.size();
    }

    @Override
    public Object getItem(int i) {
        return list11.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
     ViewHolder viewholder;
              if ( convertView==null){
                         convertView=View.inflate(context, R.layout.itemhis,null) ;
                  viewholder=new ViewHolder();
                  viewholder.histv1= (TextView) convertView.findViewById(R.id.histv1);
                  viewholder.hisimg1= (ImageView) convertView.findViewById(R.id.hisimg1);
                  convertView.setTag(viewholder);
              }else {
                   viewholder= (ViewHolder) convertView.getTag();
                      }
             viewholder.histv1.setText(list11.get(i).getTitle());
        Glide.with(context).load(list11.get(i).getUrl()).into(viewholder.hisimg1);
             return convertView;
         }
         class ViewHolder{
             TextView histv1;
             ImageView hisimg1;
         }
}

package com.example.administrator.pandachannels.framework.utils;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LiYRong on 2017/7/13.
 */

public class OkHttpUtils {
    private volatile  static OkHttpUtils okHttpUtils;
    private   OkHttpClient client;
    private Handler handler;
    //单例保证该方法执行后只能在同一时间使用同一个对象
    public static synchronized OkHttpUtils getInstance(){
            if (okHttpUtils == null) {
            okHttpUtils=new OkHttpUtils();
        }
        return okHttpUtils;
    }

    //构造方法
    public OkHttpUtils() {
        this.handler = new Handler();
        client =new OkHttpClient();
    }

    //创建接口是为了实现异步调用
    public interface CallBacks{
        void getString(String ss);
    }

    //请求网络的方法  注意凡是在callback中的方法都是在子线程中执行
    public void getNetData(String url, final CallBacks callBacks){
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override//请求网络失败，失败的原因可以通过IOException e该参数转成String打印出来
            public void onFailure(Call call, IOException e) {
                System.out.println("====="+e.toString());
            }

            @Override//请求网络成功，请求回来的数据在response中保存，请求的内容在Call任务中保存，同样可以打印出来
            public void onResponse(final Call call, Response response) throws IOException {
                final String result= response.body().string();
                //为什么要使用handler.post是为了把内容发送到主线程中
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //run里面的方法都在主线中

                        callBacks.getString(result);
                    }
                });

            }
        });
    }
}
//main Activity里写
//
//  // OkHttpUtils okHttpUtils=new OkHttpUtils();
          //      OkHttpUtils.getInstance().getNetData(url, new OkHttpUtils.CallBacks() {
              //      @Override
              //      public void getString(String ss) {
              //          System.out.println("======"+ss);
			//  Toast.makeText(MainActivity.this, ss, Toast.LENGTH_SHORT).show();
               //     }
             //   });

package com.example.administrator.pandachannels.fragmentculture;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2017/7/11.
 */

public class OkhttpUtils {
    private static OkhttpUtils util;
    private OkHttpClient client;
    public OkhttpUtils(){
        client = new OkHttpClient();
    }
    public static synchronized OkhttpUtils getUtil(){
        if (util == null){
            util = new OkhttpUtils();
        }
        return util;
    }
    public void send(String url , Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

}

package com.example.administrator.pandachannels.fragmentlive.utils.net;





import com.example.administrator.pandachannels.fragmentlive.utils.net.callback.MyNetWorkCallback;

import java.util.Map;

/**
 * Created by xingge on 2017/7/11.
 */

public interface IHttp {

    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    void upload();
    void download();
    void loadImage();

}

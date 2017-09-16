package com.example.administrator.pandachannels.fragmentlive.model.biz;


import com.example.administrator.pandachannels.fragmentlive.utils.net.HttpFactroy;
import com.example.administrator.pandachannels.fragmentlive.utils.net.IHttp;

/**
 * Created by xingge on 2017/7/11.
 */

public interface BaseModel {
    public static IHttp iHttp = HttpFactroy.create();
}

package com.example.administrator.pandachannels.framework.utils;

/**
 * Author:111
 * Time:2017/9/14
 * Motto: where my heart get peace,where my self get home.
 */
public class Urls {


    //服务器  地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";
    //首页
    public static final String PANDAHOME = "http://www.ipanda.com/kehuduan/shouye/index.json";
    //首页互动
    public static final String HUDONG=BASEURL+"PAGE14501767715521482/index.json";
    //熊猫直播
    public static final String PANDALIVE = BASEURL+"PAGE14501769230331752/index.json";
    //    熊猫直播tablayout标题
    public static final String PANDALIVETAB = BASEURL+"PAGE14501772263221982/index.json";
    //列表
    public static final String PAGELIST = BASEURL+"PAGE14501786751053212/index.json";

    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";

    //熊猫文   化
    public static final String PANDACULTURE=BASEURL+"xmwh/index.json";

    //熊猫播报 （温）
    public static final String PANDABROADCAST="http://www.ipanda.com/kehuduan/PAGE14503485387528442/index.json";
    //熊猫播报 （温）下边listview
    public static final String PANDAVIEW="http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda";
    //直播中国
    public static final String LIVECHINA=BASEURL+"PAGE14501775094142282/index.json";
    //    熊猫直播 其他 fragment
    public static final String BASEOTHERFragment = "http://api.cntv.cn/video/videolistById";
    //  单视频 播放
    public static final String PANDAVOD = "http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do";
    //    熊猫直播 多视角直播
    public static final String PANDALIVEMULTI = BASEURL+"PAGE14501769230331752/PAGE14501787896813312/index.json";
    //所有的播放视频的地址
    public static final String PLAYVIDEO="http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do";

    //登录
    public static String FORM = "https://reg.cntv.cn/login/login.action";

    //获取昵称
    public static String GETNiCkNAME="http://my.cntv.cn/intf/napi/api.php";

    //手机号验证码注册
    public static String PHONEYANZHENG = "http://reg.cntv.cn/regist/getVerifiCode.action";

    //手机号注册
    public static String PHONEREGISTER="https://reg.cntv.cn/regist/mobileRegist.do";
    //版本更新
    public static final String VERSION="http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";

    //熊猫播报视频播放
    public static final String VIDEOPLAY="http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";

//    http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hdzjjmht&client=androidapp
}

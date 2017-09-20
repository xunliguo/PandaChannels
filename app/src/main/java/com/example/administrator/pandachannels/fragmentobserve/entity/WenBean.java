package com.example.administrator.pandachannels.fragmentobserve.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by DELL on 2017/9/18.
 */
@Entity
public class WenBean {


    /**
     * id : ARTIUdHOHhtvKzvi6MOCOKMv170919
     * title : 日本和歌山大熊猫“结滨”迎来一岁生日 游客送上祝福
     * source : 中国新闻网
     * pubtime : 2017-09-19 10:37:50
     * content : <p style="text-align: center;"><img src="http://p1.img.cctvpic.com/photoworkspace/contentimg/2017/09/19/2017091910370142228.jpg" alt="大熊猫&ldquo;结滨&rdquo;（资料图）" isflag="1" /></p>
     <p style="text-align: center;">大熊猫&ldquo;结滨&rdquo;（资料图）</p>
     <p>　　据日媒报道，日本和歌山县白滨町的娱乐设施&ldquo;冒险世界&rdquo;18日为满1周岁的雌性大熊猫&ldquo;结滨&rdquo;举行了庆生会。</p>
     <p>　　报道称，模仿数字&ldquo;1&rdquo;和&ldquo;结滨&rdquo;的脸型用冰块制做的蛋糕被放在户外运动场。众多到场者送上祝福。</p>
     <p>　　2016年9月18日，同一设施的雄性大熊猫&ldquo;永明&rdquo;和雌性大熊猫&ldquo;良滨&rdquo;诞下&ldquo;结滨&rdquo;。之后成长顺利，体重已达26.6公斤。据悉，性格爱玩爱闹的&ldquo;结滨&rdquo;，恒齿长齐之后已经可以嚼竹子了。</p>
     * logo : http://p1.img.cctvpic.com/photoworkspace/2017/09/19/2017091910364647899.jpg
     * guid :
     * url : http://news.ipanda.com/2017/09/19/ARTIUdHOHhtvKzvi6MOCOKMv170919.shtml
     * catalog :
     * allow_share : 1
     * allow_praise : 1
     * allow_comment : 1
     */

    private String id;
    private String title;
    private String source;
    private String pubtime;
    private String content;
    private String logo;
    private String guid;
    private String url;
    private String catalog;
    private String allow_share;
    private String allow_praise;
    private String allow_comment;

    @Generated(hash = 806766062)
    public WenBean(String id, String title, String source, String pubtime, String content, String logo, String guid, String url, String catalog, String allow_share, String allow_praise,
                   String allow_comment) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.pubtime = pubtime;
        this.content = content;
        this.logo = logo;
        this.guid = guid;
        this.url = url;
        this.catalog = catalog;
        this.allow_share = allow_share;
        this.allow_praise = allow_praise;
        this.allow_comment = allow_comment;
    }

    @Generated(hash = 1436001669)
    public WenBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getAllow_share() {
        return allow_share;
    }

    public void setAllow_share(String allow_share) {
        this.allow_share = allow_share;
    }

    public String getAllow_praise() {
        return allow_praise;
    }

    public void setAllow_praise(String allow_praise) {
        this.allow_praise = allow_praise;
    }

    public String getAllow_comment() {
        return allow_comment;
    }

    public void setAllow_comment(String allow_comment) {
        this.allow_comment = allow_comment;
    }
}

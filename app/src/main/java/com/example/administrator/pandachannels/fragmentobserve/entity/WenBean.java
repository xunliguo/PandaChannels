package com.example.administrator.pandachannels.fragmentobserve.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by DELL on 2017/9/18.
 */
@Entity
public class WenBean{


    /**
     * id : ARTIRZA94zBmXIioIreYt1jR170914
     * title : 陕西野外大熊猫种群数量达345只
     * source : 新华网
     * pubtime : 2017-09-14 09:29:16
     * content : <p>　　作为中国大熊猫主要栖息地之一，近年来，通过加大生态建设力度、有效保护物种栖息地等多举措入手，陕西珍贵濒危物种种群得到恢复和增长，其中秦岭地区野外大熊猫种群数量稳步增长，已达345只。</p>
     <p>　　在13日陕西省人民政府新闻办公室举行的新闻发布会上，陕西省林业厅新闻发言人、副厅长郭道忠说，陕西横跨秦岭南北，野生动物资源十分丰富，据全国第四次大熊猫调查，陕西秦岭地区野外大熊猫种群数量稳步增长，其种群数量比第三次调查数量明显增加，年均增长率为2．37％，密度、增幅为全国第一。</p>
     <p>　　郭道忠说，受益于近年来陕西林草植被增加、生存环境的改善，陕西野生动物的种类不断丰富、种群数量连年扩增，原来秦岭大熊猫栖息地&ldquo;岛屿化&rdquo;现象不断得到消除，秦岭大熊猫种群数量已由第三次普查时的274只增加至目前的345只。</p>
     <p>　　此外，多年来经过人工饲养、人工繁育，陕西人工圈养大熊猫的科研能力和水平逐年提高，陕西省珍稀野生动物抢救饲养研究中心在针对大熊猫发情期的行为观察、大熊猫损伤、非麻醉状态下医疗行为训练、人工育幼等方面的水平处于领先地位。今年6月11日、12日及8月21日，陕西省珍稀野生动物抢救饲养研究中心圈养的雌性大熊猫&ldquo;阳阳&rdquo;&ldquo;爱浜&rdquo;&ldquo;珠珠&rdquo;分别顺利生产，共产下4只幼仔。（记者　刘彤）</p>
     * logo : http://p1.img.cctvpic.com/photoworkspace/2017/09/14/2017091409272581958.jpg
     * guid :
     * url : http://news.ipanda.com/2017/09/14/ARTIRZA94zBmXIioIreYt1jR170914.shtml
     * catalog :
     * allow_share : 1
     * allow_praise : 1
     * allow_comment : 1
     */
    @Property(nameInDb = "id")
    private String id;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "source")
    private String source;
    @Property(nameInDb = "pubtime")
    private String pubtime;
    @Property(nameInDb = "content")
    private String content;
    @Property(nameInDb = "logo")
    private String logo;
    @Property(nameInDb = "guid")
    private String guid;
    @Property(nameInDb = "url")
    private String url;
    @Property(nameInDb = "catalog")
    private String catalog;
    @Property(nameInDb = "allow_share")
    private String allow_share;
    @Property(nameInDb = "allow_praise")
    private String allow_praise;
    @Property(nameInDb = "allow_comment")
    private String allow_comment;
    @Generated(hash = 806766062)
    public WenBean(String id, String title, String source, String pubtime, String content, String logo, String guid, String url, String catalog, String allow_share, String allow_praise, String allow_comment) {
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
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getPubtime() {
        return this.pubtime;
    }
    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getLogo() {
        return this.logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getGuid() {
        return this.guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCatalog() {
        return this.catalog;
    }
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
    public String getAllow_share() {
        return this.allow_share;
    }
    public void setAllow_share(String allow_share) {
        this.allow_share = allow_share;
    }
    public String getAllow_praise() {
        return this.allow_praise;
    }
    public void setAllow_praise(String allow_praise) {
        this.allow_praise = allow_praise;
    }
    public String getAllow_comment() {
        return this.allow_comment;
    }
    public void setAllow_comment(String allow_comment) {
        this.allow_comment = allow_comment;
    }


}

package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author:111
 * Time:2017/9/18
 * Motto: where my heart get peace,where my self get home.
 */
@Entity
public class Students {
    @Id
    Long id;
    @Property
    int order;
    String title;
    String url;
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getOrder() {
        return this.order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 719151299)
    public Students(Long id, int order, String title, String url) {
        this.id = id;
        this.order = order;
        this.title = title;
        this.url = url;
    }
    @Generated(hash = 174834727)
    public Students() {
    }

}

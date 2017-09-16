package com.example.administrator.pandachannels.fragmentobserve.entity;

import java.util.List;

/**
 * Created by DELL on 2017/9/14.
 */

public class PandaBean {

    /**
     * data : {"bigImg":[{"id":"TITE1504660688117143","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/6/1504660666980_910.jpg","order":"1","pid":"131f4ea93cc54714961db89ecd2ba797","stype":"","title":"法动物园制作30天成长视频庆祝迷你圆仔满月","type":"2","url":"http://panview.ipanda.com/2017/09/06/VIDEZGPylez5MmN1Thzk3kIl170906.shtml","vid":""}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bigImg : [{"id":"TITE1504660688117143","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/6/1504660666980_910.jpg","order":"1","pid":"131f4ea93cc54714961db89ecd2ba797","stype":"","title":"法动物园制作30天成长视频庆祝迷你圆仔满月","type":"2","url":"http://panview.ipanda.com/2017/09/06/VIDEZGPylez5MmN1Thzk3kIl170906.shtml","vid":""}]
         * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
         */

        private String listurl;
        private List<BigImgBean> bigImg;

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public static class BigImgBean {
            /**
             * id : TITE1504660688117143
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/6/1504660666980_910.jpg
             * order : 1
             * pid : 131f4ea93cc54714961db89ecd2ba797
             * stype :
             * title : 法动物园制作30天成长视频庆祝迷你圆仔满月
             * type : 2
             * url : http://panview.ipanda.com/2017/09/06/VIDEZGPylez5MmN1Thzk3kIl170906.shtml
             * vid :
             */

            private String id;
            private String image;
            private String order;
            private String pid;
            private String stype;
            private String title;
            private String type;
            private String url;
            private String vid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }
        }
    }
}

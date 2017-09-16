package com.example.administrator.pandachannels.fragmentlive.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class WondBean {


    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4925"}
     * video : [{"vsid":"VSET100167216881","order":"4929","vid":"11a617225f2f4c8683fe3443706d6550","t":"《精彩一刻》 20170915 奶黄小乔梁上线啦~","url":"http://tv.cntv.cn/video/VSET100167216881/11a617225f2f4c8683fe3443706d6550","ptime":"2017-09-15 12:43:49","img":"http://p5.img.cctvpic.com/fmspic/2017/09/15/11a617225f2f4c8683fe3443706d6550-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"},{"vsid":"VSET100167216881","order":"4930","vid":"eda031be050242bbb86008be0f8ac131","t":"《精彩一刻》 20170915 我是不是get错了重点？","url":"http://tv.cntv.cn/video/VSET100167216881/eda031be050242bbb86008be0f8ac131","ptime":"2017-09-15 12:42:17","img":"http://p1.img.cctvpic.com/fmspic/2017/09/15/eda031be050242bbb86008be0f8ac131-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4927","vid":"c54eec872eb54d28b51e1189f8295164","t":"《精彩一刻》 20170915 花式泡澡煤大爷上线","url":"http://tv.cntv.cn/video/VSET100167216881/c54eec872eb54d28b51e1189f8295164","ptime":"2017-09-15 12:40:44","img":"http://p3.img.cctvpic.com/fmspic/2017/09/15/c54eec872eb54d28b51e1189f8295164-33.jpg?p=2&h=120","len":"00:00:46","em":"CM01"},{"vsid":"VSET100167216881","order":"4928","vid":"218f69357a4f4a77be2594e9c2194f95","t":"《精彩一刻》 20170915 这是我的小宝宝~","url":"http://tv.cntv.cn/video/VSET100167216881/218f69357a4f4a77be2594e9c2194f95","ptime":"2017-09-15 12:37:20","img":"http://p1.img.cctvpic.com/fmspic/2017/09/15/218f69357a4f4a77be2594e9c2194f95-33.jpg?p=2&h=120","len":"00:00:47","em":"CM01"},{"vsid":"VSET100167216881","order":"4925","vid":"e4141e0f077d48a38d2bee7a7252dc78","t":"《精彩一刻》 20170915 奶爸引发的争风吃醋","url":"http://tv.cntv.cn/video/VSET100167216881/e4141e0f077d48a38d2bee7a7252dc78","ptime":"2017-09-15 09:55:54","img":"http://p1.img.cctvpic.com/fmspic/2017/09/15/e4141e0f077d48a38d2bee7a7252dc78-21.jpg?p=2&h=120","len":"00:00:34","em":"CM01"},{"vsid":"VSET100167216881","order":"4926","vid":"4dedc9e9e2af4fe58665381d0c676b4b","t":"《精彩一刻》 20170915 \u201c吃\u201d我一剑","url":"http://tv.cntv.cn/video/VSET100167216881/4dedc9e9e2af4fe58665381d0c676b4b","ptime":"2017-09-15 09:54:55","img":"http://p2.img.cctvpic.com/fmspic/2017/09/15/4dedc9e9e2af4fe58665381d0c676b4b-9.jpg?p=2&h=120","len":"00:00:17","em":"CM01"},{"vsid":"VSET100167216881","order":"4924","vid":"081a241d021b4dada24f8f546d3795ee","t":"《精彩一刻》 20170915 你的看起来比我的好吃","url":"http://tv.cntv.cn/video/VSET100167216881/081a241d021b4dada24f8f546d3795ee","ptime":"2017-09-15 09:53:42","img":"http://p1.img.cctvpic.com/fmspic/2017/09/15/081a241d021b4dada24f8f546d3795ee-24.jpg?p=2&h=120","len":"00:00:29","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4925
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 4929
         * vid : 11a617225f2f4c8683fe3443706d6550
         * t : 《精彩一刻》 20170915 奶黄小乔梁上线啦~
         * url : http://tv.cntv.cn/video/VSET100167216881/11a617225f2f4c8683fe3443706d6550
         * ptime : 2017-09-15 12:43:49
         * img : http://p5.img.cctvpic.com/fmspic/2017/09/15/11a617225f2f4c8683fe3443706d6550-9.jpg?p=2&h=120
         * len : 00:00:18
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}

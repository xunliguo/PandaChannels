package com.example.administrator.pandachannels.fragmenthome.Bean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */
//阿萨德阿萨德按时
public class HomeWobderfulBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/09/13/VIDEVWCcPomzyd4a58ld02pg170913.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/09/13/2017091315382487166.jpg
         * title : 翻滚吧！煤炭！
         * videoLength : 00:45
         * id : TITE1505386718615944
         * daytime : 2017-09-14
         * type : 2
         * pid : bd38f58a6ad04e749b2c0cd6837102dc
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
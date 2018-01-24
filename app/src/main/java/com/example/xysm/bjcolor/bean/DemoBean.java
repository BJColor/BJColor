package com.example.xysm.bjcolor.bean;

import java.util.List;

/**
 * Created by XYSM on 2018/1/19.
 */

public class DemoBean {

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 1507962229000
         * id : 92
         * isUse : true
         * memberId : 1
         * sort : 1
         * title : 葡萄酒资讯
         * titleImg : 2017/10/14/14-23-450763-786028748.jpg
         * titleImgUrl : http://ysc.jiuzhidao.com:8080/upload/resource/site_1/2017/10/14/14-23-450763-786028748.jpg
         */

        private long createTime;
        private int id;
        private boolean isUse;
        private int memberId;
        private int sort;
        private String title;
        private String titleImg;
        private String titleImgUrl;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsUse() {
            return isUse;
        }

        public void setIsUse(boolean isUse) {
            this.isUse = isUse;
        }

        public int getMemberId() {
            return memberId;
        }

        public void setMemberId(int memberId) {
            this.memberId = memberId;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleImg() {
            return titleImg;
        }

        public void setTitleImg(String titleImg) {
            this.titleImg = titleImg;
        }

        public String getTitleImgUrl() {
            return titleImgUrl;
        }

        public void setTitleImgUrl(String titleImgUrl) {
            this.titleImgUrl = titleImgUrl;
        }
    }
}
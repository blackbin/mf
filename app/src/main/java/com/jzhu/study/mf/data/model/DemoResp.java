package com.jzhu.study.mf.data.model;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoResp {
    /**
     * A001 = 注册有礼 不需要增加参数
     * A002 = 邀请有礼   a=sahre
     * A003 = 充值有礼   不需要带参数
     * A004 = 红包有礼
     */

    public static final String A001 = "A001";
    public static final String A002 = "A002";
    public static final String A003 = "A003";
    public static final String A004 = "A004";
    public static final String A006 = "A006";
    public static final String A011 = "A011";

    private String name;//活动名称
    private String content;//活动内容
    private Long startDate;//开始日期，毫秒
    private Long endDate;
    // 结束日期，毫秒
    private int status;// 0有效  1无效
    private String imgUrl;//图片url地址
    private String pageUrl;// H5网站url地址
    private String showPosition;//终端展示位置 ,为以后扩展预留字段
    private String bigPicUrl;// H5网站url地址
    private String smallPicUrl;// H5网站url地址
    private int needLogin; //0 需要登录 1 不需要登录
    private String actCode;

    public int getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(int needLogin) {
        this.needLogin = needLogin;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public String getBigPicUrl() {
        return bigPicUrl;
    }

    public void setBigPicUrl(String bigPicUrl) {
        this.bigPicUrl = bigPicUrl;
    }

    public String getSmallPicUrl() {
        return smallPicUrl;
    }

    public void setSmallPicUrl(String smallPicUrl) {
        this.smallPicUrl = smallPicUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getShowPosition() {
        return showPosition;
    }

    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition;
    }
}

package com.jzhu.study.mf.data.model;

import com.jzhu.study.mf.base.BaseReq;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoReq extends BaseReq{

    public static final String SHOW_POSTION_EXCHANGE ="exchange";
    public static final String SHOW_POSTION_MAIN ="main";
    public static final String SHOW_POSTION_WALLET ="wallet";
    public static final String SHOW_POSTION_INVITE ="invite";
    public static final String SHOW_POSTION_SIDEBAR ="sidebar";


    private int deviceOsType  ;//终端展示位置 ,为以后扩展预留字段

    private String showPosition;//终端展示位置 ,为以后扩展预留字段

    public String getShowPosition() {
        return showPosition;
    }

    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition;
    }

    public int getDeviceOsType() {
        return deviceOsType;
    }

    public void setDeviceOsType(int deviceOsType) {
        this.deviceOsType = deviceOsType;
    }
}

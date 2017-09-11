package com.liuzhen.tongji.util.lbs.ip;

/**
 * 百度地图ip定位
 * Created by liuzhen on 2017/9/11.
 */
public class BaiduLBSIp {
    private int status;// 返回结果状态值， 成功返回0
    private Content content;// 详细地址
    private String address;//地址

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

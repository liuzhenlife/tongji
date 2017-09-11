package com.liuzhen.tongji.util.lbs.ip;

/**
 * 百度地图ip详细内容
 * Created by liuzhen on 2017/9/11.
 */
public class Content {
    private String address;//简要地址
    private AddressDetail address_detail;//详细地址信息
    private Point point;//当前城市中心点，注意当前坐标返回类型

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressDetail getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(AddressDetail address_detail) {
        this.address_detail = address_detail;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

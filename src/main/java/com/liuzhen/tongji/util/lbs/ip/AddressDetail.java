package com.liuzhen.tongji.util.lbs.ip;

/**
 * 百度ip 详细地址信息
 * Created by liuzhen on 2017/9/11.
 */
public class AddressDetail {
    private String city;//城市
    private int city_code;//百度城市代码
    private String district;//区县
    private String province;//省份
    private String street;//街道
    private String street_number;//门址

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }
}

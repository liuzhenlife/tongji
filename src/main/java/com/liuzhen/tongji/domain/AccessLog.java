package com.liuzhen.tongji.domain;

import com.liuzhen.tongji.util.ClientOSUtils;
import com.liuzhen.tongji.util.IpUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URI;
import java.util.Calendar;

/**
 * Created by liuzhen on 2017/9/6.
 */
@Entity
@Table(name = "access_log", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class AccessLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 页面关键字
     */
    private String metaKeyword;
    /**
     * 页面摘要
     */
    private String metaDescription;
    /**
     * 页面标题
     */
    private String pageTitle;
    /**
     * 站点id
     */
    private java.lang.String siteId;
    /**
     * 站点名称
     */
    private java.lang.String siteName;
    /**
     * 访问时间
     */
    private java.util.Date createTime;
    /**
     * 访问ip
     */
    private java.lang.String ip;
    /**
     * hostname
     */
    private java.lang.String hostname;
    /**
     * mac地址
     */
    private java.lang.String macAddress;
    /**
     * 浏览器
     */
    private java.lang.String browser;
    /**
     * 用户id
     */
    private java.lang.String userId;
    /**
     * 所在省
     */
    private java.lang.String province;
    /**
     * 所在市
     */
    private java.lang.String city;
    /**
     * 县/旗
     */
    private java.lang.String county;
    /**
     * 街道
     */
    private java.lang.String street;
    /**
     * 门址
     */
    private java.lang.String streetNumber;
    /**
     * 简要地址
     */
    private java.lang.String address;
    /**
     * 详细地址信息
     */
    private java.lang.String addressDetail;
    /**
     * 年
     */
    private java.lang.Integer dateYyyy;
    /**
     * 月
     */
    private java.lang.Integer dateMm;
    /**
     * 日
     */
    private java.lang.Integer dateDd;
    /**
     * 时
     */
    private java.lang.Integer dateHh;
    /**
     * 分
     */
    private java.lang.Integer dateMinute;
    /**
     * 秒
     */
    private java.lang.Integer dateSs;
    /**
     * 城市编码
     */
    private java.lang.Integer cityCode;
    /**
     * 内容id
     */
    private java.lang.String contentId;
    /**
     * 当前浏览器语言
     */
    private java.lang.String language;
    /**
     * 操作系统
     */
    private java.lang.String os;
    /**
     * 屏幕分辩率宽度
     */
    private java.lang.Integer screenWidth;
    /**
     * 屏幕分辩率高度
     */
    private java.lang.Integer screenHeight;
    /**
     * 引用页面url,HTTP_REFERER
     */
    private java.lang.String referer;
    /**
     * 上一页面域名
     */
    private java.lang.String referrerHost;
    /**
     * 当前页面url
     */
    private java.lang.String url;
    /**
     * 当前页面域名如http://baidu.com
     */
    private java.lang.String host;
    /**
     * 颜色深度
     */
    private java.lang.Integer colorDepth;
    /**
     * 浏览器是否启用cookie\0否1是
     */
    private java.lang.Integer cookieEnabled;
    /**
     * 浏览器是否安装flash插件\0否1是
     */
    private java.lang.Integer flashEnabled;
    /**
     * flash版本
     */
    private java.lang.Integer flashVersion;
    /**
     * 来检测当前浏览器是否支持 Java小程序applet\0否1是
     */
    private java.lang.Integer javaEnabled;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 站点id
     */
    @Column(name = "SITE_ID", length = 50)
    public java.lang.String getSiteId() {
        return this.siteId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 站点id
     */
    public void setSiteId(java.lang.String siteId) {
        this.siteId = siteId;
    }

    @Column(name = "SITE_NAME", length = 255)
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date 访问时间
     */
    @Column(name = "CREATE_TIME", nullable = false)
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date 访问时间
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;

        Calendar cal = Calendar.getInstance();
        cal.setTime(createTime);

        //当前年
        int year = cal.get(Calendar.YEAR);
        this.setDateYyyy(year);

        //当前月
        int month = (cal.get(Calendar.MONTH)) + 1;
        this.setDateMm(month);

        //当前月的第几天：即当前日
        int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
        this.setDateDd(day_of_month);

        //当前时：HOUR_OF_DAY-24小时制；HOUR-12小时制
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        this.setDateHh(hour);

        //当前分
        int minute = cal.get(Calendar.MINUTE);
        this.setDateMinute(minute);

        //当前秒
        int second = cal.get(Calendar.SECOND);
        this.setDateSs(second);

        //0-上午；1-下午
        //int ampm = cal.get(Calendar.AM_PM);
        //当前年的第几周
        //int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
        //当前月的第几周
        //int week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
        //当前年的第几天
        //int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 访问ip
     */
    @Column(name = "IP", length = 255)
    public java.lang.String getIp() {
        return this.ip;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 访问ip
     */
    public void setIp(java.lang.String ip) {
        this.ip = ip;
        this.setHostname(IpUtils.getHostName(ip));
//        this.setMacAddress(IpUtils.getMacAddress(ip));
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String hostname
     */
    @Column(name = "HOSTNAME", length = 50)
    public java.lang.String getHostname() {
        return this.hostname;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String hostname
     */
    public void setHostname(java.lang.String hostname) {
        this.hostname = hostname;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String mac地址
     */
    @Column(name = "MAC_ADDRESS", length = 50)
    public java.lang.String getMacAddress() {
        return this.macAddress;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String mac地址
     */
    public void setMacAddress(java.lang.String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 浏览器
     */
    @Column(name = "BROWSER", length = 50)
    public java.lang.String getBrowser() {
        return this.browser;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 浏览器
     */
    public void setBrowser(java.lang.String browser) {
        this.browser = browser;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 用户id
     */
    @Column(name = "USER_ID",  length = 50)
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 用户id
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 所在省
     */
    @Column(name = "PROVINCE", length = 50)
    public java.lang.String getProvince() {
        return this.province;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 所在省
     */
    public void setProvince(java.lang.String province) {
        this.province = province;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 所在市
     */
    @Column(name = "CITY", length = 50)
    public java.lang.String getCity() {
        return this.city;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 所在市
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 县/旗
     */
    @Column(name = "COUNTY", length = 50)
    public java.lang.String getCounty() {
        return this.county;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 县/旗
     */
    public void setCounty(java.lang.String county) {
        this.county = county;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 年
     */
    @Column(name = "DATE_YYYY", nullable = false, precision = 4, scale = 0)
    public java.lang.Integer getDateYyyy() {
        return this.dateYyyy;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 年
     */
    public void setDateYyyy(java.lang.Integer dateYyyy) {
        this.dateYyyy = dateYyyy;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 月
     */
    @Column(name = "DATE_MM", nullable = false, precision = 2, scale = 0)
    public java.lang.Integer getDateMm() {
        return this.dateMm;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 月
     */
    public void setDateMm(java.lang.Integer dateMm) {
        this.dateMm = dateMm;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 日
     */
    @Column(name = "DATE_DD", nullable = false, precision = 2, scale = 0)
    public java.lang.Integer getDateDd() {
        return this.dateDd;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 日
     */
    public void setDateDd(java.lang.Integer dateDd) {
        this.dateDd = dateDd;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 时
     */
    @Column(name = "DATE_HH", nullable = false, precision = 2, scale = 0)
    public java.lang.Integer getDateHh() {
        return this.dateHh;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 时
     */
    public void setDateHh(java.lang.Integer dateHh) {
        this.dateHh = dateHh;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 分
     */
    @Column(name = "DATE_MINUTE", nullable = false, precision = 2, scale = 0)
    public java.lang.Integer getDateMinute() {
        return this.dateMinute;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 分
     */
    public void setDateMinute(java.lang.Integer dateMinute) {
        this.dateMinute = dateMinute;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 秒
     */
    @Column(name = "DATE_SS", nullable = false, precision = 2, scale = 0)
    public java.lang.Integer getDateSs() {
        return this.dateSs;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 秒
     */
    public void setDateSs(java.lang.Integer dateSs) {
        this.dateSs = dateSs;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 城市编码
     */
    @Column(name = "CITY_CODE", precision = 10, scale = 0)
    public java.lang.Integer getCityCode() {
        return this.cityCode;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 城市编码
     */
    public void setCityCode(java.lang.Integer cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 内容id
     */
    @Column(name = "CONTENT_ID", length = 50)
    public java.lang.String getContentId() {
        return this.contentId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 内容id
     */
    public void setContentId(java.lang.String contentId) {
        this.contentId = contentId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 当前浏览器语言
     */
    @Column(name = "LANGUAGE", length = 50)
    public java.lang.String getLanguage() {
        return this.language;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 当前浏览器语言
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 操作系统
     */
    @Column(name = "OS", length = 50)
    public java.lang.String getOs() {
        return this.os;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 操作系统
     */
    public void setOs(java.lang.String os) {
        this.os = os;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 屏幕分辩率宽度
     */
    @Column(name = "SCREEN_WIDTH", length = 4)
    public java.lang.Integer getScreenWidth() {
        return this.screenWidth;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 屏幕分辩率宽度
     */
    public void setScreenWidth(java.lang.Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 屏幕分辩率高度
     */
    @Column(name = "SCREEN_HEIGHT", length = 4)
    public java.lang.Integer getScreenHeight() {
        return this.screenWidth;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 屏幕分辩率高度
     */
    public void setScreenHeight(java.lang.Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 引用页面url,HTTP_REFERER
     */
    @Column(name = "REFERER", length = 2000)
    public java.lang.String getReferer() {
        return this.referer;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 引用页面url,HTTP_REFERER
     */
    public void setReferer(java.lang.String referer) {
        this.referer = referer;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 上一页面域名
     */
    @Column(name = "REFERRER_HOST", length = 50)
    public java.lang.String getReferrerHost() {
        return this.referrerHost;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param referrerHost
     * @param: java.lang.String 上一页面域名
     */
    public void setReferrerHost(String referrerHost) {
        this.referrerHost = referrerHost;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 当前页面url
     */
    @Column(name = "URL", length = 2000)
    public java.lang.String getUrl() {
        return this.url;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 当前页面url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  当前页面域名如http://baidu.com
     */
    @Column(name = "HOST", length = 50)
    public java.lang.String getHost() {
        return this.host;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  当前页面域名如http://baidu.com
     */
    public void setHost(java.lang.String host) {
        this.host = host;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 颜色深度
     */
    @Column(name = "COLOR_DEPTH", length = 2)
    public java.lang.Integer getColorDepth() {
        return this.colorDepth;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 颜色深度
     */
    public void setColorDepth(java.lang.Integer colorDepth) {
        this.colorDepth = colorDepth;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 浏览器是否启用cookie\0否1是
     */
    @Column(name = "COOKIE_ENABLED", precision = 1, scale = 0)
    public java.lang.Integer getCookieEnabled() {
        return this.cookieEnabled;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 浏览器是否启用cookie\0否1是
     */
    public void setCookieEnabled(java.lang.Integer cookieEnabled) {
        this.cookieEnabled = cookieEnabled;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 浏览器是否安装flash插件\0否1是
     */
    @Column(name = "FLASH_ENABLED", precision = 1, scale = 0)
    public java.lang.Integer getFlashEnabled() {
        return this.flashEnabled;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 浏览器是否安装flash插件\0否1是
     */
    public void setFlashEnabled(java.lang.Integer flashEnabled) {
        this.flashEnabled = flashEnabled;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer flash版本
     */
    @Column(name = "FLASH_VERSION", precision = 1, scale = 0)
    public java.lang.Integer getFlashVersion() {
        return this.flashVersion;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer flash版本
     */
    public void setFlashVersion(java.lang.Integer flashVersion) {
        this.flashVersion = flashVersion;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer 来检测当前浏览器是否支持 Java小程序applet\0否1是
     */
    @Column(name = "JAVA_ENABLED", precision = 1, scale = 0)
    public java.lang.Integer getJavaEnabled() {
        return this.javaEnabled;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer 来检测当前浏览器是否支持 Java小程序applet\0否1是
     */
    public void setJavaEnabled(java.lang.Integer javaEnabled) {
        this.javaEnabled = javaEnabled;
    }

    /**
     * 页面关键字
     */
    @Column(name = "meta_keyword", length = 255)
    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    /**
     * 页面摘要
     */
    @Column(name = "meta_description", length = 255)
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    /**
     * 页面标题
     */
    @Column(name = "page_title", length = 255)
    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * 街道
     */
    @Column(name = "street", length = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 门址
     */
    @Column(name = "street_number", length = 255)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * 简要地址
     */
    @Column(name = "address", length = 500)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 详细地址信息
     */
    @Column(name = "address_detail", length = 1000)
    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "AccessLog{" +
                "id='" + id + '\'' +
                ", metaKeyword='" + metaKeyword + '\'' +
                ", metaDescription='" + metaDescription + '\'' +
                ", pageTitle='" + pageTitle + '\'' +
                ", siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                ", createTime=" + createTime +
                ", ip='" + ip + '\'' +
                ", hostname='" + hostname + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", browser='" + browser + '\'' +
                ", userId='" + userId + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", address='" + address + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", dateYyyy=" + dateYyyy +
                ", dateMm=" + dateMm +
                ", dateDd=" + dateDd +
                ", dateHh=" + dateHh +
                ", dateMinute=" + dateMinute +
                ", dateSs=" + dateSs +
                ", cityCode=" + cityCode +
                ", contentId='" + contentId + '\'' +
                ", language='" + language + '\'' +
                ", os='" + os + '\'' +
                ", screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                ", referer='" + referer + '\'' +
                ", referrerHost='" + referrerHost + '\'' +
                ", url='" + url + '\'' +
                ", host='" + host + '\'' +
                ", colorDepth=" + colorDepth +
                ", cookieEnabled=" + cookieEnabled +
                ", flashEnabled=" + flashEnabled +
                ", flashVersion=" + flashVersion +
                ", javaEnabled=" + javaEnabled +
                '}';
    }
}

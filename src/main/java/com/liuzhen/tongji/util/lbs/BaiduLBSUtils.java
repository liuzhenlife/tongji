package com.liuzhen.tongji.util.lbs;

import com.liuzhen.tongji.util.HttpClientUtils;
import com.liuzhen.tongji.util.lbs.ip.BaiduLBSIp;

import java.io.IOException;

/**
 * 百度地图lbs工具类
 * Created by liuzhen on 2017/9/11.
 */
public class BaiduLBSUtils {

    private static final String API_MAP_BAIDU_DOMAIN = "http://api.map.baidu.com";

    private static final String AK = "ff5XfuydVCtDwhG2lYgPmrVLzVt0CByZ";

    public static BaiduLBSIp getIpInfo(String ip) {
        try {
            BaiduLBSIp lbsIp = HttpClientUtils.doGet(API_MAP_BAIDU_DOMAIN + "/location/ip?ak=" + AK + "&ip=" + ip, BaiduLBSIp.class);
            return lbsIp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

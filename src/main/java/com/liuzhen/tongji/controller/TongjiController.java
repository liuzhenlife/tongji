package com.liuzhen.tongji.controller;

import com.liuzhen.tongji.activemq.Producer;
import com.liuzhen.tongji.domain.AccessLog;
import com.liuzhen.tongji.service.AccessLogRepository;
import com.liuzhen.tongji.util.ClientOSUtils;
import com.liuzhen.tongji.util.IpUtils;
import com.liuzhen.tongji.util.NumberUtils;
import com.liuzhen.tongji.util.StringUtils;
import com.liuzhen.tongji.util.browser.BrowserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Date;

/**
 * 统计
 * Created by liuzhen on 2017/9/6.
 */
@RestController
@EnableAutoConfiguration
public class TongjiController {

    @Autowired
    private AccessLogRepository accessLogRepository;

    @Autowired
    private Producer producer;

    /**
     * 记录访问信息
     *
     * @param request
     */
    @RequestMapping("")
    public AccessLog index(HttpServletRequest request) {

        AccessLog log = new AccessLog();
        log.setMetaKeyword(StringUtils.defaultString(request.getParameter("metaKeyword"), ""));
        log.setMetaDescription(StringUtils.defaultString(request.getParameter("metaDescription"), ""));
        log.setPageTitle(StringUtils.defaultString(request.getParameter("pageTitle"), ""));
        log.setCreateTime(new Date());
        log.setIp(IpUtils.getIp(request));
        log.setBrowser(BrowserUtils.checkBrowse(request));
        log.setLanguage(request.getLocale().getLanguage());
        log.setOs(ClientOSUtils.getRequestSystemInfo(request));
        log.setScreenWidth(NumberUtils.toInt(request.getParameter("screenWidth"), 0));//屏幕分辨率的宽 window.screen.width
        log.setScreenHeight(NumberUtils.toInt(request.getParameter("screenHeight"), 0));//屏幕分辨率的高 window.screen.height
        log.setColorDepth(NumberUtils.toInt(request.getParameter("colorDepth"), 0));//你的屏幕设置是 window.screen.colorDepth 位彩色
        String referer=request.getHeader("Referer");
        if(StringUtils.isNoneBlank(referer)){
            log.setReferer(referer);
            log.setReferrerHost(IpUtils.getHost(URI.create(referer)).toString());
        }
        log.setCookieEnabled(NumberUtils.toInt(request.getParameter("cookieEnabled"), 0));//navigator.cookieEnabled
        log.setFlashEnabled(NumberUtils.toInt(request.getParameter("fashEnabled"), 0));
        log.setFlashVersion(NumberUtils.toInt(request.getParameter("flashVersion"), 0));
        log.setJavaEnabled(NumberUtils.toInt(request.getParameter("javaEnabled"), 0));

        String url=request.getScheme()+"://";
        url+=request.getHeader("host");
        log.setHost(url);

        url+=request.getRequestURI();
        if(request.getQueryString()!=null) {
            url+="?"+request.getQueryString();
        }
        log.setUrl(url);
        accessLogRepository.save(log);
        producer.send(log.getId());
        return log;
    }
}

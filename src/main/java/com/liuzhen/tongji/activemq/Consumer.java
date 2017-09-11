package com.liuzhen.tongji.activemq;

import com.liuzhen.tongji.domain.AccessLog;
import com.liuzhen.tongji.service.AccessLogRepository;
import com.liuzhen.tongji.util.IpUtils;
import com.liuzhen.tongji.util.lbs.BaiduLBSUtils;
import com.liuzhen.tongji.util.lbs.ip.AddressDetail;
import com.liuzhen.tongji.util.lbs.ip.BaiduLBSIp;
import com.liuzhen.tongji.util.lbs.ip.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 统计消息消费者
 * Created by liuzhen on 2017/9/8.
 */
@Component
public class Consumer {

    @Autowired
    private AccessLogRepository accessLogRepository;

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "tongji.queue")
    public void receiveQueue(String logId) {
        AccessLog log = accessLogRepository.findOne(logId);
        log.setMacAddress(IpUtils.getMacAddress(log.getIp()));

        if(!"0:0:0:0:0:0:0:1".equals(log.getIp()) && !log.getIp().startsWith("192.168")){
            BaiduLBSIp lbsIp = BaiduLBSUtils.getIpInfo(log.getIp());
            if (lbsIp.getStatus() == 0) {
                Content content = lbsIp.getContent();
                AddressDetail addressDetail = content.getAddress_detail();

                log.setProvince(addressDetail.getProvince());
                log.setCity(addressDetail.getCity());
                log.setCityCode(addressDetail.getCity_code());
                log.setCounty(addressDetail.getDistrict());
                log.setStreet(addressDetail.getStreet());
                log.setStreetNumber(addressDetail.getStreet_number());
                log.setAddress(content.getAddress());
            }
        }

        accessLogRepository.save(log);
    }
}

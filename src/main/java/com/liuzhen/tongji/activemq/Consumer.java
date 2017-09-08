package com.liuzhen.tongji.activemq;

import com.liuzhen.tongji.domain.AccessLog;
import com.liuzhen.tongji.service.AccessLogRepository;
import com.liuzhen.tongji.util.IpUtils;
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
        accessLogRepository.save(log);
        System.out.println("log = " + log);
    }
}

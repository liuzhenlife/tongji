package com.liuzhen.tongji.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by liuzhen on 2017/9/8.
 */
@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(String logId) {
        //send queue.
        this.jmsMessagingTemplate.convertAndSend(this.queue, logId);
    }
}

package com.example.demo.ActiveMQ;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
/**
 * Created by Hao on 2018/3/16.
 */
public interface Consummer {

    public JmsTemplate getJmsTemplate();
    public void setJmsTemplate(JmsTemplate jmsTemplate);
    public void receive(Destination destination);


}

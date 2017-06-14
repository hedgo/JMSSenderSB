package com.hedgo.jmssendersb.service;

import com.hedgo.model.Email;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class JMSSender {
    @Autowired JmsTemplate jmsTemplate;
    //@Autowired ActiveMQTopic myTopic01;

    public void sendSth(String userCommand) {
        String[] commandPart = userCommand.split(":");
        String destination = "topic01";

        if (commandPart.length==2) {
            destination = commandPart[1];
        }
        jmsTemplate.convertAndSend(destination, new Email("info@example.com", commandPart[0]));
    }
}



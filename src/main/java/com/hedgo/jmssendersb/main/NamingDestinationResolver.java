package com.hedgo.jmssendersb.main;

import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

public class NamingDestinationResolver implements DestinationResolver {
    public Destination resolveDestinationName(Session session, String destinationName, boolean pubSubDomain) throws JMSException {
        if (destinationName.startsWith("queue")) {
            return session.createQueue(destinationName);
        } else if (destinationName.startsWith("topic")) {
            return session.createTopic(destinationName);
        }
        throw new RuntimeException("Naming convention not respected for destination " + destinationName);
    }
}
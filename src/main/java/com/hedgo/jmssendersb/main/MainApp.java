package com.hedgo.jmssendersb.main;

import com.hedgo.jmssendersb.service.JMSSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import java.util.Scanner;

@SpringBootApplication
@EnableJms
public class MainApp {

    public static void main(String[] args) {
        System.out.println("Start do send JMS messages with Spring Boot and Apache Active MQ!");
        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);
        JMSSender jmsSender = (JMSSender) context.getBean("JMSSender");
        takeCommandFromUser(jmsSender);
    }

    private static void takeCommandFromUser(JMSSender jmsSender) {
        Scanner reader = new Scanner(System.in);
        String userCommand;

        while (true) {
            System.out.print("Enter command [text_to_send]:[destination] > ");
            userCommand = reader.nextLine();

            if ("exit".equalsIgnoreCase(userCommand)) {
                break;
            }

            jmsSender.sendSth(userCommand);
        }
    }
}

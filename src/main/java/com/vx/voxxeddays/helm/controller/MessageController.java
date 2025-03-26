package com.vx.voxxeddays.helm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Value("${demoApp.messages.messageOfTheDay}")
    private String messageOfTheDay;

    @Value("${demoApp.messages.quote}")
    private String quote;

    @GetMapping("/motd")
    public String getMessageOfTheDay() {
        return messageOfTheDay;
    }

    @GetMapping("/quote")
    public String getQuote() {
        return quote;
    }
}

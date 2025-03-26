package com.vx.voxxeddays.helm.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alpha")
@ConditionalOnProperty(value = "demoApp.features.alpha")
public class AlphaController {

    @GetMapping("/awesomeResult")
    public String getAwesomeResult() {
        return "Awesome!";
    }
}

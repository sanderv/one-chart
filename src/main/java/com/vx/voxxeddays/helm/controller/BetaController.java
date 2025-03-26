package com.vx.voxxeddays.helm.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beta")
@ConditionalOnProperty(value = "demoApp.features.beta")
public class BetaController {

    @GetMapping("/quiteStable")
    public String getStableAnswer() {
        return "I'm quite confident this is safe...";
    }
}

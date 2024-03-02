package com.microservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.limitservice.Config.Config;
import com.microservice.limitservice.entity.Limit;

@RestController
@RequestMapping("/limit")
public class LimitController {

    @Autowired
    private Config config;

    @GetMapping("/retrieveLimit")
    public Limit retrieveLimit(){
         return new Limit(config.getMinimum(),config.getMaximum());
    }
    
}

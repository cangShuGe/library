package com.cangshuge.controller;

import com.cangshuge.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@EnableAutoConfiguration
public class Test {
    @Autowired
    TestService testService;

    @RequestMapping("/hello")
//    @RequestMapping("/hello")
//    @ResponseBody
    public String hello(){
        return "hello world!";
    }
    @RequestMapping("/")
    public String testUser(){
        return testService.testShow();
    }
}

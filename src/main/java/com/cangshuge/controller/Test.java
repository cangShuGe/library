package com.cangshuge.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@EnableAutoConfiguration
public class Test {
   // @RequestMapping("/hello")
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world!";
    }
}

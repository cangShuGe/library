package com.cangshuge.controller;

import com.alibaba.fastjson.JSONObject;
import com.cangshuge.service.TestService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
//@Controller
//@EnableAutoConfiguration
public class Test {
    @Autowired
    TestService testService;

    //private static Logger log = LoggerFactory.getLogger(Test.class);

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

    @RequestMapping("/user/login")//并未成功
    JSONObject hello1 (String username, String password, HttpServletRequest request){
        //log.info("登录请求...username="+username+"  pwd=" + password);
        JSONObject r = new JSONObject();
        if("admin".equals(username) && "123456".equals(password))   {
            r.put("code", "200");
            r.put("msg", "登录成功");
            //r.put("token", TokenUtil.getToken(username));
            //Token验证！！！
        }else{
            r.put("code", "500");
            r.put("msg", "登录失败");
        }
        return r;
    }

}

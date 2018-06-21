package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.User;
import com.cangshuge.service.UserService;
import com.cangshuge.utils.ValidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    /*JsonResult login(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);//将出错信息打印出来
        }
        return userService.login(user.getAccount(),user.getPwd());
    }*/

    /**
     * 实现用户登录功能
     * @param
     * @return
     */
    /*@RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    JsonResult login(@RequestBody User user){//法1
        System.out.println(user.getAccount());
        System.out.println(user.getPwd());
        System.out.println("------------------------------------------");
        return userService.login(user.getAccount(),user.getPwd());
    }*/

    @RequestMapping("/userLogin")
    JsonResult login(String account,String pwd){//法1
        System.out.println(account);
        System.out.println(pwd);
        System.out.println("------------------------------------------");
        return userService.login(account,pwd);
    }

    /**
     * 实现普通用户的注册
     * @param user
     * @param result
     * @return result是捕获错误，ValidResult是显示错误
     */
    @RequestMapping("/userSign")
    JsonResult sign(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }
        System.out.println(user.getAccount());
        return userService.sign(user);
    }
    //修改个人资料
    @RequestMapping("/updateUser")
    JsonResult updateUser(@Valid @RequestBody User user,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }
        return userService.updateUser(user);
    }

    //修改个人密码
    @RequestMapping("/updatePwd")
    JsonResult updatePwd(String account,String pwd,String newPwd){
        return userService.updatePwd(account,pwd,newPwd);
    }
    //查看用户个人信息
    @RequestMapping("/selectUser")
    JsonResult selectUser(String account){
        return userService.selectUser(account);
    }

    /**
     * 注册会员
     * @param account
     * @return
     */
    @RequestMapping("/huiyuan")
    JsonResult huiyuan(String account){
        return userService.huiyuan(account);
    }

    @RequestMapping("/recommendBooks")
    JsonResult recommendBooks(){
        return userService.recommendBooks();
    }

    @RequestMapping("/recommendOnBooks")
    JsonResult recommendOnBooks(){
        return userService.recommendOnBooks();
    }
}

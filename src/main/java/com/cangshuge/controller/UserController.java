package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.User;
import com.cangshuge.service.UserService;
import com.cangshuge.utils.ValidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param account
     * @param pwd
     * @return
     */
    @RequestMapping("/userLogin")
    JsonResult login(String account,String pwd){
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
    //查看用户个人信息
    @RequestMapping("/selectUser")
    JsonResult selectUser(String account){
        return userService.selectUser(account);
    }
}

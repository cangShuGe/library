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

    /**
     * 用户登录
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("/userLogin")
    JsonResult login(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);//将出错信息打印出来
        }
        return userService.login(user.getAccount(),user.getPwd());
    }
}

package com.cangshuge.service;

import com.cangshuge.dao.UserDao;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public JsonResult login(String account,String pwd){
        User user = userDao.login(account);
        if (user == null){
            return new JsonResult("用户名称输入错误",false);
        }else {
            if (!user.getPwd().equals(pwd)){
                return new JsonResult("用户密码输入错误！",false);
            }else {
                return new JsonResult("登录成功！",true,user);
            }
        }
    }
}

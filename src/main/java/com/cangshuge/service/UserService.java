package com.cangshuge.service;

import com.cangshuge.dao.UserDao;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public JsonResult login(String account,String pwd){
        User user = userDao.login(account);
        if (user == null){
            System.out.println("我在后端欢迎你");
            return new JsonResult("用户名称输入错误",false);
        }else {
            if (!user.getPwd().equals(pwd)){
                return new JsonResult("用户密码输入错误！",false);
            }else {
                return new JsonResult("登录成功！",true);
            }
        }
    }

    @Transactional
    public JsonResult sign(User user){
        User user1 = userDao.login(user.getAccount());
        if (user1 != null){
            return new JsonResult("用户名已存在，请重新编辑用户名称进行注册！",false);
        }else {
            userDao.sign(user);
            User user2 = userDao.login(user.getAccount());
            if (user2 == null){
                return new JsonResult("用户注册失败！",false);
            }else {
                return new JsonResult("用户注册成功！",true);
            }
        }
    }

    public JsonResult updateUser(User user){
        userDao.updateUser(user);
        return new JsonResult("更新成功！",true);
    }
    public JsonResult selectUser(String account){
        User user = userDao.selectUser(account);
        if (user == null){
            return new JsonResult("获取个人信息失败！",false);
        }
        return new JsonResult("获取个人信息成功！",true,user);
    }

    public JsonResult huiyuan(String account){
        userDao.huiyuan(account);
        User user = userDao.selectUser(account);
        if (user == null){
            return new JsonResult("网络连接出错？您还不是普通成员，无法注册会员？",false);
        }else if (user.getMember() != 1){
            return new JsonResult("注册失败！",false);
        }
        return new JsonResult("注册成功！",true);
    }
}

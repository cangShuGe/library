package com.cangshuge.dao;

import com.cangshuge.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    /**
     * 获取用户个人信息 用户登录
     * @param account
     * @return 用户个人信息
     */
    @Select("select * from user where account=#{account,jdbcType=VARCHAR}")
    User login(String account);
}

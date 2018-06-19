package com.cangshuge.dao;

import com.cangshuge.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    /**
     * 获取用户个人信息 用户登录
     * @param account
     * @return 用户个人信息
     */
    @Select("select * from user where binary account=#{account}")
    User login(String account);

    /**
     * 实现用户注册 注册时为普通用户
     * @param user
     */
    @Insert("insert into user(account,pwd,mailbox,member,address,credit,name,sex,birthday) " +
            "values(#{user.account},#{user.pwd},#{user.mailbox}," +
            "#{user.member},#{user.address},#{user.credit}," +
            "#{user.name},#{user.sex},#{user.birthday})")
    void sign(@Param("user")User user);

    /**
     * 修改用户个人资料
     * @param user
     */
    @Update("update user set account=#{user.account},pwd=#{user.pwd}," +
            "mailbox=#{user.mailbox},member=#{user.member}," +
            "address=#{user.address},credit=#{user.credit},name=#{user.name}," +
            "sex=#{user.sex},birthday=#{user.birthday} where account=#{user.account}")
    void updateUser(@Param("user") User user);

    /**
     * 查看个人资料
     * @param account
     * @return
     */
    @Select("select * from user where account = #{account,jdbcType=VARCHAR}")
    User selectUser(@Param("account")String account);
}

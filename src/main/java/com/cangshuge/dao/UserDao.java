package com.cangshuge.dao;

import com.cangshuge.entity.Book;
import com.cangshuge.entity.Recommend;
import com.cangshuge.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    @Update("update user set account=#{user.account}," +
            "mailbox=#{user.mailbox},member=#{user.member}," +
            "address=#{user.address},credit=#{user.credit},name=#{user.name}," +
            "sex=#{user.sex},birthday=#{user.birthday} where binary account=#{user.account}")
    void updateUser(@Param("user") User user);

    /**
     * 修改用户密码
     * @param account
     * @param pwd
     */
    @Update("update user set pwd = #{pwd} where account = #{account}")
    void updatePwd(@Param("account") String account,@Param("pwd") String pwd);

    /**
     * 修改普通用户的积分
     * @param account
     * @param sum
     */
    @Update("update user set credit = credit + #{sum} where account=#{account}")
    void updateCredit(@Param("account") String account,@Param("sum") int sum);

    /**
     * 查看个人资料
     * @param account
     * @return
     */
    @Select("select * from user where binary account = #{account}")
    User selectUser(@Param("account")String account);

    /**
     * 注册成为会员
     * @param account
     */
    @Update("update user set member=1 where binary account = #{account}")
    void huiyuan(@Param("account") String account);// 1表示会员

    @Results({
            @Result(property = "bookno",column = "booknum"),
            @Result(property = "avgscore",column = "avg_scores"),
            @Result(property = "bookname",column = "bookname"),
            @Result(property = "author",column = "author"),
            @Result(property = "price",column = "price"),
            @Result(property = "resume",column = "resume"),
            @Result(property = "url",column = "url")
    })
    @Select("select book.bookno as booknum,AVG(score) as avg_scores,bookname,author,price,resume,url " +
            "from record,book where record.bookno = book.bookno group by book.bookno order by AVG(score) desc")
    List<Recommend> recommendBooks(); //对书籍评分进行了排序 推荐实体书籍

    @Results({
            @Result(property = "bookno",column = "booknum"),
            @Result(property = "avgscore",column = "avg_scores"),
            @Result(property = "bookname",column = "bookname"),
            @Result(property = "author",column = "author"),
            @Result(property = "price",column = "price"),
            @Result(property = "resume",column = "resume"),
            @Result(property = "url",column = "url"),
            @Result(property = "press",column = "press")
    })
    @Select("select onlinebook.bookno as booknum,AVG(score) as avg_scores,bookname,author,price,resume,url,press from bookshelf,onlinebook" +
            " where bookshelf.bookno = onlinebook.bookno group by onlinebook.bookno order by AVG(score) desc")
    List<Recommend> recommendOnBooks();//推荐电子书籍

    @Select("select * from user where mailbox like #{mailbox}")
    User getByMailbox(@Param("mailbox") String mailbox);
}

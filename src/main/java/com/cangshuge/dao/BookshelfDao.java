package com.cangshuge.dao;

import com.cangshuge.entity.Bookshelf;
import com.cangshuge.entity.OnlineBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookshelfDao {
    @Results({
            @Result(property = "bookname",column = "bookname"),
            @Result(property = "author",column = "author"),
            @Result(property = "price",column ="price"),
            @Result(property = "resume",column = "resume"),
            @Result(property = "url",column = "url")
    })
    @Select("select bookname,author,price,resume,url from bookshelf,onlinebook " +
            "where binary account = #{account} and bookshelf.bookno=onlinebook.bookno")
    List<OnlineBook> getshelfbyacc(@Param("account") String account); //查看我的电子书

    @Select("select * from bookshelf where binary account=#{account} and bookno=#{bookno}")
    Bookshelf isExist(@Param("account") String account,@Param("bookno") int bookno);
    @Delete("delete from bookshelf where binary account=#{account} and bookno=#{bookno}")
    void delshelfbook(@Param("account") String account,@Param("bookno") int bookno); //删除我的一本电子书

    @Insert("insert into bookshelf(account,bookno) values(#{bookshelf.account}," +
            "#{bookshelf.bookno})")
    void addshelfbook(@Param("bookshelf") Bookshelf bookshelf); //添加电子书籍

    @Update("update bookshelf set score = #{score} where binary account=#{account} and bookno=#{bookno}")
    void updateonscore(@Param("account") String account,
                       @Param("bookno") int bookno,
                       @Param("score") int score);

    @Update("update bookshelf set judge = #{judge} where binary account=#{account} and bookno=#{bookno}")
    void updateonjudge(@Param("account") String account,
                       @Param("bookno") int bookno,
                       @Param("judge") String judge);
}

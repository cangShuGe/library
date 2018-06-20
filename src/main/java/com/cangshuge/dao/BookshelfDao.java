package com.cangshuge.dao;

import com.cangshuge.entity.Bookshelf;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookshelfDao {
    @Select("select * from bookshelf where binary account = #{account}")
    List<Bookshelf> getshelfbyacc(@Param("account") String account); //查看我的电子书

    @Select("select * from bookshelf where binary account=#{account} and bookno=#{bookno}")
    Bookshelf isExist(@Param("account") String account,@Param("bookno") int bookno);
    @Delete("delete from bookshelf where binary account=#{account} and bookno=#{bookno}")
    void delshelfbook(@Param("account") String account,@Param("bookno") int bookno); //删除我的一本电子书

    @Insert("insert into bookshelf(account,bookno) values(#{bookshelf.account}," +
            "#{bookshelf.bookno})")
    void addshelfbook(@Param("bookshelf") Bookshelf bookshelf); //添加电子书籍
}

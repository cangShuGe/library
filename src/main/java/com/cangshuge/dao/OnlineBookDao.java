package com.cangshuge.dao;

import com.cangshuge.entity.OnlineBook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OnlineBookDao {
    @Select("select * from onlinebook")
    List<OnlineBook> showOnBooks();//展示所有的电子书

    @Select("select * from onlinebook where bookname like concat('%','${name}','%') or author like concat('%','${name}','%')")
    List<OnlineBook> showByNameOrAuth(@Param("name") String name);

    @Select("select * from onlinebook where catalogno = #{catalogno}")
    List<OnlineBook> showByCata(int catalogno);

    @Select("select * from onlinebook where bookno = #{bookno}")
    OnlineBook getOnByNo(int bookno);

    @Insert("insert into onlinebook(bookno,bookname,catalogno,author,publishTime,press,price,resume,url)" +
            " values(#{online.bookno},online.bookname},online.catalogno},online.author},online.publishTime}," +
            "online.press},online.price},online.resume},online.url})")
    void addOnlineBook(@Param("online") OnlineBook onlineBook);
}

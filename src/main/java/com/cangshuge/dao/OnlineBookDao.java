package com.cangshuge.dao;

import com.cangshuge.entity.OnlineBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OnlineBookDao {
    @Select("select * from onlinebook")
    List<OnlineBook> showOnBooks();//展示所有的电子书

    @Select("select * from onlinebook where bookname = #{name} or author = #{name}")
    List<OnlineBook> showByNameOrAuth(@Param("name") String name);

    @Select("select * from onlinebook where catalogno = #{catalogno}")
    List<OnlineBook> showByCata(int catalogno);

}

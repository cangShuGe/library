package com.cangshuge.dao;

import com.cangshuge.entity.OnlineBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OnlineBookDao {
    @Select("select * from onlinebook")
    List<OnlineBook> showOnBooks();//展示所有的电子书
}

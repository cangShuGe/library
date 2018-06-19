package com.cangshuge.dao;

import com.cangshuge.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from book")
    List<Book> getAllBooks();
}

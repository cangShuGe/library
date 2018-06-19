package com.cangshuge.dao;

import com.cangshuge.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from book")
    List<Book> getAllBooks();

    @Select("select * from book where catalogno = #{catalogno}")
    List<Book> getBooksByCatalog(int catalogno);

    @Select("select * from book where bookname like concat('%','${name}','%') or author like concat('%','${name}','%')")
    List<Book> getBooksByName(@Param("name") String name);

    @Select("select * from book where bookno = #{bookno}")
    Book getBookByNo(int bookno);//根据一本书得到这本书的详细信息
}

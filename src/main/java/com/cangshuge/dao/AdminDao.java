package com.cangshuge.dao;

import com.cangshuge.entity.Book;
import com.cangshuge.entity.Catalog;
import com.cangshuge.entity.OnlineBook;
import com.cangshuge.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminDao {
    @Select("select * from catalog where catalogno = #{catalogno}")
    Catalog isExist(int catalogno);
    @Insert("insert into catalog(catalogno,catalogname) values(#{catalog.catalogno},#{catalog.catalogname})")
    void addcata(@Param("catalog") Catalog catalog);//添加用户分类信息

    @Insert("insert into book(bookno,bookname,catalogno,author,publishTime,press,price,total,resume,url) " +
            "values(#{book.bookno},#{book.bookname},#{book.catalogno},#{book.author},#{book.publishTime}," +
            "#{book.press},#{book.price},#{book.total},#{book.resume},#{book.url})")
    void addbook(@Param("book") Book book);//添加书籍信息

    @Update("update book set price = #{price},total=#{total} where bookno=#{bookno}")
    void updatebook(@Param("bookno") int bookno,
                @Param("price") double price,
                @Param("total") int total);

    @Delete("delete from book where bookno=#{bookno}")
    void delbooks(int bookno);

    @Select("select * from user where account = #{name} or mailbox=#{name}")
    User admingetusers(@Param("name") String name);
    @Delete("delete from user where account like #{name} or mailbox like #{name}")
    void admindelusers(@Param("name") String name);

    @Update("update user set mailbox=#{mailbox} where account like #{account}")
    void adminupusers(@Param("mailbox") String mainbox,@Param("account") String account);

    @Insert("insert into onlinebook(bookno,bookname,catalogno,author,publishTime,press,price,resume,url) " +
            "values(#{book.bookno},#{book.bookname},#{book.catalogno},#{book.author},#{book.publishTime}," +
            "#{book.press},#{book.price},#{book.resume},#{book.url})")
    void addonbook(@Param("book") OnlineBook book);//添加电子书籍信息

    @Update("update onlinebook set price = #{price} where bookno=#{bookno}")
    void updateonbook(@Param("bookno") int bookno,
                    @Param("price") double price);

    @Delete("delete from onlinebook where bookno=#{bookno}")
    void delonbooks(int bookno);
}

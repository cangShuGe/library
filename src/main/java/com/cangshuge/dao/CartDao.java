package com.cangshuge.dao;

import com.cangshuge.entity.Cart;
import com.cangshuge.entity.GetCart;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartDao {
    @Insert("insert into cart(account,bookno,addtime,num) values (#{cart.account}," +
            "#{cart.bookno},#{cart.addtime},#{cart.num})")
    void addbook(@Param("cart") Cart cart);

    @Select("select * from cart where account=#{account} and bookno=#{bookno} and addtime = #{addtime}")
    Cart isExist(@Param("account") String account,
                 @Param("bookno") int bookno,
                 @Param("addtime") long addtime);

    @Results({
            @Result(property = "bookname",column = "bookname"),
            @Result(property = "author",column = "author"),
            @Result(property = "price",column = "price"),
            @Result(property = "resume",column = "resume"),
            @Result(property = "num",column = "num"),
            @Result(property = "addtime",column = "addtime"),
            @Result(property = "bookno",column = "booknum")
    })
    @Select("select bookname,author,price,resume,num,addtime,book.bookno as booknum from cart,book where binary account = #{account} and cart.bookno = book.bookno")
    List<GetCart> getAllFromCart(String account);

    @Delete("delete from cart where binary account=#{account} and bookno=#{bookno} and addtime=#{addtime}")
    void delcart(@Param("account") String account,
                 @Param("bookno") int bookno,
                 @Param("addtime") long addtime);

    @Update("update cart set num=#{cart.num} where binary account=#{cart.account}" +
            " and bookno=#{cart.bookno} and addtime=#{cart.addtime}")
    void updatecart(@Param("cart") Cart cart);
}

package com.cangshuge.dao;

import com.cangshuge.entity.Cart;
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

    @Select("select * from cart")
    List<Cart> getAllFromCart();

    @Delete("delete from cart where binary account=#{account} and bookno=#{bookno} and addtime=#{addtime}")
    void delcart(@Param("account") String account,
                 @Param("bookno") int bookno,
                 @Param("addtime") long addtime);

    @Update("update cart set num=#{cart.num} where binary account=#{cart.account}" +
            " and bookno=#{cart.bookno} and addtime=#{cart.addtime}")
    void updatecart(@Param("cart") Cart cart);
}

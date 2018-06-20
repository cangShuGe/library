package com.cangshuge.service;

import com.cangshuge.dao.CartDao;
import com.cangshuge.entity.Cart;
import com.cangshuge.entity.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartDao cartDao;

    @Transactional //事务操作
    public JsonResult addbook(Cart cart){
        cartDao.addbook(cart);
        Cart cart1 = cartDao.isExist(cart.getAccount(),cart.getBookno(),cart.getAddtime());

        if (cart1 == null){
            return new JsonResult("添加失败！",false);
        }else
            return new JsonResult("恭喜你，添加购物车成功！",true);
    }

    public JsonResult getAllFromCart(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Cart> carts = cartDao.getAllFromCart();

        if (carts == null){
            return new JsonResult("网络连接失败！",false);
        }else if (carts.size() == 0){
            return new JsonResult("购物车空空如也~~~",false);
        }else{
            PageInfo<Cart> cartPageInfo = new PageInfo<>(carts);
            Long total = new Long(cartPageInfo.getPages());
            return new JsonResult(total,"获取购物车内容成功!",true,carts);
        }
    }

    public JsonResult delcart(String account,int bookno,long addtime){
        cartDao.delcart(account,bookno,addtime);
        Cart cart = cartDao.isExist(account,bookno,addtime);
        if (cart != null){
            return new JsonResult("删除记录失败！",false);
        }
        return new JsonResult("删除记录成功！",true);
    }

    public JsonResult updatecart(Cart cart){
        cartDao.updatecart(cart);
        Cart cart1 = cartDao.isExist(cart.getAccount(),cart.getBookno(),cart.getAddtime());
        if(cart1 == null){
            return new JsonResult("网络连接失败！",false);
        }else if (cart1.getNum() != cart.getNum()){
            return new JsonResult("更改信息失败！",false);
        }else {
            return new JsonResult("更改购物车信息成功！",true);
        }
    }
}

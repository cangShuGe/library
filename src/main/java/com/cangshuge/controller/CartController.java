package com.cangshuge.controller;

import com.cangshuge.entity.Cart;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.service.CartService;
import com.cangshuge.utils.ValidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping("/addbook")
    JsonResult addbook(@Valid @RequestBody Cart cart, BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else
            return cartService.addbook(cart);
    }

    @RequestMapping("/getallfromcart")
    JsonResult getAllFromCart(int pageNum,int pageSize){
        return cartService.getAllFromCart(pageNum,pageSize);
    }

    @RequestMapping("/delcart")
    JsonResult delcart(String account,int bookno,long addtime){
        return cartService.delcart(account,bookno,addtime);
    }

    @RequestMapping("/updatecartbook")
    JsonResult updatecart(@Valid @RequestBody Cart cart,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }
        return cartService.updatecart(cart);
    }
}

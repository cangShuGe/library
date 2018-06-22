package com.cangshuge.controller;

import com.cangshuge.entity.*;
import com.cangshuge.service.AdminService;
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
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/addcatalog")
    JsonResult addcata(@Valid @RequestBody Catalog catalog, BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else {
            return adminService.addcata(catalog);
        }
    }

    /**
     * 增加书籍
     * @param book
     * @param result
     * @return
     */
    @RequestMapping("/addbooks")
    JsonResult addbook(@Valid @RequestBody Book book,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else {
            return adminService.addbook(book);
        }
    }

    /**
     * 更改书籍的价格和库存
     * @param bookno
     * @param price
     * @param total
     * @return
     */
    @RequestMapping("/updbooks")
    JsonResult updatebook(int bookno,double price,int total){
        return adminService.updatebook(bookno,price,total);
    }

    /**
     *根据书籍的编号删书籍
     * @param bookno
     * @return
     */
    @RequestMapping("/delbooks")
    JsonResult delbooks(int bookno){
        return adminService.delbooks(bookno);
    }

    /**
     * 根据用户名删除或邮箱删除用户
     * @param name
     * @return
     */
    @RequestMapping("/admindelusers")
    JsonResult admindelusers(String name){
        return adminService.admindelusers(name);
    }

    /**
     * 更改邮箱
     * @param mailbox
     * @param account
     * @return
     */
    @RequestMapping("/adminupdateusers")
    JsonResult adminupusers(String mailbox,String account){
        return adminService.adminupusers(mailbox,account);
    }

    /**
     *增加电子书
     * @param onlineBook
     * @param result
     * @return
     */
    @RequestMapping("/adminaddonbooks")
    JsonResult addonbook(@Valid @RequestBody OnlineBook onlineBook,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else {
            return adminService.addonbook(onlineBook);
        }
    }

    /**
     * 更新电子书的价格
     * @param bookno
     * @param price
     * @return
     */
    @RequestMapping("/adminupdateonbooks")
    JsonResult updateonbook(int bookno,double price){
        return adminService.updateonbook(bookno,price);
    }

    /**
     * 删除电子书
     * @param bookno
     * @return
     */
    @RequestMapping("/admindelonbooks")
    JsonResult delonbooks(int bookno){
        return adminService.delonbooks(bookno);
    }

    /**
     * 增加折扣
     * @param discord
     * @param result
     * @return
     */
    @RequestMapping("/admindiscord")
    JsonResult addDiscord(@Valid @RequestBody Discord discord,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else{
            return adminService.addDiscord(discord);
        }
    }

    /**
     * 展示所有的折扣
     * @return
     */
    @RequestMapping("/showAllDiscords")
    JsonResult showDiscords(){
        return adminService.showDiscords();
    }

    /**
     * 展示所有的分类信息
     * @return
     */
    @RequestMapping("/adminShowCata")
    JsonResult adminShowCata(){
        return adminService.adminShowCata();
    }

    @RequestMapping("/admindelcata")
    JsonResult admindelCata(int catalogno){
        return adminService.admindelCata(catalogno);
    }
}

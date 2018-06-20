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

    @RequestMapping("/addbooks")
    JsonResult addbook(@Valid @RequestBody Book book,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else {
            return adminService.addbook(book);
        }
    }

    @RequestMapping("/updbooks")
    JsonResult updatebook(int bookno,double price,int total){
        return adminService.updatebook(bookno,price,total);
    }

    @RequestMapping("/delbooks")
    JsonResult delbooks(int bookno){
        return adminService.delbooks(bookno);
    }

    @RequestMapping("/admindelusers")
    JsonResult admindelusers(String name){
        return adminService.admindelusers(name);
    }

    @RequestMapping("/adminupdateusers")
    JsonResult adminupusers(String mailbox,String account){
        return adminService.adminupusers(mailbox,account);
    }

    @RequestMapping("/adminaddonbooks")
    JsonResult addonbook(@Valid @RequestBody OnlineBook onlineBook,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else {
            return adminService.addonbook(onlineBook);
        }
    }

    @RequestMapping("/adminupdateonbooks")
    JsonResult updateonbook(int bookno,double price){
        return adminService.updateonbook(bookno,price);
    }

    @RequestMapping("/admindelonbooks")
    JsonResult delonbooks(int bookno){
        return adminService.delonbooks(bookno);
    }

    @RequestMapping("/admindiscord")
    JsonResult addDiscord(@Valid @RequestBody Discord discord,BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }else{
            return adminService.addDiscord(discord);
        }
    }

    @RequestMapping("/showAllDiscords")
    JsonResult showDiscords(){
        return adminService.showDiscords();
    }
}

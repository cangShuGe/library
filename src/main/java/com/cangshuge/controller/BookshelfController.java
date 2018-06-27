package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BookshelfController {
    @Autowired
    BookshelfService bookshelfService;

    @RequestMapping("/getshelfbyacc")
    JsonResult getshelfbyacc(String account){
        return bookshelfService.getshelfbyacc(account);
    }

    @RequestMapping("/delbookshelf")
    JsonResult delshelfbook(String account,int bookno){
        return bookshelfService.delshelfbook(account,bookno);
    }

    @RequestMapping("/updonscore")
    JsonResult updateonscore(String account,int bookno,int score){
        return bookshelfService.updateonscore(account,bookno,score);
    }

    @RequestMapping("/updonjudge")
    JsonResult updateonjudge(String account,int bookno,String judge){
        return bookshelfService.updateonjudge(account,bookno,judge);
    }
}

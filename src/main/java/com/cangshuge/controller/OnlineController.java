package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.service.OnlineBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin //跨域
public class OnlineController {
    @Autowired
    OnlineBookService onlineBookService;

    @RequestMapping("/getOnBooks")
    JsonResult showOnBooks(int pageNum,int pageSize){
        return onlineBookService.showOnBooks(pageNum,pageSize);
    }
}

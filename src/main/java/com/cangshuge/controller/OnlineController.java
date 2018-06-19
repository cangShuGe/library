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

    /**
     * 获得所有书籍 进行分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/getOnBooks")
    JsonResult showOnBooks(int pageNum,int pageSize){
        return onlineBookService.showOnBooks(pageNum,pageSize);
    }

    /**
     * 根据书名或作者名搜索书籍 进行分页
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/getByNameOrAuth")
    JsonResult showByNameOrAuth(String name,int pageNum,int pageSize){
        return onlineBookService.showByNameOrAuth(name,pageNum,pageSize);
    }

    /**
     * 根据书籍分类展示书籍 进行分页
     * @param catalogno
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/getByCata")
    JsonResult showByCata(int catalogno,int pageNum,int pageSize){
        return onlineBookService.showByCata(catalogno,pageNum,pageSize);
    }

    @RequestMapping("/getonbyno")
    JsonResult getOnByNo(int bookno){
        return onlineBookService.getOnByNo(bookno);
    }
}

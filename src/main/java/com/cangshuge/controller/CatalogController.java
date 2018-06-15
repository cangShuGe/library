package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    /**
     * 获取所有的书籍分类信息
     * 用于用户选择相应的喜爱书籍
     * 用于用户按照分类查看书籍
     * @return
     */
    @RequestMapping("/getAllCatalogs")
    JsonResult showCatalogs(){
        return catalogService.showCatalogs();
    }
}

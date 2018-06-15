package com.cangshuge.service;

import com.cangshuge.dao.CatalogDao;
import com.cangshuge.entity.Catalog;
import com.cangshuge.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    CatalogDao catalogDao;

    public JsonResult showCatalogs(){
        List<Catalog> catalogs = catalogDao.showCatalogs();
        if (catalogs == null){
            return new JsonResult("网络连接失败！",false);
        }else if (catalogs.size() == 0){
            return new JsonResult("没有书籍的分类",false);
        }else
            return new JsonResult("获取用户书籍分类成功！",true,catalogs);
    }
}

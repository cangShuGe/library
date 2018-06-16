package com.cangshuge.service;

import com.cangshuge.dao.OnlineBookDao;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.OnlineBook;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineBookService {
    @Autowired
    OnlineBookDao onlineBookDao;

    /**
     *
     * @param pageNum 当前页数
     * @param pageSize 当前页面展示数目
     * @return
     */
    public JsonResult showOnBooks(int pageNum,int pageSize){
        //使用分页插件
        PageHelper.startPage(pageNum,pageSize);
        //获取分页结果
        List<OnlineBook> onlineBooks = onlineBookDao.showOnBooks();
        if (onlineBooks == null){
            return new JsonResult("网络连接失败！",false);
        }else if (onlineBooks.size() == 0){
            return new JsonResult("还没有电子书哎！",false);
        }
        //pageinfo存储了分页的一些信息，如总页数、当前页、总数据等
        PageInfo<OnlineBook> pageInfo = new PageInfo<OnlineBook>(onlineBooks);
        Long total=new Long(pageInfo.getPages());
        return new JsonResult(total,"获取当前页电子书成功！",true,onlineBooks);
    }

    public JsonResult showByNameOrAuth(String name,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<OnlineBook> onlineBooks = onlineBookDao.showByNameOrAuth(name);
       // System.out.println(onlineBooks.size());
        if (onlineBooks == null){
            return new JsonResult("网络连接失败！",false);
       }else if (onlineBooks.size() == 0){
            return new JsonResult("没有相应的电子书",false);
        }
        PageInfo<OnlineBook> onlineBookPageInfo = new PageInfo<>(onlineBooks);
        Long total=new Long(onlineBookPageInfo.getPages());
        return new JsonResult(total,"获取电子书籍成功！",true,onlineBooks);
    }

    public JsonResult showByCata(int catalogno,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<OnlineBook> onlineBooks = onlineBookDao.showByCata(catalogno);
        if (onlineBooks == null){
            return new JsonResult("网络连接失败！",false);
        }else if (onlineBooks.size() == 0){
            return new JsonResult("还没有该类电子书",false);
        }
        PageInfo<OnlineBook> onlineBookPageInfo = new PageInfo<>(onlineBooks);
        Long total=new Long(onlineBookPageInfo.getPages());
        return new JsonResult(total,"获取该类电子书成功！",true,onlineBooks);
    }
}

package com.cangshuge.service;

import com.cangshuge.dao.BookshelfDao;
import com.cangshuge.entity.Bookshelf;
import com.cangshuge.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfService {
    @Autowired
    BookshelfDao bookshelfDao ;

    public JsonResult getshelfbyacc(String account){
        List<Bookshelf> bookshelves = bookshelfDao.getshelfbyacc(account);

        if (bookshelves == null){
            return new JsonResult("网络连接失败！",false);
        }else if (bookshelves.size() == 0){
            return new JsonResult("您还没添加电子书！",false);
        }
        return new JsonResult("获取电子书成功！",true,bookshelves);
    }

    public JsonResult delshelfbook(String account,int bookno){
        bookshelfDao.delshelfbook(account,bookno);
        Bookshelf bookshelf = bookshelfDao.isExist(account,bookno);

        if (bookshelf != null){
            return new JsonResult("删除电子书籍失败！",false);
        }else {
            return new JsonResult("删除电子书籍成功！",true);
        }
    }
}

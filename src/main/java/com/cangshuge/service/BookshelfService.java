package com.cangshuge.service;

import com.cangshuge.dao.BookshelfDao;
import com.cangshuge.entity.Bookshelf;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.OnlineBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfService {
    @Autowired
    BookshelfDao bookshelfDao ;

    public JsonResult getshelfbyacc(String account){
        List<OnlineBook> bookshelves = bookshelfDao.getshelfbyacc(account);

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

    public JsonResult updateonscore(String account,int booknno,int score){
        bookshelfDao.updateonscore(account,booknno,score);
        Bookshelf bookshelf = bookshelfDao.isExist(account,booknno);
        if (bookshelf == null){
            return new JsonResult("网络连接失败！",false);
        }else if (bookshelf.getScore() != score){
            return new JsonResult("添加评分失败！",false);
        }else{
            return new JsonResult("添加评分成功！",true);
        }
    }

    public JsonResult updateonjudge(String account,int booknno,String judge){
        bookshelfDao.updateonjudge(account,booknno,judge);
        Bookshelf bookshelf = bookshelfDao.isExist(account,booknno);
        if (bookshelf == null){
            return new JsonResult("网络连接失败！",false);
        }else if (!bookshelf.getJudge().equals(judge)){
            return new JsonResult("添加评论失败！",false);
        }else{
            return new JsonResult("添加评价成功！",true);
        }
    }
}

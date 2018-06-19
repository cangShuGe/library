package com.cangshuge.service;

import com.cangshuge.dao.BookDao;
import com.cangshuge.entity.Book;
import com.cangshuge.entity.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public JsonResult getAllbooks(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookDao.getAllBooks();
        if (books == null){
            return new JsonResult("网络连接失败！",false);
        }else if (books.size() == 0){
            return new JsonResult("抱歉，现在还没实体书上架！",false);
        }else {
            PageInfo<Book> bookPageInfo = new PageInfo<>(books);
            Long total=new Long(bookPageInfo.getPages());
            return new JsonResult(total,"获取所有实体书成功！",true,books);
        }
    }
}

package com.cangshuge.service;

import com.cangshuge.dao.AdminDao;
import com.cangshuge.dao.BookDao;
import com.cangshuge.dao.OnlineBookDao;
import com.cangshuge.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    OnlineBookDao onlineBookDao;

    public JsonResult addcata(Catalog catalog){
        adminDao.addcata(catalog);
        Catalog catalog1 = adminDao.isExist(catalog.getCatalogno());
        if (catalog1 == null){
            return new JsonResult("添加分类信息失败！",false);
        }else {
            return new JsonResult("添加分类信息成功！",true);
        }
    }

    public JsonResult addbook(Book book){
        adminDao.addbook(book);
        Book book1 = bookDao.getBookByNo(book.getBookno());
        if (book1 == null){
            return new JsonResult("添加书籍信息失败！",false);
        }else{
            return new JsonResult("添加书籍信息成功！",true);
        }
    }

    public JsonResult updatebook(int bookno,double price,int total){
        adminDao.updatebook(bookno,price,total);
        return new JsonResult("更改书籍信息成功！",true);
    }

    public JsonResult delbooks(int bookno){
        adminDao.delbooks(bookno);
        Book book = bookDao.getBookByNo(bookno);
        if (book!=null){
            return new JsonResult("删除书籍信息失败！",false);
        }else{
            return new JsonResult("删除书籍信息成功！",true);
        }
    }

    public JsonResult admindelusers(String name){
        adminDao.admindelusers(name);
        User user = adminDao.admingetusers(name);
        if (user != null){
            return new JsonResult("删除用户失败！",false);
        }else{
            return new JsonResult("删除用户成功！",true);
        }
    }

    public JsonResult adminupusers(String mailbox,String account){
        adminDao.adminupusers(mailbox,account);
        return new JsonResult("修改用户邮箱成功！！",true);
    }

    public JsonResult addonbook(OnlineBook book){
        adminDao.addonbook(book);
        OnlineBook book1 = onlineBookDao.getOnByNo(book.getBookno());
        if (book1 == null){
            return new JsonResult("添加电子书籍信息失败！",false);
        }else{
            return new JsonResult("添加书电子籍信息成功！",true);
        }
    }

    public JsonResult updateonbook(int bookno,double price){
        adminDao.updateonbook(bookno,price);
        return new JsonResult("更改书籍信息成功！",true);
    }

    public JsonResult delonbooks(int bookno){
        adminDao.delonbooks(bookno);
        OnlineBook book = onlineBookDao.getOnByNo(bookno);
        if (book!=null){
            return new JsonResult("删除电子书籍信息失败！",false);
        }else{
            return new JsonResult("删除电子书籍信息成功！",true);
        }
    }
}

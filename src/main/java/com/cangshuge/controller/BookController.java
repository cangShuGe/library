package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/getAllBooks")
    JsonResult getAllBooks(int pageNum,int pageSize){
        return bookService.getAllbooks(pageNum,pageSize);
    }

    @RequestMapping("/getBooksByCata")
    JsonResult getBooksByCatalog(int catalogno,int pageNum,int pageSize){
        return bookService.getBooksByCatalog(catalogno,pageNum,pageSize);
    }

    @RequestMapping("/getBookByName")
    JsonResult getBooksByName(String name,int pageNum,int pageSize){
        return bookService.getBooksByName(name,pageNum,pageSize);
    }

    @RequestMapping("/getBookByNo")
    JsonResult getBookByNo(int bookno){
        return bookService.getBookByNo(bookno);
    }
}

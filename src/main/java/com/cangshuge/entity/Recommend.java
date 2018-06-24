package com.cangshuge.entity;

import lombok.Data;

@Data
public class Recommend {
    private int bookno;
    private double avgscore;


    private String bookname;
    private String author;
    private int price;
    private String resume;
    private String url;
    private String press;
}
//实体类可以不对应数据库
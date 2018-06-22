package com.cangshuge.entity;

import lombok.Data;

@Data
public class GetCart {
    private String bookname;
    private String author;
    private double price;
    private String resume;
    private int num;
    private long addtime;
    private int bookno;
}

package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Getter
@Setter
public class Book {
    @NotNull(message = "书籍编号不能为空")
    private int bookno;

    @NotNull(message = "书籍名称不能为空")
    private String bookname;

    @NotNull(message = "书籍类别不能为空")
    private int catalogno;

    @NotNull(message = "书籍作者不能为空")
    private String author;

    @NotNull(message = "出版时间不能为空")
    private long publishTime;

    @NotNull(message = "出版社不能为空")
    private String press;//出版社

    @NotNull(message = "价格不能为空")
    private double price;

    @NotNull(message = "库存不能为空")
    private int total;

    private String resume;
    private String url;
}

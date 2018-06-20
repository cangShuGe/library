package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Getter
@Setter
public class OnlineBook {
    @NotNull(message = "书编号不能为空")
    private int bookno;

    @NotNull(message = "书名不能为空")
    private String bookname;

    @NotNull(message = "书的类别不能为空")
    private int catalogno; //需要进行验证是否存在

    @NotNull(message = "首作者不能为空")
    private String author;

    @NotNull(message = "发行时间不能为空")
    private long publishTime;

    @NotNull(message = "出版社不能为空")
    private String press;

    @NotNull(message = "书的原始价格不能为空")
    private double price; //需要更新用户积分

    private String resume;

    private String url;
}

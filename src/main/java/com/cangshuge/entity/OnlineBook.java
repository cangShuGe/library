package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
public class OnlineBook {
    @NotEmpty(message = "书编号不能为空")
    private int bookno;

    @NotEmpty(message = "书名不能为空")
    private String bookname;

    @NotEmpty(message = "书的类别不能为空")
    private int catalogno; //需要进行验证是否存在

    @NotEmpty(message = "首作者不能为空")
    private String author;

    @NotEmpty(message = "发行时间不能为空")
    private long publishTime;

    @NotEmpty(message = "出版社不能为空")
    private String press;

    @NotEmpty(message = "书的原始价格不能为空")
    private int price; //需要更新用户积分

    private String resume;

    private String url;
}

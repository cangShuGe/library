package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class Bookshelf {
    @NotNull(message = "用户名称不能为空")
    String account;

    @NotNull(message = "书籍编号不能为空")
    int bookno;

    int score;
    String judge;

    public Bookshelf(){}
    public Bookshelf(String account,int bookno){
        this.account=account;
        this.bookno=bookno;
    }
}

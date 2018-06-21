package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class Record {
    @NotNull(message = "用户名称不能为空")
    private String account;

    @NotNull(message = "书籍编号不能为空")
    private int bookno;

    @NotNull(message = "购买时间不能为空")
    private long buyTime;

    @NotNull(message = "购买数量不能为空")
    private long num;//本次购买书籍的数量

    private int score;//评分
    private String judge;

    public Record(){}

    public Record(String account,int bookno, long buyTime,
                  int num){
        this.account=account;
        this.bookno=bookno;
        this.buyTime=buyTime;
        this.num=num;
    }
}

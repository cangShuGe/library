package com.cangshuge.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Discord {
    @NotNull(message = "书籍编号不能为空！")
    private int bookno;

    @NotNull(message = "是否是电子书不能为空")
    private int isOnline;

    @NotNull(message = "折扣信息不能为空")
    private double discord;
}

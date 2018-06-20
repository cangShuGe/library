package com.cangshuge.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Cart {
    @NotNull(message = "账户不能为空")
    private String account;

    @NotNull(message = "书籍编号不能为空")
    private int bookno;

    @NotNull(message = "加入购物车的时间不能为空")
    private long addtime;

    @NotNull(message = "购买数目不能为空")
    private int num;//购买数量
}

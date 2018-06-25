package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
public class User {
    @NotNull(message = "用户名不能为空")
    @Pattern(regexp = "^[A-Za-z_-]{4,15}$")
    private String account;//用户名由5-15位字母下划线构成

    @NotNull(message = "用户密码不能为空")
    //@Pattern(regexp = "^[A-Za-z_0-9]{6,20}$") 要用到md5 此条限制省略
    private String pwd;

    @NotNull(message = "用户邮箱不能为空")
    @Pattern(regexp = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")
    private String mailbox;

    @NotNull(message = "用户是否为会员不能为空")
    private int member;

    @NotNull(message = "用户收货地址不能为空")
    private String address;

    @NotNull(message = "用户信用积分不能为空")
    private int credit;

    private String name;

    private String sex;

    private long birthday;
}

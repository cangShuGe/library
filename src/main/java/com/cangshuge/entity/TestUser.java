package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TestUser {
    private String account;
    private String pwd;
    private String mailbox;
    private String member;
    private String address;
    private int credit;
    private String name;
    private String sex;
    private long birthday;
}

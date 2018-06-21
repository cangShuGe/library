package com.cangshuge.entity;

import lombok.Data;

@Data
public class Recommend {
    private int bookno;
    private double avgscore;
}
//实体类可以不对应数据库
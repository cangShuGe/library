package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
public class Catalog {
    @NotEmpty(message = "类别编号不能为空")
    private int catalogno;

    @NotEmpty(message = "类别名称不能为空")
    private String catalogname;
}
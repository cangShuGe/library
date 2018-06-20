package com.cangshuge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class Catalog {
    @NotNull(message = "类别编号不能为空")
    private int catalogno;

    @NotNull(message = "类别名称不能为空")
    private String catalogname;
}

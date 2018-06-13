package com.cangshuge.dao;

import com.cangshuge.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {
    @Select("select * from user")
    TestUser testUser();
}

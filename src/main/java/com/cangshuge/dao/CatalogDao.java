package com.cangshuge.dao;

import com.cangshuge.entity.Catalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatalogDao {
    @Select("select * from catalog")
    List<Catalog> showCatalogs();
}

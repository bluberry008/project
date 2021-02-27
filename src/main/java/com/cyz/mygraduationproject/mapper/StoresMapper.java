package com.cyz.mygraduationproject.mapper;

import com.cyz.mygraduationproject.bean.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoresMapper {

    List<Store>  getAllStores();
}

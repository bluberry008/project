package com.cyz.mygraduationproject.mapper;

import com.cyz.mygraduationproject.bean.ObjectJson;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
@Mapper
public interface NewsMapper {
    ArrayList<ObjectJson> getAllNews();
}

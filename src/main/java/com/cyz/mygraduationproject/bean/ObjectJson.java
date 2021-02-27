package com.cyz.mygraduationproject.bean;

import lombok.Data;

import java.util.List;
@Data
public class ObjectJson {
    Integer code;
    String msg;
    Integer count;
    List<Object> data;
}

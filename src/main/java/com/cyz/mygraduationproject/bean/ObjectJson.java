package com.cyz.mygraduationproject.bean;

import lombok.Data;

import java.util.List;
@Data
public class ObjectJson<T> {
    Integer code;
    String msg;
    Integer count;
    List<T> data;
}

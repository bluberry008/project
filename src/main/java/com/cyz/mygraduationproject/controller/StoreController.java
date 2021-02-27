package com.cyz.mygraduationproject.controller;

import com.alibaba.fastjson.JSON;
import com.cyz.mygraduationproject.bean.ObjectJson;
import com.cyz.mygraduationproject.bean.Store;
import com.cyz.mygraduationproject.service.StoresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class StoreController {

    @Autowired
    StoresService storesService;


    @GetMapping("/stores")
    @ResponseBody
    public ObjectJson getAllStores(HttpServletResponse response) throws IOException {
        List<Store> list = storesService.getAllStores();
        ObjectJson<Store> json = new ObjectJson<>();
        json.setCode(0);
        json.setMsg("success");
        json.setCount(list.size());
        json.setData(list);
        return json;
    }


}

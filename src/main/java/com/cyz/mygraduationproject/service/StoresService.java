package com.cyz.mygraduationproject.service;

import com.cyz.mygraduationproject.bean.Store;
import com.cyz.mygraduationproject.mapper.StoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoresService {

    @Autowired
    StoresMapper storesMapper;
    public List<Store> getAllStores(){
        return storesMapper.getAllStores();
    }
}

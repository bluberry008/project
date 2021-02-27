package com.cyz.mygraduationproject.service;

import com.cyz.mygraduationproject.bean.User;
import com.cyz.mygraduationproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUser(String userPhone,String userPsd){
        return userMapper.getUser(userPhone, userPsd);
    }
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    public User getUserphone(String userPhone){
        return userMapper.getUserphone(userPhone);
    }
    public void modifyPassword(User user){
        userMapper.modifyPassword(user);
    }
}

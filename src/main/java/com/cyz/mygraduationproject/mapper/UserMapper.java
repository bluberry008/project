package com.cyz.mygraduationproject.mapper;

import com.cyz.mygraduationproject.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     User getUser(String userPhone, String userPsd);
     void insertUser(User user);
     User getUserphone(String userPhone);
     void modifyPassword(User user);
}

package com.cyz.mygraduationproject.bean;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userPhone;
    private String userPsd;
    private String userName;
    private String userRole; //1代表管理员 2代表普通用户
    public User(){}

    public User(Integer userId, String userPhone, String userPsd, String userName, String userRole) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.userPsd = userPsd;
        this.userName = userName;
        this.userRole = userRole;
    }

    public User(String userPhone, String userPsd, String userName) {
        this.userPhone = userPhone;
        this.userPsd = userPsd;
        this.userName = userName;
    }
}

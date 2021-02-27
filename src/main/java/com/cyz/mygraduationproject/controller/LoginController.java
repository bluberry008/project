package com.cyz.mygraduationproject.controller;


import com.cyz.mygraduationproject.bean.User;
import com.cyz.mygraduationproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    Writer writer=null;
    @GetMapping(value={"/","/index"})
    public String hello(){
        return "userHTML/login";
    }

    @PostMapping("/login")
    public void loginr(@RequestParam("userPhone")String userPhone,@RequestParam("userPsd")String userPsd, HttpSession session,HttpServletResponse response) throws IOException {
        log.info(userPhone);
        log.info(userPsd);
        User user = userService.getUser(userPhone, userPsd);
        log.info(user.getUserRole());
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        if (user != null) {
            session.setAttribute("loginUser", user.getUserName());
             String role=user.getUserRole();
             log.info(role);
            if (role == "1") {
                log.info("进入用户登录判断");
                try {
                    writer = response.getWriter();
                    writer.write("success1");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
            } else if (role.equals("2")) {
                log.info("进入管理员登录判断");
                try {
                    writer = response.getWriter();
                    writer.write("success2");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
            }else{
                try {
                    writer = response.getWriter();
                    writer.write("failure");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
            }
        }
    }

    @GetMapping("/login.html")
    public String login() {


          return "storeHTML/store";
    }

    @GetMapping("/register")
    public String register(){
        return "userHTML/register";
    }

    @PostMapping("/registerData")
    public void register(@RequestParam("userPhone")String userPhone,@RequestParam("userName")String userName,@RequestParam("userPsd")String userPsd,HttpServletResponse response) throws IOException {
       log.info("进入register方法");
        User user=new User(userPhone,userPsd,userName);
        log.info(userPhone+userName+userPsd);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset:utf-8");
            try {
                writer= response.getWriter();
                if(userService.getUserphone(userPhone)==null) {
                    userService.insertUser(user);
                    writer.write("success");
                }else {
                    log.info("existed");
                    writer.write("existed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer!=null){
                    writer.close();
                }
            }
    }

    @GetMapping("/modifyPsd")
    public String madifypsd(){
        return "userHTML/changePwd";
    }
    @PostMapping("/modify")
    public String modifyPsd(HttpSession session,@RequestParam("psd") String psd){
        String phone=session.getAttribute("phone").toString();
        User userphone = userService.getUserphone(phone);
        userphone.setUserPsd(psd);
        userService.modifyPassword(userphone);
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/exit")
    public String exit(HttpSession session){
          session.invalidate();
          return "redirect:/index";
    }
}

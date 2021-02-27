package com.cyz.mygraduationproject.interceptor;


import com.alibaba.fastjson.JSON;
import com.cyz.mygraduationproject.bean.Message;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录检查
 * 1.配置好拦截器要拦截哪些请求、
 * 2.把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法实现之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
       log.info("拦截路径{}",requestURI);
        HttpSession session=request.getSession();
        Object loginUser=session.getAttribute("loginUser");
        if (loginUser!=null){
            return true;
        }
       // Message message=new Message();
       // message.setMessage("请先登录");
       // message.setCode(0);
        //session.setAttribute("msg","请先登录");
        //String json= JSON.toJSONString(message);
       // returnJson(response,json);

        response.sendRedirect("/");
        //request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
    private void returnJson(HttpServletResponse response,String json){
        PrintWriter writer=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try{
            writer=response.getWriter();
            writer.write(json);
        }catch(IOException e){
             e.printStackTrace();
        }finally {
             if (writer!=null){
                 writer.close();
             }
        }
    }
    /**
     * 目标方法实现之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

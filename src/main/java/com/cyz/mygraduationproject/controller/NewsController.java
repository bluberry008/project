package com.cyz.mygraduationproject.controller;

import com.cyz.mygraduationproject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {
    @Autowired
    NewsService newsService;
    @ResponseBody
    @GetMapping("/newsHTML/newsList")
    public void getAllNews(){

    }
}

package com.chen.library.manage.controller;

import com.alibaba.fastjson.JSONArray;
import com.chen.library.manage.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("index")
    public String goIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("funk")
    public JSONArray getOne(){
        JSONArray one = demoService.getOne();
        return one;
    }


}

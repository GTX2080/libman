package com.chen.library.manage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.chen.library.manage.mapper.DemoMapper;
import com.chen.library.manage.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public JSONArray getOne() {
        return demoMapper.getOne();
    }
}

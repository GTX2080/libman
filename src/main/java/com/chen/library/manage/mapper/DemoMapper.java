package com.chen.library.manage.mapper;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMapper {

    JSONArray getOne();
}

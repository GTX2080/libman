package com.chen.library.manage.mapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public interface BookMapper {

    //查询所有书籍
    JSONArray getAllBook(JSONObject param);
    //新增图书
    int addBook(JSONObject param);
    //修改图书
    int updBook(JSONObject param);
    //删除图书
    int delBook(String bookId);

}

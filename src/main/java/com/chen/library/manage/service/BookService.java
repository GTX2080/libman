package com.chen.library.manage.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chen.library.util.ResultWarp;
import org.springframework.stereotype.Service;

public interface BookService {

    //查询所有的书籍
    ResultWarp getAllBook(JSONObject param);

    //新增单个书籍
    ResultWarp addBook(JSONObject param);

    //修改书籍
    ResultWarp updBook(JSONObject param);

    //删除书籍
    ResultWarp delBook(JSONObject param);
}

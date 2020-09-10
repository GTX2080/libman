package com.chen.library.manage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chen.library.manage.mapper.BookMapper;
import com.chen.library.manage.service.BookService;
import com.chen.library.util.DataUtil;
import com.chen.library.util.ResultWarp;
import com.chen.library.util.ResultWarpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询所有图书
     * @param param
     * @return
     */
    @Override
    public ResultWarp getAllBook(JSONObject param) {

        //查询
        JSONArray allBook = bookMapper.getAllBook(param);
        if (null == allBook) {
            return ResultWarpUtil.getSuccessResult(allBook, DataUtil.FINDERROR, DataUtil.FIND_ERROR);
        } else if (allBook.size() == 0) {//查不到数据时
            return ResultWarpUtil.getSuccessResult(null, DataUtil.FINDSUCCESS, DataUtil.FIND_NULL);
        }
        //正常结果
        return ResultWarpUtil.getSuccessResult(allBook, DataUtil.FINDSUCCESS, DataUtil.FIND_SUCCESS);
    }

    @Override
    public ResultWarp addBook(JSONObject param) {
        return null;
    }

    @Override
    public ResultWarp updBook(JSONObject param) {
        return null;
    }

    @Override
    public ResultWarp delBook(JSONObject param) {
        return null;
    }
}

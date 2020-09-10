package com.chen.library.manage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chen.library.manage.service.BookService;
import com.chen.library.util.ResultWarp;
import com.chen.library.util.ResultWarpUtil;
import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("bookController")
public class BookController {

    Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;



    @RequestMapping("/bookPage")
    public String bookPageInit(){
        return "bookPage";
    }


    /** 查询图书
     * {
     *     "bookId": "10",
     *     "bookName": "存在主义咖啡馆",
     *     "author": "莎拉·贝克韦尔",
     *     "Publisher": "北京联合出版公司",
     *     "bookDescription": "巴黎。",
     *     "isbn": "9787559610782",
     *     "paperback": "568",
     *     "total": 15,
     *     "bookshelf": "1",
     *     "classification": "2",
     *     "floor": "1"
     *     "isDelete": 0,
     * }
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllBook")
    public ResultWarp getAllBook(@RequestBody JSONObject param){
        ResultWarp resultWarp;
        try{
            log.info("====》getAllBook入参"+ JSON.toJSONString(param));
            resultWarp = bookService.getAllBook(param);
            log.info("====》getAllBook出参"+ JSON.toJSONString(resultWarp));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resultWarp = ResultWarpUtil.getFailureResult(e);
        }
        return resultWarp;
    }

    /**
     * 新增图书
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/addBook")
    public ResultWarp addBook(@RequestBody JSONObject param){
        ResultWarp resultWarp;
        try{
            log.info("====》addBook入参"+ JSON.toJSONString(param));
            resultWarp = bookService.addBook(param);
            log.info("====》addBook出参"+ JSON.toJSONString(resultWarp));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            resultWarp = ResultWarpUtil.getFailureResult(e);
        }
        return resultWarp;
    }


}

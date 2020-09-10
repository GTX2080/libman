package com.chen.library.util;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;

public class ResultWarpUtil {

    private static Logger log = LoggerFactory.getLogger(ResultWarpUtil.class);

    /**
     * 返回成功结果集
     *
     * @param resultData
     * @param flag
     * @param msg
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ResultWarp getSuccessResult(Object resultData, int flag, String msg) {
        ResultWarp result = new ResultWarp();
        result.setList(resultData);
        result.setSuccess(true);
        result.setFlag(flag);
        result.setMsg(msg);
        if (resultData instanceof List) {
            PageInfo<Map<String, String>> pageInfo = new PageInfo<Map<String, String>>((List) resultData);
            result.setTotal(pageInfo.getTotal());
        }
        return result;
    }
    
    /**
     * 	返回结果集
     * @param resultData
     * @param flag
     * @param msg
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ResultWarp getResult(boolean success, int flag, String msg,Object resultData) {
        ResultWarp result = new ResultWarp();
        result.setList(resultData);
        result.setSuccess(success);
        result.setFlag(flag);
        result.setMsg(msg);
    	if (resultData instanceof List) {
    		PageInfo<Map<String, String>> pageInfo = new PageInfo<Map<String, String>>((List) resultData);
    		result.setTotal(pageInfo.getTotal());
    	}
    	return result;
    }
    /**
     * 返回失败结果集
     *
     * @param e
     * @param flag
     * @param msg
     * @return
     */
    public static ResultWarp getFailureResult(Exception e, int flag, String msg) {
        log.error("", e);
        ResultWarp result = new ResultWarp();
        result.setSuccess(false);
        result.setFlag(flag);
        result.setMsg(msg);
        return result;
    }

    /**
     * 查询数据成功的方法
     * @param resultData 数据内容
     * @return
     */
    public static ResultWarp getFindSuccessResult(Object resultData) {
        ResultWarp result = new ResultWarp();
        result.setList(resultData);
        result.setSuccess(true);
        result.setFlag(DataUtil.FINDSUCCESS);
        result.setMsg(DataUtil.FIND_SUCCESS);
        if (resultData instanceof List) {
            PageInfo<Map<String, String>> pageInfo = new PageInfo<Map<String, String>>((List) resultData);
            result.setTotal(pageInfo.getTotal());
        }
        return result;
    }

    /**
     * 查询数据失败的方法
     *
     * @param e
     * @return
     */
    public static ResultWarp getFailureResult(Exception e) {
        log.error("", e);
        ResultWarp result = new ResultWarp();
        result.setSuccess(false);
        result.setFlag(DataUtil.FINDERROR);
        result.setMsg(DataUtil.FIND_FAULT);
        return result;
    }


}

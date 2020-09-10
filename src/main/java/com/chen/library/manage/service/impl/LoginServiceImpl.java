package com.chen.library.manage.service.impl;

import com.chen.library.manage.service.LoginService;
import com.chen.library.util.MD5Utils;
import com.xxzx.attendance.common.CommonUtil;
import com.xxzx.attendance.common.DateUtil;
import com.xxzx.attendance.common.MD5Utils;
import com.xxzx.attendance.dao.ICommonDao;
import com.xxzx.attendance.dao.ILoginDao;
import com.xxzx.attendance.entity.User;
import com.xxzx.attendance.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private ILoginDao loginDao;
    @Resource
    private ICommonDao commonDao;

    /**
     * 登录验证
     * @param request
     * @return
     */
    public String loginCheck(HttpServletRequest request){
        String result = "fail";
        //用户填写的用户名和密码
        String userName = request.getParameter("userName") == null ? "" : request.getParameter("userName");
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
        Map<String,String> map = new HashMap<>();
        try {
            //密码加密
            String enPassword = MD5Utils.MD5(password);
            map.put("userName",userName);
            map.put("password",enPassword);
            int i = loginDao.loginCheck(map);
            if(i == 1){
                result = "success";
            }else{
                result = "fail";
            }
            if( !"".equals(userName) &&  !"".equals(password)){
                //存入的是加密前的密码
                User user = commonDao.getUserInfo(userName);
               // User user = new User(userName,password);
                //将用户信息存入session中
                request.getSession().setAttribute("user",user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 用户注册
     * @param request
     * @return
     */
    public String userRegister(HttpServletRequest request, Map<String, String> paramMap){
        String result = "fail";
         //通过id查询名称
        Map<String,String> deptMap = new HashMap<>();
        deptMap.put("deptId",paramMap.get("deptId"));
        String deptName = commonDao.getDeptNameByDeptId(deptMap);
        Map<String,String> officeMap = new HashMap<>();
        officeMap.put("officeId",paramMap.get("officeId"));
        String officeName = commonDao.getOfficeNameByOfficeId(officeMap);
        Map<String,String> map = new HashMap<>();
        try {
            //判断账号是否存在
            int exist = loginDao.registerCheck(paramMap);
            if(exist > 0){//存在
                result = "exist";
            }else{//不存在  可以注册
                //密码加密
                String enPassword = MD5Utils.MD5(paramMap.get("password"));
                paramMap.put("deptName",deptName);
                paramMap.put("password",enPassword);
                paramMap.put("officeName",officeName);
                paramMap.put("id", CommonUtil.getId());
                paramMap.put("flag","1");
                paramMap.put("remainingRest", "0");
                paramMap.put("nowMonthLeave", "0");
                paramMap.put("year", DateUtil.getNowYear());
                paramMap.put("month", DateUtil.getNowMonth());
                paramMap.put("remark","");
                loginDao.saveUser(paramMap);
                loginDao.addAttendanceBase(paramMap);
                result = "success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}

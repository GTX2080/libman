package com.chen.library.manage.controller;

import com.chen.library.manage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 校验用户名和密码
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    @ResponseBody
    public String loginCheck(HttpServletRequest request){
        String result = "fail";
        try {
            result = loginService.loginCheck(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 注册页面初始化
     * @return
     */
//    @RequestMapping("/initRegister")
//    public String initRegister(Model model){
//        List<Map<String,String>> deptList = commonService.getDept();
//        model.addAttribute("dept",deptList);
//        List<Map<String,String>> officeList = commonService.getOfficeList();
//        model.addAttribute("office",officeList);
//        List<Map<String,String>> genderList = commonService.getGenderList();
//        model.addAttribute("gender",genderList);
//        List<Map<String,String>> companyList = commonService.getCompanyList();
//        model.addAttribute("company",companyList);
//        return "register/register";
//    }

    /**
     * 用户注册
     */
    @RequestMapping("/userRegister")
    @ResponseBody
    public String userRegister(HttpServletRequest request, @RequestParam Map<String, String> map){
        String result = loginService.userRegister(request, map);
        return result;
    }

}

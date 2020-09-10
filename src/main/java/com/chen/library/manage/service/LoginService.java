package com.chen.library.manage.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public interface LoginService {
    public String loginCheck(HttpServletRequest request);
    public String userRegister(HttpServletRequest request, Map<String, String> map);

}

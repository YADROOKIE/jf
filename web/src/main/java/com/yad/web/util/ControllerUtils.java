package com.yad.web.util;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public class ControllerUtils {
    public  static  void   setUserSession(HttpServletRequest request , Model model){
        Object user = request.getSession().getAttribute("user");
        if (user!=null){
            model.addAttribute("user",user);
        }
    }
}

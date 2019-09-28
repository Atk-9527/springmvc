package com.springmvc.controller;


import com.springmvc.domain.Account;
import com.springmvc.domain.NewAccount;
import com.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数的绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定的入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了...");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到 JavaBean 的类中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String  saveAccount(NewAccount account){
        System.out.println("封装了");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转化器
     * @return
     */
    @RequestMapping("/saveUser")
    public String testSaveUser(User user) {
        System.out.println("执行了...");
        System.out.println(user);
        return "success";
    }

    /**
     * 获取原生的 Servlet API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }
}

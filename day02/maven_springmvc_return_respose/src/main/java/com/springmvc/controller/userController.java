package com.springmvc.controller;

import com.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class userController {

    /**
     * 返回值是一个字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString 这个方法执行了...");
        // 模拟从数据中查询出一个对象
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(30);
        // model 对象
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回值是 void
     * 请求转发，一次请求，不用编写项目的名称.
     * 重定向，需要编写项目的名称，同时不能访问 WEB-INF 文件下的文件
     * @param
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid 这个方法执行了...");
        // 编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        // 设置中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        // 浏览器直接做相应的写法
        response.getWriter().print("你好");
        return;
    }

    /**
     * 使用 ModelAndView 对象来存储对象和返回页面。返回值为 String 的控制器方法，
     * 其底层实现，也是使用 ModelAndView 对象
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 创建 ModelAndView 的对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView 这个方法执行了...");
        // 模拟从数据中查询出一个对象
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(30);
        // 把 user 对象存储到 mv 对象中， 也会把 user 对象存入到 request 对象
        mv.addObject("user", user);
        // 跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * 使用关键字来进行响应和转发是用不了视图解析器的。所以路径需要自己写正确了。
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect 这个方法执行了...");
        // 请求的转发
        // return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }
}

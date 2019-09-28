package com.springmvc.controller;

import com.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) // 把 msg = "张三" 存入到 session 域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable 注解
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") String id) {
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader 注解, 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHead(@RequestHeader(value = "Accept") String header) {
        System.out.println("执行了");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取 Cookie 的值
     * @param Cookie
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String Cookie) {
        System.out.println("执行了");
        System.out.println(Cookie);
        return "success";
    }

    /**
     * ModelAttribute 注解
     * @return
     */
//    @RequestMapping("/testModelAttribute")
//    public String testModelAttribute(User user) {
//        System.out.println("执行了");
//        System.out.println(user);
//        return "success";
//    }

    /**
     * 该方法会先执行
     */
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser 执行了....");
//        // 通过用户名查询数据库4
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }

    /**
     *
     * @param uname
     * @return
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser 执行了....");
        // 通过用户名查询数据库4
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * SessionAttributes 注解
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("执行了");
        // 底层会帮你存储到 request 域当中
        model.addAttribute("msg", "张三");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("执行了");
        // 底层会帮你存储到 request 域当中
        String msg = (String)modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("执行了");
        // 底层会帮你存储到 request 域当中
        status.setComplete();
        return "success";
    }
}

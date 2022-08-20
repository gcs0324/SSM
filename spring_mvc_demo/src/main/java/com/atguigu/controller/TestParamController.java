package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {

    /**
     * 获取请求参数的方式
     * 1、通过servletAPI获取
     * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
     * 就可以在控制器方法中使用request对象获取请求参数
     *
     * 2、在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在
     * DispatcherServlet中就会将请求参数赋值给相应的形参
     */
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "username",required = true,defaultValue = "123") String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}

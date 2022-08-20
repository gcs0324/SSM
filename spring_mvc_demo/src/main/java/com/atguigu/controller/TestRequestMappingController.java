package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

  /*  @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET
    )*/
    @GetMapping("/hello")
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?c/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        return "success";
    }
}

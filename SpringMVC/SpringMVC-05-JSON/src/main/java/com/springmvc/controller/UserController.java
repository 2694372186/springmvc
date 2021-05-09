package com.springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.pojo.User;
import com.springmvc.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController  //使用RestController注解 这个类下面的方法就不会走视图解析器
//@Controller
public class UserController {


//    @ResponseBody//使用ResponseBody 注解 就不会走视图解析器，会直接返回一个字符串
    @RequestMapping("/t1")
    public String json1() throws JsonProcessingException {
        //创建一个对象
        User user = new User("张三",18,"男");
        return JsonUtils.getJson(user);
    }

    @RequestMapping("/t2")
    public String json2() throws JsonProcessingException {
        //创建一个对象
        User users[]={
                new User("张三", 18, "男"),
                new User("张三", 18, "男"),
                new User("张三", 18, "男"),
                new User("张三", 18, "男")
        };
        return JsonUtils.getJson(users);
    }

    @RequestMapping("/t3")
    public String json3() throws JsonProcessingException {
        return JsonUtils.getJson(new Date(),"yyyy-MM-dd HH:mm:ss");
    }


}

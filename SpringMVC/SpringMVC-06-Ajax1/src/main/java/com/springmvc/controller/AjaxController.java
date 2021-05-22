package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public void test(String name, HttpServletResponse response) throws IOException {
        if(name.equals("admin")){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/t2")
    public List<User> t2(){
        List<User> userList=new ArrayList<>();
        userList.add(new User("张三",18,"女"));
        userList.add(new User("李四",19,"男"));
        userList.add(new User("王五",22,"女"));
        return userList;
    }
    @RequestMapping("/a1")
    public String a1(String name){
        String msg="";
        if(name.equals("admin")){
            msg="ok";
        }else {
            msg="用户名错误";
        }
        return msg;
    }

    @RequestMapping("/a2")
    public String a2(String password){
        String msg="";
        if(password.equals("123456")){
            msg="ok";
        }else {
            msg="密码错误";
        }
        return msg;
    }

}

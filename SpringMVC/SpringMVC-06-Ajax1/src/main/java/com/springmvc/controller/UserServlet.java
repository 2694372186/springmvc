package com.springmvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/a1")
//public class UserServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");
//        String name=request.getParameter("username");
//        String msg="";
//        if(name.equals("admin")){
//            msg="ok";
//        }else {
//            msg="用户名错误";
//        }
//        response.getWriter().print(msg);
//    }
//}

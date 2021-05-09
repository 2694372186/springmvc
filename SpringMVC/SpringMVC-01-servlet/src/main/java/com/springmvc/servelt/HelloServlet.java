package com.springmvc.servelt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String method=request.getParameter("method");
    if(method.equals("add")){
        request.getSession().setAttribute("msg","执行了add方法");
    }
    if(method.equals("delete")){
        request.getSession().setAttribute("msg","执行了delete方法");
    }
        //业务层

        //视图转发或者重定向
        request.getRequestDispatcher("test.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}

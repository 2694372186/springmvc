package com.springmvc.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController01 {

    @RequestMapping ("/m1/t1")
    public String test1(Model model){
        model.addAttribute("msg","HelloController01");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

//    @RequestMapping("/m1")
//    public String test2(Model model){
//        model.addAttribute("msg","HelloController01");
//        return "redirect:index.jsp";
//    }

}

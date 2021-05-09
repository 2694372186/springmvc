package com.springmvc.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping("/t1/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","get:"+res);
        return "test";
    }

    @PostMapping("/t1/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg",res);
        return "test";
    }

}

package com.shop.shop.controller;


import com.shop.shop.ShopApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class AdminController {
    public static void main(String[]args){
        SpringApplication.run(ShopApplication.class, args);
    }
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }
}

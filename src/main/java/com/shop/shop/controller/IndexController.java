package com.shop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    @RequestMapping(value="index3")
    public String index(){

        //return "index";
        return "index";
    }
    @RequestMapping(value="test01")
    public String test(){
        return "test";
    }
}

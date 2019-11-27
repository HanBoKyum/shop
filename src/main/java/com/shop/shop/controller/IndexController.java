package com.shop.shop.controller;

import com.shop.shop.model.MemberVo;
import com.shop.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value="index3")
    public String index(){

        //return "index";
        return "index";
    }
    @RequestMapping(value="test")
    public String test(){
        return "test";
    }
    @RequestMapping(value="test_re")
    public ModelAndView test_re() throws Exception{
        List<MemberVo> list = new ArrayList<MemberVo>();
        list = shopService.getAll();


        return new ModelAndView("test_re", "list", list);
    }

}

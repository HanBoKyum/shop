package com.shop.shop.controller;


import com.shop.shop.model.MemberVo;
//import com.shop.shop.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MemberController {

//    @Autowired
//    DbRepository dbRepository;

    @RequestMapping("go_insert")
    public String go_insert(){


        return "WEB-INF/member/insert_agree";
    }

    @RequestMapping("insert")
    public String insert(){

        return "WEB-INF/member/insert";
    }

//    @RequestMapping("insert_result")
//    public ModelAndView insert_result(){
//        ModelAndView mv = new ModelAndView();
//        List<MemberVo> list = new ArrayList<MemberVo>();
//        list = dbRepository.getList();
//        mv.setViewName("WEB-INF/member/insert_result");
//        return mv;
//    }
}

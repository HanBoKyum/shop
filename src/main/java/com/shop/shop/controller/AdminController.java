package com.shop.shop.controller;


import com.shop.shop.model.NoticeVo;
import com.shop.shop.model.Param;
import com.shop.shop.model.QuestionVo;
import com.shop.shop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping("adminPage.adm")
    public ModelAndView search(Param param){
        ModelAndView mv = new ModelAndView();
        List<NoticeVo> list = noticeService.search(param);
        List<QuestionVo> listt = noticeService.searchh();
        int cnt1 = noticeService.stay();
        int cnt2 = noticeService.refund();
        int cnt3 = noticeService.ask();

        mv.addObject("stay", cnt1);
        mv.addObject("refund", cnt2);
        mv.addObject("ask", cnt3);

        mv.addObject("list",list);
        mv.addObject("listt",listt);
        mv.addObject("para", param);

        mv.setViewName("adminPage"); // .jsp

        return mv;
    }
}

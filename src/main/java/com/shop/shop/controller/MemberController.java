package com.shop.shop.controller;


import com.shop.shop.model.MemberVo;
import com.shop.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

//import com.shop.shop.repository.DbRepository;


@Controller
public class MemberController {

    @Autowired
    ShopService shopService;

    @RequestMapping("go_insert")
    public String go_insert(){


        return "WEB-INF/member/insert_agree";
    }

    @RequestMapping("insert")
    public String insert(){

        return "WEB-INF/member/insert";
    }

    @RequestMapping("insert_result")
    public ModelAndView insert_result(MemberVo vo) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", shopService.insertMember(vo));
        mv.setViewName("WEB-INF/member/insert_result");
        return mv;
        }

    @RequestMapping("go_login")
    public String go_login(){
        return "WEB-INF/member/login";
    }

    //로그인하기
    @RequestMapping("logIn")
    public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        MemberVo result = new MemberVo();
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        MemberVo vo = new MemberVo();
        vo.setMId(req.getParameter("mId"));
        vo.setMPwd(req.getParameter("mPwd"));
        result = shopService.login(vo);
        PrintWriter out = null;
        try {
            req.setCharacterEncoding("utf-8");
            out = resp.getWriter();
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        if(result != null && result.getMName()!=null && !result.getMName().equals("")) {
            session.setAttribute("user_name", result.getMName());
            session.setAttribute("user_id", result.getMId());

            //자동로그인에 관한 쿠키
            if(req.getParameter("keep_info") != null) {
                //유저이름에 관한 쿠키
                Cookie c_user_name = new Cookie("shop_user_name", result.getMName());
                c_user_name.setPath("/");
                c_user_name.setMaxAge(60*60*24*7);
                resp.addCookie(c_user_name);

                //유저아이디에 관한 쿠키
                Cookie c_user_id = new Cookie("shop_user_id", result.getMId());
                c_user_id.setPath("/");
                c_user_id.setMaxAge(60*60*24*7);
                resp.addCookie(c_user_id);
            }

            if(req.getParameter("save_id") != null) {
                //아이디 저장에 관한 쿠키
                String c_id = "idsaver";
                Cookie idsaver = new Cookie(c_id, result.getMId());
                idsaver.setPath("/");
                idsaver.setMaxAge(60*60*24);
                resp.addCookie(idsaver);
            }

            if(req.getParameter("b_page") != null && !req.getParameter("b_page").equals("")) {
                return "redirect:/index.jsp?content=view.shop&pCode="+req.getParameter("b_page");
            }
            return "redirect:/index.jsp";
        }else {
            out.println("<script>alert('아이디와 비밀번호를 확인해주세요'); location.href='index.jsp?content=go_login';</script>" );
            out.flush();
            return null;
        }
    }
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        if (session.getAttribute("user_id") != null && !session.getAttribute("user_id").equals("")) {
            session.setAttribute("user_name", null);
            session.setAttribute("user_id", null);
            for (Cookie c : cookies) {
                String name = c.getName();
                if (name.equals("shop_user_name")) {
                    Cookie user_name = new Cookie("shop_user_name", null);
                    user_name.setPath("/");
                    user_name.setMaxAge(0);
                    resp.addCookie(user_name);
                }
                if (name.equals("shop_user_id")) {
                    Cookie user_id = new Cookie("shop_user_id", null);
                    user_id.setPath("/");
                    user_id.setMaxAge(0);
                    resp.addCookie(user_id);
                }
            }
        }
//        }else {
//            //카카오로 로그인했을 때
//            kakao = new KakaoAPI();
//            kakao.kakaoLogout((String)session.getAttribute("access_Token"));
//            session.removeAttribute("access_Token");
//            session.removeAttribute("user_name");
//        }


            //TODO indext페이지로 이동시키기
            mv.setViewName("redirect:index.jsp");
            return mv;
        }
    }







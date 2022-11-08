package com.project.updev.controller;

import com.project.updev.dto.MemberDTO;
import com.project.updev.entity.MemberEntity;
import com.project.updev.service.MemberService;
import com.project.updev.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;
    UserService userService;

    // 회원가입폼으로 이동
    @GetMapping(value = "/signup")
    public String signupform(Model model)
    {
        System.out.println("1");
        model.addAttribute("MemberDTO", new MemberDTO());
        return "signup";
    }


    // 로그인폼으로 이동
    @GetMapping(value = "/login")
    public String loginform()
    {
        return "login";
    }

    //아이디,비밀번호 찾기 폼으로 이동
    @GetMapping(value = "/findidpw")
    public String find_idpw_form()
    {
        return "find_idpw";
    }

    @GetMapping("/")
    public String ko1()
    {
        return "index";
    }

    @PostMapping("/signup")
    public String member_signup(@ModelAttribute("MemberDTO") MemberDTO memberDTO){
        memberDTO.setM_jdate(LocalDate.now());
        memberDTO.setM_outtime(LocalDate.now());
        MemberEntity entity = memberDTO.toEntity();
        System.out.println(entity+"내가 앤티티");
        userService.input(entity);
            return "redirect:/index";

    }

    //로그인 저장기능
    @PostMapping(value="/loginact")
    public ModelAndView logincheck(HttpServletRequest request , RedirectAttributes rattr)
    {//db에 회원가입한 아이디 비밀번호가 맞는지 확인하는곳(로그인중)
        //정보가 맞지 않다면 로그인창으로 보냄
        HttpSession session = request.getSession();
        //오늘날짜 구하는 식
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatedNow = formatter.format(now);

        ModelAndView mav=new ModelAndView();
        String m_id = request.getParameter("m_id");
        String m_pw = request.getParameter("m_pw");
        MemberDTO signup = memberService.login_checking(m_id, m_pw);
        if(signup==null) {
            //아이디 비밀번호가 일치한 데이터가 없다면
            rattr.addAttribute("check", "nodata");
            mav.setViewName("redirect:login");
        } else {
            String grade = signup.getM_grade();//등급
            String outtime = String.valueOf(signup.getM_outtime());
            String date1 = outtime;//마지막 로그아웃 시간
            String date2 = formatedNow;//현재시간

            int result = date1.compareTo(date2);
	    	  /* 나온 숫자에 따른 결과
		      if(result == 0)
		          System.out.println("동일한 날짜");
		      else if (result < 0)
		          System.out.println("date1은 date2 이전 날짜");
		      else
		          System.out.println("date1은 date2 이후 날짜");
		          */

            if((grade.equals("회원") || grade.equals("관리자")) && result < 0)
            {//로그인한 회원에 관해 세션 정의
                session.setAttribute("member", signup);
                session.setAttribute("m_id", m_id);
                session.setAttribute("m_pw", m_pw);
                session.setAttribute("loginState", true);
                session.setAttribute("member_nick", signup.getM_nick());

                String id = (String)session.getAttribute("m_id");
                int alarm_count = memberService.alarmcount(id);
                session.setAttribute("alarm_count", alarm_count);

                mav.setViewName("redirect:index");

            } else {
                rattr.addAttribute("gradecheck", "badgrade");
                mav.setViewName("redirect:input");
            }
        }

        return mav;
    }

}

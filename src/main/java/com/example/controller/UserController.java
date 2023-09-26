package com.example.controller;

import com.example.domain.UserVo;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */
  @GetMapping
    public String root() {
        return "redirect:/login";
    }
    /**
     * 로그인 폼
     *
     * @return
     */
  @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/signUp")  // 회원가입시 유효성검사 추가해야함
    public String signUpForm() {
        return "signUp";
    }

    /**
     * 로그인 실패 폼
     *
     * @return
     */
  @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

    /**
     * 회원가입 진행
     *
     * @param userVo
     * @return
     */
    @PostMapping("/signUp")
    public String signUp(UserVo userVo) {
        userService.joinUser(userVo);
        return "redirect:/login";
    }

    /**
     * 유저페이지
     * @param model
     * @param authentication
     * @return
     */
   @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        UserVo userVo = (UserVo) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("info", userVo.getUserId() +"의 "+ userVo.getUserName()+ "님");      //유저 아이디
        return "user_access";
    }

    //로그 아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("jwtToken"); // 세션에서 토큰 정보 제거

        return "redirect:/login"; // 로그아웃 후 메인 홈페이지로 이동
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        // 쿠키 무효화
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return ResponseEntity.ok().build();
    }



}

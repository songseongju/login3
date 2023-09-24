package com.example.controller;


import com.example.domain.MemberDTO;
import com.example.domain.Product;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class MemberController2 {
    private final MemberService memberService;

    @GetMapping("/api")
    public List<MemberDTO> memberDTO () {
        return memberService.getUserList();

    }
    @GetMapping("/test")
    public List<Product> test() {
        return memberService.getAllDataList();
    }

}
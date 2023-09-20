package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/api")

    // User -> domain.User(DTO) 양이많으니 List로 변환 하고 xml 불러오기

    public List<User> getUserList () {

        return userService.getUserList();

    }
    @PostMapping("/sign")  //  1. APi 호출 인자값 받아 오기 서비스쪽으로 넘겨준다 -> Service
    public void sign(@RequestParam String id, @RequestParam String pw){

        userService.signUser(id, pw);


    }
}

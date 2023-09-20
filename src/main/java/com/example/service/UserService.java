package com.example.service;


import com.example.domain.User;
import com.example.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
@Autowired
private UserMapper userMapper;
    public List<User> getUserList(){
        return userMapper.getUserList();
    }
   //회원가입  2 . 인자값 받아온걸 클래스로 -> Map감싸주기  -> Mapper
    public void signUser(String id, String pw) {
       Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("pw", pw);

        userMapper.signUser(param);
    }
}

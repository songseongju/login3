package com.example.service;


import com.example.domain.MemberDTO;
import com.example.domain.Product;
import com.example.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public List<MemberDTO> getUserList() {
        return memberMapper.getUserList();
    }


    public List<Product> getAllDataList() {
        return memberMapper.getAllDataList();
    }




    //회원가입  2 . 인자값 받아온걸 클래스로 -> Map감싸주기  -> Mapper
    public void signUser(String id, String pw) {
       Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("pw", pw);

        memberMapper.signUser(param);

    }

}








package com.example.mapper;

import com.example.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    // 로그인
    UserVo getUserAccount(String userId);
    // 회원가입
    void saveUser(UserVo userVo);

    //User Email 찾기

    public List<String> findId(String userName);

    //User Password 찾기
    public List<String> findPw(String userPw);


}

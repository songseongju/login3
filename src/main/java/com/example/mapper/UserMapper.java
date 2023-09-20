package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    List<User> getUserList();

    //3. xml 매핑시켜주기 -> xml매핑 후 가져오기
    void signUser(Map<String, Object> param);

}


package com.example.mapper;
import com.example.domain.MemberDTO;
import com.example.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MemberMapper {

    List<Product> getAllDataList();

    List<MemberDTO> getUserList();


    //3. xml 매핑시켜주기 -> xml매핑 후 가져오기
    void signUser(Map<String, Object> param);


    // 아이디 중복 확인
    MemberDTO useById(String id);
    boolean isIdDuplicated(String id);



    // 회원 가입
    int insert(MemberDTO memberDTO);



}


package com.example.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int memberId ;
    private String memberEmail;
    private String memberPwd;
    private String memberUsername;
    private String memberRegiType;
    private String memberRegiDate;
    private String memberBirth;
    private String memberImage;
    private String memberIntro;

}

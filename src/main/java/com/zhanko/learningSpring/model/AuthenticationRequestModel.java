package com.zhanko.learningSpring.model;

import lombok.Data;

@Data
public class AuthenticationRequestModel {
    private String email;
    private String password;

}

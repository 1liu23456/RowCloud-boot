package com.hekeda.bean;


import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;


}

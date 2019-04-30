package com.hj.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjie
 * @time 2019-04-30 17:40
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 3203386191353385445L;

    private Long id;
    private String username;
    private String password;
    private String salt;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
}

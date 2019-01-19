package com.thrall.dto;

import com.thrall.domain.User;
import com.thrall.domain.Userinfo;

/**
 * Created with IntelliJ IDEA.
 * User: huyida
 * Date: 2018/6/26
 * Time: 14:15
 * Description:
 */
public class LoginInfo {
    Userinfo userinfo;
    String token;
    String message;

    public LoginInfo(Userinfo userinfo, String token, String message) {
        this.userinfo = userinfo;
        this.token = token;
        this.message = message;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.thrall.service.impl;

import com.thrall.domain.User;
import com.thrall.domain.Userinfo;
import com.thrall.mapper.LoginMapper;
import com.thrall.mapper.UserMapper;
import com.thrall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Userinfo login(Userinfo userinfo) {
        return loginMapper.login(userinfo);
    }

    @Override
    public int register(Userinfo userinfo) {
        //对象判空处理
        if ("".equals(userinfo.getUsername()) || "".equals(userinfo.getPassword())) {
            return 0;
        }
        return loginMapper.register(userinfo);
    }

    @Override
    public int resetPassword(Userinfo userinfo) {
        //对象判空处理
        if ("".equals(userinfo.getUsername()) || "".equals(userinfo.getRealname()) || "".equals(userinfo.getPassword())) {
            return 0;
        }
        return loginMapper.resetPassword(userinfo);
    }
}

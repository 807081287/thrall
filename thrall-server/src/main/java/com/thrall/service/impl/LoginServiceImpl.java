package com.thrall.service.impl;

import com.thrall.domain.User;
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
    public User login(User user) {
        User u = loginMapper.login(user);
        if (u == null) {
            return null;
        }
        return u;
    }

    @Override
    public int register(User user) {
        return 0;
    }
}

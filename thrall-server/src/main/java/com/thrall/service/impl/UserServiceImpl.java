package com.thrall.service.impl;

import com.thrall.domain.User;
import com.thrall.mapper.UserMapper;
import com.thrall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: huyd
 * Date: 2018/9/17 20:39
 * Description:
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(String username) {
        //没有此用户直接返回null
        User user = userMapper.findByName(username);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insertUser(user);
    }
}
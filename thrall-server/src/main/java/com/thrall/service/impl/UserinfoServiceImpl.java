package com.thrall.service.impl;

import com.thrall.domain.Userinfo;
import com.thrall.mapper.UserMapper;
import com.thrall.mapper.UserinfoMapper;
import com.thrall.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: thrall-server
 * @description: 用户信息业务逻辑接口类
 * @author: huyida
 * @create: 2019-01-17 23:01
 **/
@Component
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo getByRealname(String realname) {
        return userinfoMapper.getByRealname(realname);
    }

    @Override
    public Userinfo getByUsername(String username) {
        return userinfoMapper.getByUsername(username);
    }

    @Override
    public List<Userinfo> getUserinfo(Userinfo userinfo) {
        return userinfoMapper.getUserinfo(userinfo);
    }

    @Override
    public int saveUserinfo(Userinfo userinfo) {
        return userinfoMapper.saveUserinfo(userinfo);
    }

    @Override
    public int updateUserinfo(Userinfo userinfo) {
        return userinfoMapper.updateUserinfo(userinfo);
    }

    @Override
    public int removeUserinfo(int id) {
        return userinfoMapper.removeUserinfo(id);
    }
}

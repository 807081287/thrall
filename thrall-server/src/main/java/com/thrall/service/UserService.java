package com.thrall.service;

import com.thrall.domain.User;

/**
 * Author: huyd
 * Date: 2018/9/17 20:38
 * Description:
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     * 添加用户
     *
     * @param user
     */
    int saveUser(User user);
}
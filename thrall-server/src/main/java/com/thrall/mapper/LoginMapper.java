package com.thrall.mapper;

import com.thrall.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface LoginMapper {

    /**
     * 登陆功能
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    int register(User user);

}

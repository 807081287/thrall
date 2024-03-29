package com.thrall.mapper;

import com.thrall.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: huyd
 * Date: 2018/9/17 20:42
 * Description:
 */
@Mapper
@Service
public interface UserMapper {
    /**
     * 根据用户名查询信息
     *
     * @param username
     * @return
     */
    User findByName(@Param("username") String username);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAllUser();
}
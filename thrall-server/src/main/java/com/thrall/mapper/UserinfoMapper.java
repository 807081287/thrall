package com.thrall.mapper;

import com.thrall.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: thrall-server
 * @description: 用户信息
 * @author: huyida
 * @create: 2019-01-17 21:40
 **/
@Mapper
@Service
public interface UserinfoMapper {
    /**
     * @Description: 根据真实姓名查询用户信息
     * @Param: [realname]
     * @return: com.thrall.domain.Userinfo
     * @Author: huyida
     * @Date: 2019/01/17
     */
    Userinfo getByRealname(String realname);

    /**
     * @Description: 根据用户名查询用户信息
     * @Param: [username]
     * @return: com.thrall.domain.Userinfo
     * @Author: huyida
     * @Date: 2019/01/17
     */
    Userinfo getByUsername(String username);

    /**
     * @Description: 获取用户信息
     * @Param: [userinfo]
     * @return: com.thrall.domain.Userinfo
     * @Author: huyida
     * @Date: 2019/01/19
     */
    List<Userinfo> getUserinfo(Userinfo userinfo);

    /**
     * @Description: 添加用户
     * @Param: [userinfo]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/17
     */
    int saveUserinfo(Userinfo userinfo);

    /**
     * @Description: 更新用户信息
     * @Param: [userinfo]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/17
     */
    int updateUserinfo(Userinfo userinfo);

    /**
     * @Description: 根据用户名删除用户信息
     * @Param: [id]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/17
     */
    int removeUserinfo(int id);

}

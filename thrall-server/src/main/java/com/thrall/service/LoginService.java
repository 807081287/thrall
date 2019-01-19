package com.thrall.service;

import com.thrall.domain.User;
import com.thrall.domain.Userinfo;

import javax.jws.soap.SOAPBinding;

public interface LoginService {
    /**
     * @Description: 用户登陆
     * @Param: [userinfo]
     * @return: com.thrall.domain.Userinfo
     * @Author: huyida
     * @Date: 2019/01/19
     */
    Userinfo login(Userinfo userinfo);

    /**
     * @Description: 用户注册
     * @Param: [userinfo]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/19
     */
    int register(Userinfo userinfo);

    /**
     * @Description: 忘记密码
     * @Param: [userinfo]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/19
     */
    int resetPassword(Userinfo userinfo);

}

package com.thrall.web;

import com.thrall.core.Result;
import com.thrall.core.ResultGenerator;
import com.thrall.domain.User;
import com.thrall.domain.Userinfo;
import com.thrall.dto.LoginInfo;
import com.thrall.service.LoginService;
import com.thrall.util.JWTUtil;
import com.thrall.util.SHA256Str;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Api(value = "LoginController", description = "登录模块")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        Userinfo userinfo = new Userinfo();
        String encryptedPassword = SHA256Str.getSHA256StrJava(password);//密码进行加密
        userinfo.setUsername(username);
        userinfo.setPassword(encryptedPassword);
        Userinfo u = loginService.login(userinfo);
        //如果存在用户，说明登录成功，
        if (u != null) {
            Userinfo user1 = new Userinfo();
            user1.setUsername(username);
            user1.setPassword(password);
            user1.setRole(u.getRole());
            LoginInfo loginInfo = new LoginInfo(user1, JWTUtil.sign(username, u.getPassword()), "SUCCESS");
            return ResultGenerator.getSuccessResult(loginInfo);
        } else {
            return ResultGenerator.getFailResult("登录失败");
        }
    }

    @ApiOperation(value = "注册用户", notes = "注册用户")
    @PostMapping("/register")
    public Result register(@RequestBody Userinfo userinfo) {
        //注册用户
        int result = loginService.register(userinfo);
        if (result == 0) {
            return ResultGenerator.getFailResult("注册失败");
        }
        return ResultGenerator.getSuccessResult(result);
    }

    @ApiOperation(value = "忘记密码", notes = "忘记密码")
    @PostMapping("/resetPassword")
    public Result resetPassword(@RequestBody Userinfo userinfo) {
        //修改密码
        int result = loginService.resetPassword(userinfo);
        if (result == 0) {
            return ResultGenerator.getFailResult("修改失败");
        }
        return ResultGenerator.getSuccessResult(result);
    }

}

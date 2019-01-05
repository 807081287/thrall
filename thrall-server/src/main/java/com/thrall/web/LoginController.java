package com.thrall.web;

import com.thrall.domain.User;
import com.thrall.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Api(value = "LoginController", description = "登陆模块")
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("login")
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView("pages/examples/login.html");
        return mv;
    }

    @ApiOperation(value = "用户登陆", notes = "根据用户名和密码登陆")
    @PostMapping("loginValid")
    public User login(@RequestBody User user) {
        User u = loginService.login(user);
        if (u == null) {

        }
        return u;
    }

}

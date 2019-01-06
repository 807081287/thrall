package com.thrall.web;

import com.thrall.core.ResultGenerator;
import com.thrall.domain.User;
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

    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @PostMapping("loginValid")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        String encryptedPassword = SHA256Str.getSHA256StrJava(password);
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        User u = loginService.login(user);
        ModelAndView mv = new ModelAndView();
        if (u != null) {
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            user1.setRole(password);
            LoginInfo loginInfo = new LoginInfo(user1, JWTUtil.sign(username, encryptedPassword), "SUCCESS");
            mv.setViewName("redirect:/home");
            mv.addObject(loginInfo);
            return mv;
        } else {
            mv.setViewName("pages/examples/login.html");
            return mv;
        }
    }

}

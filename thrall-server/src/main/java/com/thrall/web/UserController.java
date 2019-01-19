//package com.thrall.web;
//
//import com.thrall.core.Result;
//import com.thrall.core.ResultGenerator;
//import com.thrall.domain.User;
//import com.thrall.domain.Userinfo;
//import com.thrall.dto.LoginInfo;
//import com.thrall.service.UserService;
//import com.thrall.service.UserinfoService;
//import com.thrall.util.JWTUtil;
//import com.thrall.util.SHA256Str;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authz.annotation.Logical;
//import org.apache.shiro.authz.annotation.RequiresAuthentication;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.apache.shiro.authz.annotation.RequiresRoles;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * Author: huyd
// * Date: 2018/9/17 20:56
// * Description:用户管理
// */
//@Api(value = "UserController", description = "用户相关api")
//@Controller
//@RequestMapping("/")
//public class UserController {
//    @Autowired
//    UserinfoService userinfoService;
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
//    @PostMapping("/login")
//    public Result login(@RequestBody Userinfo userinfo) {
//        Userinfo user = userinfoService.getUserinfo(userinfo);
//        Userinfo user1 = new Userinfo();
//        String encryptedPassword = SHA256Str.getSHA256StrJava(password);
//        if (user.getPassword().equals(encryptedPassword)) {
//            user1.setUsername(username);
//            user1.setPassword(password);
//            user1.setRole(password);
//            LoginInfo loginInfo = new LoginInfo(user1, JWTUtil.sign(username, encryptedPassword), "SUCCESS");
//            return ResultGenerator.getSuccessResult(loginInfo);
//        } else {
//            return ResultGenerator.getFailResult("登录失败");
//        }
//    }
//
//    @ApiOperation(value = "添加用户", notes = "添加用户")
//    @PostMapping("/addUser")
//    public Result addUser(@RequestBody User user) {
//        User isUser = userService.getUser(user.getUsername());
//        if (userService.getUser(user.getUsername()) != null) {
//            return ResultGenerator.getFailResult("用户已存在");
//        }
//        user.setPassword(SHA256Str.getSHA256StrJava(user.getPassword()));
//        int id = userService.saveUser(user);
//        return ResultGenerator.getSuccessResult(id);
//    }
//
//    @ApiOperation(value = "所有都可以访问")
//    @GetMapping("/authAll")
//    public Result authAll() {
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.isAuthenticated()) {
//            return ResultGenerator.getSuccessResult("You are already logged in");
//        } else {
//            return ResultGenerator.getSuccessResult("You are guest");
//        }
//    }
//
//    @ApiOperation(value = "被认证可以访问")
//    @GetMapping("/authed")
//    @RequiresAuthentication
//    public Result authed() {
//        return ResultGenerator.getSuccessResult("You are authenticated");
//    }
//
//    @ApiOperation(value = "admin可以访问")
//    @GetMapping("/authAdmin")
//    @RequiresRoles("admin")
//    public Result authAdmin() {
//        return ResultGenerator.getSuccessResult("You are admin!");
//    }
//
//    @ApiOperation(value = "requirePermission可以访问")
//    @GetMapping("/requirePermission")
//    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
//    public Result requirePermission() {
//        return ResultGenerator.getSuccessResult("You are visiting permission require edit,view!");
//    }
//
//    @RequestMapping(value="/test", method=RequestMethod.GET)
//    public ModelAndView testPage() {
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("hi","Hello World !");
//        return mv;
//    }
//
//    @GetMapping("/welcome")
//    ModelAndView welcome(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("welcome");
//        modelAndView.addObject("message","Welcome to Spring Boot & Thymeleaf");
//        return modelAndView;
//    }
//
//}
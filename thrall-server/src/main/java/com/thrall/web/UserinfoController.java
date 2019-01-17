package com.thrall.web;

import com.thrall.core.Result;
import com.thrall.core.ResultGenerator;
import com.thrall.domain.Userinfo;
import com.thrall.service.UserinfoService;
import com.thrall.util.SHA256Str;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @program: thrall-server
 * @description: 用户信息操作
 * @author: huyida
 * @create: 2019-01-17 23:05
 **/
@Api(value = "UserinfoController", description = "用户相关api")
@RestController
@RequestMapping("/")
public class UserinfoController {
    @Autowired
    UserinfoService userinfoService;

    public void setUserinfoService(UserinfoService userinfoService) {
        this.userinfoService = userinfoService;
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody Userinfo userinfo) {
        Userinfo u = userinfoService.getByUsername(userinfo.getUsername());
        if (u != null) {
            return ResultGenerator.getFailResult("用户已存在");
        }
        userinfo.setPassword(SHA256Str.getSHA256StrJava(userinfo.getPassword()));//密码加密
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        userinfo.setCreate_date(timeStamep);
        userinfo.setUpdate_date(timeStamep);
        int id = userinfoService.saveUserinfo(userinfo);//添加用户
        return ResultGenerator.getSuccessResult(id);
    }

}

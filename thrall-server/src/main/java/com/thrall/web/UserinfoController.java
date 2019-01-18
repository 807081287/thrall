package com.thrall.web;

import com.thrall.core.Result;
import com.thrall.core.ResultGenerator;
import com.thrall.domain.Userinfo;
import com.thrall.service.UserinfoService;
import com.thrall.util.SHA256Str;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: thrall-server
 * @description: 用户信息操作
 * @author: huyida
 * @create: 2019-01-17 23:05
 **/
@Api(value = "UserinfoController", description = "用户相关api")
@RestController
@RequestMapping("/admin")
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
        //获取当前时间，创建时间和更新时间
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        userinfo.setCreate_date(timeStamep);
        userinfo.setUpdate_date(timeStamep);
        int id = userinfoService.saveUserinfo(userinfo);//添加用户
        return ResultGenerator.getSuccessResult(id);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @PostMapping("/removeUser")
    public Result removeUser(@RequestParam("id") int id) {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(id);
        //获取用户
        List<Userinfo> u = userinfoService.getUserinfo(userinfo);
        //如果用户数量等于1条，那么存在此id数据
        if (u.size() != 1) {
            return ResultGenerator.getFailResult("用户不存在");
        }
        //删除用户
        int result = userinfoService.removeUserinfo(id);
        return ResultGenerator.getSuccessResult("用户删除成功");
    }

    @ApiOperation(value = "获取用户", notes = "根据查找的属性来获取用户")
    @PostMapping("/getUser")
    public Result getUser(@RequestBody Userinfo userinfo) {
        //根据对象中参数查询数据，如果对象为空，那么查询出所有用户
        List<Userinfo> u = userinfoService.getUserinfo(userinfo);
        return ResultGenerator.getSuccessResult(u);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody Userinfo userinfo) {
        //更新用户
        int result = userinfoService.updateUserinfo(userinfo);
        return ResultGenerator.getSuccessResult("更新成功");
    }


}

package com.thrall.web;

import com.thrall.core.Result;
import com.thrall.core.ResultGenerator;
import com.thrall.domain.Userinfo;
import com.thrall.service.UserinfoService;
import com.thrall.util.SHA256Str;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: thrall-server
 * @description: 学生信息操作
 * @author: huyida
 * @create: 2019-01-19 15:21
 **/
@Api(value = "StudentController", description = "学生信息模块")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    UserinfoService userinfoService;

    public void setUserinfoService(UserinfoService userinfoService) {
        this.userinfoService = userinfoService;
    }

    @ApiOperation(value = "添加学生", notes = "添加学生")
    @PostMapping("/saveTeacher")
    @RequiresRoles("admin")
    public Result saveUser(@RequestBody Userinfo userinfo) {
        Userinfo u = userinfoService.getByUsername(userinfo.getUsername());
        if ("student".equals(u.getRole())) {
            return ResultGenerator.getFailResult("用户已存在");
        }
        userinfo.setPassword(SHA256Str.getSHA256StrJava(userinfo.getPassword()));//密码加密
        userinfo.setRole("student");
        //获取当前时间，创建时间和更新时间
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        userinfo.setCreate_date(timeStamep);
        userinfo.setUpdate_date(timeStamep);
        int id = userinfoService.saveUserinfo(userinfo);//添加学生
        return ResultGenerator.getSuccessResult(id);
    }

    @ApiOperation(value = "删除学生", notes = "删除学生")
    @DeleteMapping("/removeTeacher")
    @RequiresRoles("admin")
    public Result removeUser(@RequestParam("id") int id) {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(id);
        userinfo.setRole("student");//设置角色为学生
        //获取学生
        List<Userinfo> u = userinfoService.getUserinfo(userinfo);
        //如果用户数量等于1条，那么存在此id数据
        if (u.size() != 1) {
            return ResultGenerator.getFailResult("学生不存在");
        }
        //删除用户
        int result = userinfoService.removeUserinfo(id);
        return ResultGenerator.getSuccessResult("删除成功");
    }

    @ApiOperation(value = "获取学生", notes = "根据查找的属性来获取学生")
    @PostMapping("/getTeacher")
    @RequiresRoles("admin")
    public Result getTeacher(@RequestBody Userinfo userinfo) {
        //根据对象中参数查询数据，如果对象为空，那么查询出所有用户
        userinfo.setRole("student");
        List<Userinfo> u = userinfoService.getUserinfo(userinfo);
        return ResultGenerator.getSuccessResult(u);
    }

    @ApiOperation(value = "更新学生", notes = "更新学生")
    @PutMapping("/updateTeacher")
    @RequiresRoles(value = {"student", "admin"}, logical = Logical.OR)
    public Result updateUser(@RequestBody Userinfo userinfo) {
        //更新学生
        userinfo.setRole("student");
        int result = userinfoService.updateUserinfo(userinfo);
        return ResultGenerator.getSuccessResult("更新成功");
    }
}

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
 * @description: 教师信息操作
 * @author: huyida
 * @create: 2019-01-19 14:57
 **/
@Api(value = "TeacherController", description = "教师信息模块")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    UserinfoService userinfoService;

    public void setUserinfoService(UserinfoService userinfoService) {
        this.userinfoService = userinfoService;
    }

    @ApiOperation(value = "添加教师", notes = "添加教师")
    @PostMapping("/saveTeacher")
    @RequiresRoles("admin")
    public Result saveUser(@RequestBody Userinfo userinfo) {
        Userinfo u = userinfoService.getByUsername(userinfo.getUsername());
        if ("teacher".equals(u.getRole())) {
            return ResultGenerator.getFailResult("用户已存在");
        }
        userinfo.setPassword(SHA256Str.getSHA256StrJava(userinfo.getPassword()));//密码加密
        userinfo.setRole("teacher");
        //获取当前时间，创建时间和更新时间
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        userinfo.setCreate_date(timeStamep);
        userinfo.setUpdate_date(timeStamep);
        int id = userinfoService.saveUserinfo(userinfo);//添加教师
        return ResultGenerator.getSuccessResult(id);
    }

    @ApiOperation(value = "删除教师", notes = "删除教师")
    @DeleteMapping("/removeTeacher")
    @RequiresRoles("admin")
    public Result removeUser(@RequestParam("id") int id) {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(id);
        userinfo.setRole("teacher");//设置角色为教师
        //获取教师
        List<Userinfo> u = userinfoService.getUserinfo(userinfo);
        //如果用户数量等于1条，那么存在此id数据
        if (u.size() != 1) {
            return ResultGenerator.getFailResult("教师不存在");
        }
        //删除用户
        int result = userinfoService.removeUserinfo(id);
        return ResultGenerator.getSuccessResult("删除成功");
    }

    @ApiOperation(value = "获取教师", notes = "根据查找的属性来获取教师")
    @PostMapping("/getTeacher")
    @RequiresRoles("admin")
    public Result getTeacher(@RequestBody Userinfo userinfo) {
        //根据对象中参数查询数据，如果对象为空，那么查询出所有用户
        userinfo.setRole("teacher");
        List<Userinfo> u = userinfoService.getUserinfo(userinfo);
        return ResultGenerator.getSuccessResult(u);
    }

    @ApiOperation(value = "更新教师", notes = "更新教师")
    @PutMapping("/updateTeacher")
    @RequiresRoles(value = {"teacher", "admin"}, logical = Logical.OR)
    public Result updateUser(@RequestBody Userinfo userinfo) {
        //更新教师
        userinfo.setRole("teacher");
        int result = userinfoService.updateUserinfo(userinfo);
        return ResultGenerator.getSuccessResult("更新成功");
    }
}

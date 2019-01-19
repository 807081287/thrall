package com.thrall.web;

import com.thrall.core.Result;
import com.thrall.core.ResultGenerator;
import com.thrall.domain.College;
import com.thrall.mapper.CollegeMapper;
import com.thrall.service.CollegeService;
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
 * @description: 学院信息操作
 * @author: huyida
 * @create: 2019-01-19 16:08
 **/
@Api(value = "CollegeController", description = "学院信息模块")
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    public void setCollegeService(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @ApiOperation(value = "添加学院", notes = "添加学院")
    @PostMapping("saveCollege")
    @RequiresRoles("admin")
    public Result saveCollege(@RequestBody College college) {
        College c = collegeService.getByName(college.getName());
        if (c != null) {
            return ResultGenerator.getFailResult("学院已存在");
        }
        //获取当前时间，创建时间和更新时间
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        college.setCreate_date(timeStamep);
        college.setUpdate_date(timeStamep);
        int result = collegeService.saveCollege(college);
        return ResultGenerator.getSuccessResult(result);
    }

    @ApiOperation(value = "删除学院", notes = "删除学院")
    @DeleteMapping("/removeCollege")
    @RequiresRoles("admin")
    public Result removeCollege(@RequestParam("id") int id) {
        College college = new College();
        college.setId(id);
        List<College> c = collegeService.getCollege(college);
        if (c.size() != 1) {
            return ResultGenerator.getFailResult("学院不存在");
        }
        int result = collegeService.removeCollege(id);
        return ResultGenerator.getSuccessResult("删除成功");
    }

    @ApiOperation(value = "获取学院", notes = "根据查找的属性来获取学院")
    @PostMapping("/getCollege")
    @RequiresRoles("admin")
    public Result getUser(@RequestBody College college) {
        //根据对象中参数查询数据，如果对象为空，那么查询出所有用户
        List<College> u = collegeService.getCollege(college);
        return ResultGenerator.getSuccessResult(u);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("/updateCollege")
    @RequiresRoles("admin")
    public Result updateUser(@RequestBody College college) {
        //更新用户
        int result = collegeService.updateCollege(college);
        return ResultGenerator.getSuccessResult("更新成功");
    }

}

package com.thrall.service.impl;

import com.thrall.domain.College;
import com.thrall.mapper.CollegeMapper;
import com.thrall.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: thrall-server
 * @description: 用户信息业务逻辑实现类
 * @author: huyida
 * @create: 2019-01-19 16:03
 **/
@Component
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public College getByName(String name) {
        return collegeMapper.getByName(name);
    }

    @Override
    public College getById(int id) {
        return collegeMapper.getById(id);
    }

    @Override
    public List<College> getCollege(College college) {
        return collegeMapper.getCollege(college);
    }

    @Override
    public int saveCollege(College college) {
        return collegeMapper.saveCollege(college);
    }

    @Override
    public int removeCollege(int id) {
        return collegeMapper.removeCollege(id);
    }

    @Override
    public int updateCollege(College college) {
        return collegeMapper.updateCollege(college);
    }
}

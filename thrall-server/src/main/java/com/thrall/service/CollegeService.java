package com.thrall.service;

import com.thrall.domain.College;

import java.util.List;

/**
 * @program: thrall-server
 * @description: 学院信息业务逻辑
 * @author: huyida
 * @create: 2019-01-19 16:01
 **/

public interface CollegeService {
    /**
     * @Description: 根据名称获取学院信息
     * @Param: [name]
     * @return: com.thrall.mapper.College
     * @Author: huyida
     * @Date: 2019/01/19
     */
    College getByName(String name);

    /**
     * @Description: 根据id获取学院信息
     * @Param: [id]
     * @return: com.thrall.mapper.College
     * @Author: huyida
     * @Date: 2019/01/19
     */
    College getById(int id);

    /**
     * @Description: 获取学院信息
     * @Param: [college]
     * @return: java.util.List<com.thrall.mapper.College>
     * @Author: huyida
     * @Date: 2019/01/19
     */
    List<College> getCollege(College college);

    /**
     * @Description: 添加学院
     * @Param: [college]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/19
     */
    int saveCollege(College college);

    /**
     * @Description: 根据id删除学院
     * @Param: [id]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/19
     */
    int removeCollege(int id);

    /**
     * @Description: 更新学院
     * @Param: [college]
     * @return: int
     * @Author: huyida
     * @Date: 2019/01/19
     */
    int updateCollege(College college);
}

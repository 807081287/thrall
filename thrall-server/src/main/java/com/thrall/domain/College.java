package com.thrall.domain;

import java.sql.Timestamp;

/**
 * @program: thrall-server
 * @description: 学院信息表
 * @author: huyida
 * @create: 2019-01-19 15:31
 **/

public class College {
    private int id; //编号
    private String name;    //学院名称
    private String create_by;   //创建者
    private Timestamp create_date;  //创建时间
    private String update_by;   //更新者
    private Timestamp update_date;  //更新时间

    public College() {
    }

    public College(String name, String create_by, Timestamp create_date, String update_by, Timestamp update_date) {
        this.name = name;
        this.create_by = create_by;
        this.create_date = create_date;
        this.update_by = update_by;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                '}';
    }
}

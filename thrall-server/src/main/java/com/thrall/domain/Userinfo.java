package com.thrall.domain;

import java.sql.Timestamp;

/**
 * @program: thrall-server
 * @description: 用户信息表
 * @author: huyida
 * @create: 2019-01-17 21:18
 **/
public class Userinfo {
    private int id; //编号
    private String username;    //用户名
    private String realname;    //真实姓名
    private String password;    //密码
    private String role;       //角色
    private String permission;  //权限
    private String create_by;   //创建者
    private Timestamp create_date;  //创建时间
    private String update_by;   //更新者
    private Timestamp update_date;  //更新时间

    public Userinfo() {
    }

    public Userinfo(String username, String realname, String password, String role, String permission, String create_by, Timestamp create_date, String update_by, Timestamp update_date) {
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.role = role;
        this.permission = permission;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
        return "Userinfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                ", create_by='" + create_by + '\'' +
                ", create_date=" + create_date +
                ", update_by='" + update_by + '\'' +
                ", update_date=" + update_date +
                '}';
    }
}

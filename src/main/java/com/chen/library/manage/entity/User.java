package com.chen.library.manage.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String oname;
    private String sex;
    private String phone;
    private String emall;
    private String remark;
    private Date createDate;
    private String certificate;

    public User() {
    }

    public User(String userId, String userName, String userPassword, String oname, String sex, String phone, String emall, String remark, Date createDate, String certificate) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.oname = oname;
        this.sex = sex;
        this.phone = phone;
        this.emall = emall;
        this.remark = remark;
        this.createDate = createDate;
        this.certificate = certificate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmall() {
        return emall;
    }

    public void setEmall(String emall) {
        this.emall = emall;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}

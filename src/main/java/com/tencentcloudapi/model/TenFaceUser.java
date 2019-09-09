package com.tencentcloudapi.model;

import java.util.Date;

public class TenFaceUser {
    private int id ;
    private String login_name;
    private String password;
    private String mobile;
    private Boolean gender;
    private Boolean state;
    private Date add_time;

    @Override
    public String toString() {
        return "TenFaceUser{" +
                "id=" + id +
                ", login_name='" + login_name + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", state=" + state +
                ", add_time=" + add_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}

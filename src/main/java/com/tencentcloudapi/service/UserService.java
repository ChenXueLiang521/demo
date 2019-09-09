package com.tencentcloudapi.service;

import com.tencentcloudapi.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserInfo();
    public void insert(User user);
    public int delUserById(Integer id);
}

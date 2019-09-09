package com.tencentcloudapi.service.Impl;

import com.tencentcloudapi.dao.UserMapper;
import com.tencentcloudapi.model.User;
import com.tencentcloudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public void insert(User user) {
        userMapper.addUserInfo(user);
    }

    @Override
    public int delUserById(Integer id) {
        int i = userMapper.delUserInfo(id);
        return i;
    }
}

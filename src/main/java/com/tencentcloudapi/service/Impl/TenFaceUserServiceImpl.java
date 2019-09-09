package com.tencentcloudapi.service.Impl;

import com.tencentcloudapi.dao.TenFaceUserMapper;
import com.tencentcloudapi.model.TenFaceUser;
import com.tencentcloudapi.service.TenFaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TenFaceUserServiceImpl implements TenFaceUserService {

    @Autowired
    TenFaceUserMapper tenFaceUserMapper;
    @Override
    public TenFaceUser selectByUserName(String userName) {
        return tenFaceUserMapper.selectByUserName(userName);
    }

    @Override
    public void insertUserInfo(Map hashMap) {
        tenFaceUserMapper.insertUserInfo(hashMap);
    }
}

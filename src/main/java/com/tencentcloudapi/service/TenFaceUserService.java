package com.tencentcloudapi.service;

import com.tencentcloudapi.model.TenFaceUser;

import java.util.Map;

public interface TenFaceUserService {
    /**
     * 根据用户名称查询用户
     * @param userName
     * @return
     */
    TenFaceUser selectByUserName(String userName);

    /**
     * 注册用户信息
     * @param hashMap
     */
    void insertUserInfo(Map hashMap);
}

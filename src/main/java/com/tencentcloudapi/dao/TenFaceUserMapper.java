package com.tencentcloudapi.dao;

import com.tencentcloudapi.model.TenFaceUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TenFaceUserMapper {

    TenFaceUser selectByUserName(String userName);

    void insertUserInfo(Map hashMap);
}

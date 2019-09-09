package com.tencentcloudapi.dao;

import com.tencentcloudapi.model.TenFacePerson;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenFacePersonMapper {
    void insertPerson(TenFacePerson tenFacePerson);
}

package com.tencentcloudapi.service.Impl;

import com.tencentcloudapi.dao.TenFacePersonMapper;
import com.tencentcloudapi.model.TenFacePerson;
import com.tencentcloudapi.service.TenFacePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auth chenxueliang
 * @Date 2019/7/12 12:41
 * @Dec TODO
 **/
@Service
public class TenFacePersonServiceImpl implements TenFacePersonService {

    @Autowired
    TenFacePersonMapper tenFacePersonMapper;

    @Override
    public void insertPersonInfo(TenFacePerson tenFacePerson) {
        tenFacePersonMapper.insertPerson(tenFacePerson);
    }
}

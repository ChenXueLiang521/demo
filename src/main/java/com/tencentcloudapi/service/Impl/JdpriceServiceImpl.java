package com.tencentcloudapi.service.Impl;

import com.tencentcloudapi.dao.JdpriceMapper;
import com.tencentcloudapi.model.Jdprice;
import com.tencentcloudapi.service.JdpriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdpriceServiceImpl implements JdpriceService {
    @Autowired
    JdpriceMapper jdpriceMapper;

    @Override
    public List<Jdprice> queryprice() {
        return jdpriceMapper.querypriceList();
    }
}

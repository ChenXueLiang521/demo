package com.tencentcloudapi.dao;

import com.tencentcloudapi.model.Jdprice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JdpriceMapper {
    List<Jdprice> querypriceList();
}

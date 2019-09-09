package com.tencentcloudapi.controller;


import com.tencentcloudapi.Util.EnumCmpResult;
import com.tencentcloudapi.Util.TenResult;
import com.tencentcloudapi.model.TenFaceUser;
import com.tencentcloudapi.service.TenFaceUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TencentLoginController {

    @Autowired
    TenFaceUserService tenFaceUserService;

    @PostMapping ("/userLogin")
    public Object userLogin(String userName,String password,HttpServletRequest request){
        TenFaceUser tenFaceUser = tenFaceUserService.selectByUserName(userName);
        if (tenFaceUser==null){
            return new TenResult(EnumCmpResult.FAILED,"用户名不存在");
        }
        if(!tenFaceUser.getPassword().equals(password)){
            return new TenResult(EnumCmpResult.FAILED,"用户名或密码不正确");
        }
        return new TenResult(EnumCmpResult.SUCCESS,null);
    }
    @PostMapping("/userRegist")
    public Object userRegist(String userName,String password,String mobile,String sex){
        TenFaceUser tenFaceUser = tenFaceUserService.selectByUserName(userName);
        if(tenFaceUser!=null){
            return new TenResult(EnumCmpResult.FAILED,null);
        }
        Map hashMap = new HashMap();
        hashMap.put("userName",userName);
        hashMap.put("password",password);
        hashMap.put("mobile",mobile);
        hashMap.put("gender",Integer.valueOf(sex));
        hashMap.put("addTimes",new Date());
        tenFaceUserService.insertUserInfo(hashMap);
        return new TenResult(EnumCmpResult.SUCCESS,null);
    }
}

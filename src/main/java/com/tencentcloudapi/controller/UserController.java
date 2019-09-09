package com.tencentcloudapi.controller;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.Util.EnumCmpResult;
import com.tencentcloudapi.Util.TenResult;
import com.tencentcloudapi.model.User;
import com.tencentcloudapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public Object getUserInfo() {
        List<User> user = userService.getUserInfo();
        if (user.size()==0){
            return new TenResult(-1,"稍后再试",null);
        }
        logger.info(JSON.toJSONString(user));
        return new TenResult(EnumCmpResult.SUCCESS,user);
    }

    @RequestMapping("/addUserInfo")
    public Object addUserInfo(String name) {
        User user = new User();
        user.setName(name);
        user.setCtime(new Date());
        userService.insert(user);
        return new TenResult(EnumCmpResult.SUCCESS,null);
    }
    @RequestMapping("/delUser")
    public Object delUser(int id){
        int i = userService.delUserById(id);
        return new TenResult(EnumCmpResult.SUCCESS,i);
    }
}
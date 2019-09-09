package com.tencentcloudapi.controller;

import com.tencentcloudapi.redis.RedisMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/test")
public class TestRedisController {
    @Autowired
    RedisMq redisMq;

    @GetMapping("/push")
    public Object pushMsg(@RequestParam("msg")String msg){
        redisMq.pus(msg);
        return "success";
    }
    @GetMapping("/pop")
    public Object popMsg(){
        return redisMq.pop();
    }
}

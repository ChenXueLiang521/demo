package com.tencentcloudapi.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;
@Component
public class RedisMq {
    private static  String key = "redis-test";
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    private StringRedisTemplate redisTemplate;

    @PostConstruct
    public void postInit(){
        redisTemplate = new StringRedisTemplate(redisConnectionFactory);
    }

    /**
     * 发送消息
     * @param message
     */
    public void pus(String message){
        redisTemplate.opsForList().leftPush(key,message);
    }

    /**
     * 消费消息
     * @return
     */
    public String pop(){
        return redisTemplate.opsForList().rightPop(key,60, TimeUnit.SECONDS);
    }

}

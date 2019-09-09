package com.tencentcloudapi.controller;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.model.Jdprice;
import com.tencentcloudapi.redis.RedisMq;
import com.tencentcloudapi.service.JdpriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    RedisMq redisMq;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    JdpriceService jdpriceService;

    @GetMapping("/query")
    public void queryPrice(){
        List<Jdprice> jdpricesList = jdpriceService.queryprice();
        if (jdpricesList.size()<=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Jdprice jdprice : jdpricesList) {
            redisMq.pus(JSON.toJSONString(jdprice).toString());
            logger.info(JSON.toJSONString(jdpricesList));
        }

    }
    @GetMapping("/querycatch")
    public void queryCatch(){
        threadPoolTaskExecutor.execute(()->{
            //Jedis jedis = new Jedis("127.0.0.1",6379,10000);
            Jedis jedis = new Jedis("118.24.204.154",6379,10000);
            Long llen = jedis.llen("redis-test");
            System.out.println(llen);
            if (llen>0){
                for (int i = 0;i<llen;i++){
                    String pop = redisMq.pop();
                    logger.info(pop);
                }
            }
        });
    }
}

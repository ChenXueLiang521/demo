package com.tencentcloudapi.async;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/*@Component*/
public class AsyncTask {
    //@Async("myTaskAsyncPool")  //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    /*@Async
    public void doTask1(int i) throws InterruptedException{
        System.out.println("Task"+i+" started.");
    }*/
}
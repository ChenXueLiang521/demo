package com.tencentcloudapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class TestAsyncTask {
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
   /* @Autowired
    private AsyncTask asyncTask;*/
    @RequestMapping("/testAsync")
    public void AsyncTaskTest() throws InterruptedException {

        threadPoolTaskExecutor.execute(()->{
            try {
                task();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
    public void task() throws InterruptedException {
        for (int i = 0;i<200 ;i++){
            Thread.sleep(300);
            System.out.println("线程"+i);
        }
    }

}

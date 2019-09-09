package com.tencentcloudapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
@SpringBootApplication
@EnableAsync
/*@EnableConfigurationProperties({TaskThreadPoolConfig.class} ) // 开启配置属性支持*/
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}

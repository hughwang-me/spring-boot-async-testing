package com.uwjx.springbootasynctesting;

import com.uwjx.springbootasynctesting.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

@SpringBootApplication
@EnableAsync
public class SpringBootAsyncTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAsyncTestingApplication.class, args);
    }

}

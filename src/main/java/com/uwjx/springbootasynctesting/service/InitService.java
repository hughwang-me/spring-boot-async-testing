package com.uwjx.springbootasynctesting.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.Future;

@Slf4j
//@Service
public class InitService {

    @Resource
    private TaskService taskService;

    @PostConstruct
    public void init() throws Exception{
        log.warn("开始程序");
        Future<String> task1Result =  taskService.taskOne();
        Future<String> task2Result =   taskService.taskTwo();
        Future<String> task3Result =  taskService.taskThree();
        while (true){
            log.warn("任务1执行结果：{}" , task1Result.isDone());
            log.warn("任务2执行结果：{}" , task1Result.isDone());
            log.warn("任务3执行结果：{}" , task1Result.isDone());
            if(task1Result.isDone() && task2Result.isDone() && task3Result.isDone()){
                log.warn("所有执行完毕");
                break;
            }else {
                Thread.sleep(1000);
            }
        }
    }
}

package com.uwjx.springbootasynctesting.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;

@Slf4j
@Service
public class MulitInitService {

    @Resource
    private MulitTaskService mulitTaskService;

    @PostConstruct
    public void init() throws Exception{
        log.warn("开始程序");
        List<Future<String>> futures = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            log.info("开始调用任务：{}" , i);
            Future<String> task1Result =  mulitTaskService.taskOne(i);
            futures.add(task1Result);
        }
        while (true){
            boolean allDone = true;
            for (Future<String> future : futures) {
                if(!future.isDone()){
                    allDone = false;
                }
            }
            if(allDone){
                log.warn("全部执行完成 OK");
                break;
            }else {
                Thread.sleep(1000);
            }
        }
    }
}

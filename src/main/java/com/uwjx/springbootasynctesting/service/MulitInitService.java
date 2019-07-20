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
        for (int i = 0; i < 20; i++) {
            log.info("开始调用任务：{}" , i);
              mulitTaskService.task(i);
        }

//        while (true){
//            boolean allDone = true;
//            int taskSuccessSize = 0;
//            int taskCancelSize = 0;
//            for (Future<String> future : futures) {
//                if(!future.isDone()){
//                    allDone = false;
//                }else {
//                    taskSuccessSize++;
//                }
//                if(future.isCancelled()){
//                    taskCancelSize++;
//                }
//            }
//            log.warn("成功执行个数  : {}" , taskSuccessSize);
//            log.warn("关闭个数  : {}" , taskCancelSize);
//            if(allDone){
//                log.warn("全部执行完成 OK  : {}" , taskSuccessSize);
//                break;
//            }else {
//                Thread.sleep(3000);
//            }
//        }
    }
}

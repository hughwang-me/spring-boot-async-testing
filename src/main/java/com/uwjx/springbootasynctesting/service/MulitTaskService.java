package com.uwjx.springbootasynctesting.service;

import com.uwjx.commons.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@Slf4j
public class MulitTaskService {

    @Async("taskExecutor")
    public Future<String> taskOne(int index) throws Exception{
        log.error("任务 {} | 所在线程： {} 开始时间:{}"  , index ,Thread.currentThread() , DateUtil.current());
        Thread.sleep(5000);
        log.warn("任务 {} | 所在线程： {} 结束时间:{}"  , index , Thread.currentThread() , DateUtil.current());
        return new AsyncResult<>("任务执行完毕");
    }
}

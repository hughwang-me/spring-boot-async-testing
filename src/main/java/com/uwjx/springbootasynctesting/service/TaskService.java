package com.uwjx.springbootasynctesting.service;

import com.uwjx.commons.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@Slf4j
public class TaskService {

    @Async
    public Future<String> taskOne() throws Exception{
        log.warn("任务 1 开始时间:{}" , DateUtil.current());
        Thread.sleep(5000);
        log.warn("任务 1 结束时间:{}" , DateUtil.current());
        return new AsyncResult<>("任务1执行完毕");
    }

    @Async
    public Future<String> taskTwo() throws Exception{
        log.warn("任务 2 开始时间:{}" , DateUtil.current());
        Thread.sleep(5000);
        log.warn("任务 2 结束时间:{}" , DateUtil.current());
        return new AsyncResult<>("任务2执行完毕");
    }

    @Async
    public Future<String> taskThree() throws Exception{
        log.warn("任务 3 开始时间:{}" , DateUtil.current());
        Thread.sleep(5000);
        log.warn("任务 3 结束时间:{}" , DateUtil.current());
        return new AsyncResult<>("任务3执行完毕");
    }
}

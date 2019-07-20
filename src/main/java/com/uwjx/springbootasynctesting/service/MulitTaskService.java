package com.uwjx.springbootasynctesting.service;

import com.uwjx.commons.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@Service
@Slf4j
public class MulitTaskService {
    @Resource
    private PointService pointService;

    public void task(int index) throws Exception{
        pointService.taskOne(index);
    }


}

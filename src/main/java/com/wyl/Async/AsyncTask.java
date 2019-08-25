package com.wyl.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-12 17:03
 */
@Component
@Async
public class AsyncTask {
    public Future<String> taskFuture() throws InterruptedException{
        System.out.println("马上完了");
        Thread.currentThread().sleep(20000L);
        return new AsyncResult<> ("完了");
    }
}

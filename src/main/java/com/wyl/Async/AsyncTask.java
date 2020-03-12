package com.wyl.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author Wyl
 * @Description
 * @create 2019-08-12 17:03
 */
@Component
public class AsyncTask {
    @Async
    public Future<String> taskFuture() throws InterruptedException{
        System.out.println("3");
        Thread.sleep(10000L);
        return new AsyncResult<> ("4");
    }
}

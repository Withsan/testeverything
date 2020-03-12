package com.wyl.rocketMQ.listener;

import com.wyl.rocketMQ.producerfatory.ProducerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Wyl
 * @Description
 * 程序启动 初始化producer
 * @create 2019-08-15 16:57
 */
@WebListener
public class SyncProducerListener implements ServletContextListener {
    /**
     * * Notification that the web application initialization process is starting.
     * All ServletContextListeners are notified of context initialization before
     * any filter or servlet in the web application is initialized.
     *
     * @param sce Information about the ServletContext that was initialized
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ProducerFactory producerFactory;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        try {
//            syncProducer.getProducer().start();
//            logger.info("rocketMq连接成功");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    /**
     * * Notification that the servlet context is about to be shut down. All
     * servlets and filters have been destroy()ed before any
     * ServletContextListeners are notified of context destruction.
     *
     * @param sce Information about the ServletContext that was destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            producerFactory.getProducer().shutdown();
            logger.info("rocket释放连接");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.fly.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
public class TheadPoolConfig implements AsyncConfigurer {

    @Value("${POOL_SIZE}")
    private int poolSize;
    @Value("${MAX_POOL_SIZE}")
    private int maxPoolSize;
    @Value("${QUEUE_CAPACITY}")
    private int queueCapacity;
    @Value("${KEEP_ALIVE_SECONDS}")
    private int keepAliveSeconds;

    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        //设置核心线程数
        threadPool.setCorePoolSize(poolSize);
        //设置最大线程数
        threadPool.setMaxPoolSize(maxPoolSize);
        //线程池所使用的缓冲队列
        threadPool.setQueueCapacity(queueCapacity);
        //等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPool.setAwaitTerminationSeconds(60);
        //  线程名称前缀
        threadPool.setThreadNamePrefix("com.fly-async-");
        // 初始化线程
        threadPool.initialize();
        return threadPool;
    }

}

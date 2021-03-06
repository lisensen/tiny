package com.tiny.common.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public enum ThreadPool {

    instance;

    /** 线程池维护线程的最少数量 */
    private int minPoolSize = 10;

    /** 线程池维护线程的最大数量 */
    private int maxPoolSize = 500;

    /** 线程池维护线程所允许的空闲时间 */
    private int idleSeconds = 1800;

    /** 线程池所使用的缓冲队列 */
    private int queueBlockSize = 100;

    private ThreadPoolExecutor executor;

    private ThreadPool() {
        this.executor = new ThreadPoolExecutor(minPoolSize, maxPoolSize, idleSeconds,
                TimeUnit.SECONDS, /* 时间单位,秒 */
                new ArrayBlockingQueue<Runnable>(queueBlockSize),
                new ThreadPoolExecutor.CallerRunsPolicy()); /* 重试添加当前加入失败的任务 */
    }

}

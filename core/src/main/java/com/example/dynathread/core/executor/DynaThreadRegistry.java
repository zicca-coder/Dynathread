package com.example.dynathread.core.executor;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 动态线程池管理器，用于统一管理线程池实例
 */
public class DynaThreadRegistry {

    private static final Map<String, ThreadPoolExecutorHolder> HOLDER_MAP = new ConcurrentHashMap<>();

    /**
     * 注册线程池实例到管理器
     *
     * @param threadPoolId 线程池唯一标识
     * @param executor 线程池执行器实例
     * @param properties 线程池参数配置
     */
    public static void putHolder(String threadPoolId, ThreadPoolExecutor executor, ThreadPoolExecutorProperties properties) {
        ThreadPoolExecutorHolder holder = new ThreadPoolExecutorHolder(threadPoolId, executor, properties);
        HOLDER_MAP.put(threadPoolId, holder);
    }

    /**
     * 根据线程池 ID 获取对应的线程池包装对象
     *
     * @param threadPoolId 线程池唯一标识
     * @return 线程池持有者对象
     */
    public static ThreadPoolExecutorHolder getHolder(String threadPoolId) {
        return HOLDER_MAP.get(threadPoolId);
    }

    /**
     * 获取所有线程池集合
     *
     * @return 线程池集合
     */
    public static Collection<ThreadPoolExecutorHolder> gerAllHolders() {
        return HOLDER_MAP.values();
    }



}

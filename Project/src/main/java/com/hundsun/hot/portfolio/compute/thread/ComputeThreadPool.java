package com.hundsun.hot.portfolio.compute.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * @ClassName ComputeThreadPool
 * @Description 线程池类，简单封装java提供的ThreadPoolExecutor类主要方法，用于管理线程计算
 * @author yahengqin
 * @email qinyh14007@hundsun.com
 * @date 2016年7月22日 下午1:55:02
 */
@Component
public class ComputeThreadPool {
	
	private static ThreadPoolExecutor computeThreadPool ;
	
	private static LinkedBlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<>();
	
	private static final Integer CORE_POOL_SIZE = 10;

	private static final Integer MAX_POOL_SIZE = 20;
	
	private static final Integer ALIVE_TIME_MINUTES = 10;
	
	public ComputeThreadPool() {
		computeThreadPool =  new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, ALIVE_TIME_MINUTES, TimeUnit.MINUTES,blockQueue);
		computeThreadPool.prestartAllCoreThreads();
	}
	
	public static void execute(Runnable command){
		computeThreadPool.execute(command);
	}
	
	public static  Future<?>  submit(Runnable command){
		return computeThreadPool.submit(command);
	}
	
	public static  <T> Future<T>  submit(Callable<T> task){
		return computeThreadPool.submit(task);
	}

}

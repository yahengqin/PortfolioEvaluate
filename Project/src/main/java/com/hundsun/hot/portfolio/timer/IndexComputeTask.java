package com.hundsun.hot.portfolio.timer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.hundsun.hot.portfolio.compute.thread.ComputeStockIndexThread;
import com.hundsun.hot.portfolio.compute.thread.ComputeThreadPool;
import com.hundsun.hot.portfolio.service.interfaces.BaseEarningsService;

@Component
public final class IndexComputeTask {
	
	private static Logger logger=LoggerFactory.getLogger(IndexComputeTask.class);
	
	@Autowired
	private BaseEarningsService baseEarningsService;
	
	//每天晚上10点钟执行基础数据的重新计算
	@Scheduled(cron = "0 0 22 * * ?")
	private void baseIndexCompute(){
		List<String> stockList = baseEarningsService.getStockCodeList();
		logger.info("Start compute, the stock list length is "+stockList.size());
		for(String stockCode: stockList){
			Runnable computeThread = new ComputeStockIndexThread(stockCode);
			ComputeThreadPool.execute(computeThread);
		}
	}

}

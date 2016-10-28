package com.hundsun.hot.portfolio.compute.thread;

import java.util.List;
import com.hundsun.hot.portfolio.compute.interfaces.DrawDownCompute;
import com.hundsun.hot.portfolio.compute.interfaces.FluctuationCompute;
import com.hundsun.hot.portfolio.compute.interfaces.SharpCompute;
import com.hundsun.hot.portfolio.compute.interfaces.SumEarningsCompute;
import com.hundsun.hot.portfolio.compute.interfaces.VarCompute;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.model.FluctuationRatio;
import com.hundsun.hot.portfolio.model.MaxDrawDown;
import com.hundsun.hot.portfolio.model.SharpRatio;
import com.hundsun.hot.portfolio.model.SumEarnings;
import com.hundsun.hot.portfolio.model.VarRatio;
import com.hundsun.hot.portfolio.service.interfaces.BaseEarningsService;
import com.hundsun.hot.portfolio.service.interfaces.FluctuationRatioService;
import com.hundsun.hot.portfolio.service.interfaces.MaxDrawDownService;
import com.hundsun.hot.portfolio.service.interfaces.SharpRatioService;
import com.hundsun.hot.portfolio.service.interfaces.SumEarningsService;
import com.hundsun.hot.portfolio.service.interfaces.VarRatioService;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.DateTools;
import com.hundsun.hot.portfolio.tools.SpringBeanWare;
/**
 * @ClassName ComputeStockIndexThread
 * @Description 更新股票今日的各维度基础数据
 * @author yahengqin
 * @email qinyh14007@hundsun.com
 * @date 2016年10月28日 下午2:41:39
 */
public class ComputeStockIndexThread implements Runnable {

	// 基础服务service
	private static final BaseEarningsService baseEarnSrv = SpringBeanWare.getBean(BaseEarningsService.class);
	private static final FluctuationRatioService fluSrv = SpringBeanWare.getBean(FluctuationRatioService.class);
	private static final MaxDrawDownService drawDownSrv = SpringBeanWare.getBean(MaxDrawDownService.class);
	private static final SharpRatioService sharpSrv = SpringBeanWare.getBean(SharpRatioService.class);
	private static final SumEarningsService sumEarnSrv = SpringBeanWare.getBean(SumEarningsService.class);
	private static final VarRatioService varRatioSrv = SpringBeanWare.getBean(VarRatioService.class);
	// 基础计算接口
	private static final FluctuationCompute fluCompute = SpringBeanWare.getBean(FluctuationCompute.class);
	private static final DrawDownCompute drawDownCompute = SpringBeanWare.getBean(DrawDownCompute.class);
	private static final SharpCompute sharpCompute = SpringBeanWare.getBean(SharpCompute.class);
	private static final SumEarningsCompute sumEarnCompute = SpringBeanWare.getBean(SumEarningsCompute.class);
	private static final VarCompute varCompute = SpringBeanWare.getBean(VarCompute.class);

	private String stockCode;
	
	private List<BaseEarnings> baseEarnings20;
	private List<BaseEarnings> baseEarnings120;
	private List<BaseEarnings> baseEarnings250;
	private List<BaseEarnings> baseEarnings500;
	

	public ComputeStockIndexThread(String stockCode) {
		if (stockCode != null && stockCode.trim() != "") {
			this.stockCode = stockCode;
			baseEarnings20 = baseEarnSrv.getBaseEarningsPrevious(stockCode, DateTools.getToday(),CommonData.DAY_20);
			baseEarnings120 = baseEarnSrv.getBaseEarningsPrevious(stockCode, DateTools.getToday(),CommonData.DAY_120);
			baseEarnings250 = baseEarnSrv.getBaseEarningsPrevious(stockCode, DateTools.getToday(),CommonData.DAY_250);
			baseEarnings500 = baseEarnSrv.getBaseEarningsPrevious(stockCode, DateTools.getToday(),CommonData.DAY_500);
		}
	}

	@Override
	public void run() {
		this.doCompute();
	}

	private void doCompute() {
		//这里其实可以继续优化为多线程
		computeFlu();
		computeDrawDown();
		computeSharp();
		computeSumEarn();
		computeVar();
	}
	
	private void computeFlu(){
		FluctuationRatio fluctuationRatio = new FluctuationRatio();
		fluctuationRatio.setStockCode(stockCode);
		double flu20 = fluCompute.computeSingle(baseEarnings20);
		fluctuationRatio.setFluctuationRatio20(flu20);
		double flu120 = fluCompute.computeSingle(baseEarnings120);
		fluctuationRatio.setFluctuationRatio120(flu120);
		double flu250 = fluCompute.computeSingle(baseEarnings250);
		fluctuationRatio.setFluctuationRatio250(flu250);
		double flu500 = fluCompute.computeSingle(baseEarnings500);
		fluctuationRatio.setFluctuationRatio500(flu500);
		fluSrv.insert(fluctuationRatio);
	}

	private void computeDrawDown(){
		MaxDrawDown maxDrawDown = new MaxDrawDown();
		maxDrawDown.setStockCode(stockCode);
		double draw20 = drawDownCompute.computeSingle(baseEarnings20);
		maxDrawDown.setMaxDrawDown20(draw20);
		double draw120 = drawDownCompute.computeSingle(baseEarnings120);
		maxDrawDown.setMaxDrawDown120(draw120);
		double draw250 = drawDownCompute.computeSingle(baseEarnings250);
		maxDrawDown.setMaxDrawDown250(draw250);
		double draw500 = drawDownCompute.computeSingle(baseEarnings500);
		maxDrawDown.setMaxDrawDown500(draw500);
		drawDownSrv.insert(maxDrawDown);
	}
	
	private void computeSharp(){
		SharpRatio sharpRatio = new SharpRatio();
		sharpRatio.setStockCode(stockCode);
		double sharp20 = sharpCompute.computeSingle(baseEarnings20);
		sharpRatio.setSharpRatio20(sharp20);
		double sharp120 = sharpCompute.computeSingle(baseEarnings120);
		sharpRatio.setSharpRatio120(sharp120);
		double sharp250 = sharpCompute.computeSingle(baseEarnings250);
		sharpRatio.setSharpRatio250(sharp250);
		double sharp500 = sharpCompute.computeSingle(baseEarnings500);
		sharpRatio.setSharpRatio500(sharp500);
		sharpSrv.insert(sharpRatio);
	}
	
	private void computeSumEarn(){
		SumEarnings sumEarnings = new SumEarnings();
		sumEarnings.setStockCode(stockCode);
		double sum20 = sumEarnCompute.computeSingle(baseEarnings20);
		sumEarnings.setSumEarnings20(sum20);
		double sum120 = sumEarnCompute.computeSingle(baseEarnings120);
		sumEarnings.setSumEarnings120(sum120);
		double sum250 = sumEarnCompute.computeSingle(baseEarnings250);
		sumEarnings.setSumEarnings250(sum250);
		double sum500 = sumEarnCompute.computeSingle(baseEarnings500);
		sumEarnings.setSumEarnings500(sum500);
		sumEarnSrv.insert(sumEarnings);
	}
	
	private void computeVar(){
		VarRatio varRatio = new VarRatio();
		varRatio.setStockCode(stockCode);
		double var250 = varCompute.computeSingle(baseEarnings250);
		varRatio.setVarRatio250(var250);
		varRatioSrv.insert(varRatio);
	}
}

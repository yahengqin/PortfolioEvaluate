package com.hundsun.hot.portfolio.compute.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hundsun.hot.portfolio.compute.interfaces.VarCompute;
import com.hundsun.hot.portfolio.matlab.VaRMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

@Component
public class VarComputeImpl implements VarCompute {
	
	private static VaRMatlab vaRMatlab;

	private static Logger logger = LoggerFactory.getLogger(VarComputeImpl.class);

	static {
		try {
			vaRMatlab = new VaRMatlab();
		} catch (MWException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double computeSingle(List<BaseEarnings> dataList) {
		double result = 0;
		if (dataList != null && !dataList.isEmpty()) {
			double[][] dataForCompute = new double[1][];
			dataForCompute[CommonData.INDEX_0] =  DataTools.dealBaseEarnings(dataList);
			double[] tempResult = this.compute(dataForCompute);
			if(tempResult != null){
				result = tempResult[CommonData.INDEX_0];
			}else{
				logger.error("compute stock "+dataList.get(0).getStockCode()+" var error");
			}
		}
		return result;
	}

	@Override
	public double[] compute(double[][] baseData) {
		double[] result = null;
		if(baseData !=null){
			MWNumericArray dataForMatLab = DataTools.initData(baseData);
			try {
				Object[] sourceResult = vaRMatlab.pVaR(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
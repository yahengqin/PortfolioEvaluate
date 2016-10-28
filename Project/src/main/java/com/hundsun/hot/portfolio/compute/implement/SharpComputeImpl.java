package com.hundsun.hot.portfolio.compute.implement;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hundsun.hot.portfolio.compute.interfaces.SharpCompute;
import com.hundsun.hot.portfolio.matlab.SharpeMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
@Component
public class SharpComputeImpl implements SharpCompute {
	
	private static SharpeMatlab sharpeMatlab ;
	
	static{
		try {
			sharpeMatlab= new SharpeMatlab();
		} catch (MWException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double computeSingle(List<BaseEarnings> dataList) {
		double result = 0;
		if (dataList != null && !dataList.isEmpty()) {
			double[][] dataForCompute = new double[1][];
			dataForCompute[CommonData.INDEX_0] = DataTools.dealBaseEarnings(dataList);
			double[] tempResult = this.compute(dataForCompute);
			result = tempResult[CommonData.INDEX_0];
		}
		return result;
	}

	@Override
	public double[] compute(double[][] baseData) {
		double[] result = null;
		if(baseData !=null){
			MWNumericArray dataForMatLab = DataTools.initData(baseData);
			try {
				Object[] sourceResult = sharpeMatlab.pSharpe(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
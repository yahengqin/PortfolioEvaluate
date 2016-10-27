package com.hundsun.hot.portfolio.compute.implement;

import java.util.List;
import org.springframework.stereotype.Component;

import com.hundsun.hot.portfolio.compute.interfaces.FluctuationCompute;
import com.hundsun.hot.portfolio.matlab.StdMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

@Component
public class FluctuationComputeImpl implements FluctuationCompute {

	private static StdMatlab stdMatlab;

	static {
		try {
			stdMatlab = new StdMatlab();
		} catch (MWException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double[] compute(double[][] baseData) {
		double[] result = null;
		if (baseData != null) {
			MWNumericArray dataForMatLab = DataTools.initData(baseData);
			try {
				Object[] sourceResult = stdMatlab.pSTD(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public double computeSingle(List<BaseEarnings> dataList) {
		double result = Double.MAX_VALUE;
		if (dataList != null && !dataList.isEmpty()) {
			double[][] dataForCompute = new double[1][];
			dataForCompute[CommonData.INDEX_0] = DataTools.dealBaseEarnings(dataList);
			double[] tempResult = this.compute(dataForCompute);
			result = tempResult[CommonData.INDEX_0];
		}
		return result;
	}

}
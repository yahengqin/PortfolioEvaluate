package com.hundsun.hot.portfolio.compute;

import java.util.List;

import org.springframework.stereotype.Component;
import com.hundsun.hot.portfolio.matlab.CumReturnMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

@Component
public class SumEarningsCompute {

	private static CumReturnMatlab cumReturnMatlab;

	static {
		try {
			cumReturnMatlab = new CumReturnMatlab();
		} catch (MWException e) {
			e.printStackTrace();
		}
	}

	public double[] execute(List<BaseEarnings> list) {
		double[] result = null;
		if (list != null && !list.isEmpty()) {
			double[] data = DataTools.dealBaseEarnings(list);
			MWNumericArray dataForMatLab = DataTools.initData(data);
			try {
				Object[] sourceResult = cumReturnMatlab.pCumReturn(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
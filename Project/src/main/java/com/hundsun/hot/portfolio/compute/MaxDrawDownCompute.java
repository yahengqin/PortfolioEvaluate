package com.hundsun.hot.portfolio.compute;

import java.util.List;

import org.springframework.stereotype.Component;
import com.hundsun.hot.portfolio.matlab.MaxDrawDownMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
@Component
public class MaxDrawDownCompute {
	
	private static MaxDrawDownMatlab maxDrawDownrawDown ;
	
	static{
		try {
			maxDrawDownrawDown= new MaxDrawDownMatlab();
		} catch (MWException e) {
			e.printStackTrace();
		}
	}
	
	public double[] execute(List<BaseEarnings> list){
		double[] result = null;
		if(list != null && !list.isEmpty()){
			double[] data  = DataTools.dealBaseEarnings(list);
			MWNumericArray dataForMatLab = DataTools.initData(data);
			try {
				Object[] sourceResult = maxDrawDownrawDown.pMaximumDrawdown(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
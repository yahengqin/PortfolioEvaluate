package com.hundsun.hot.portfolio.compute;

import java.util.List;

import org.springframework.stereotype.Component;
import com.hundsun.hot.portfolio.matlab.StdMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

@Component
public class FluctuationCompute {
	
	private static StdMatlab stdMatlab ;
	
	static{
		try {
			stdMatlab= new StdMatlab();
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
				Object[] sourceResult = stdMatlab.pSTD(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
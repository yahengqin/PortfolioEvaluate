package com.hundsun.hot.portfolio.compute;

import java.util.List;

import org.springframework.stereotype.Component;
import com.hundsun.hot.portfolio.matlab.SharpeMatlab;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
@Component
public class SharpCompute {
	
	private static SharpeMatlab sharpe ;
	
	static{
		try {
			sharpe= new SharpeMatlab();
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
				Object[] sourceResult = sharpe.pSharpe(DataTools.PARA_NUM_ONE, dataForMatLab);
				result = DataTools.dealResult(sourceResult);
			} catch (MWException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
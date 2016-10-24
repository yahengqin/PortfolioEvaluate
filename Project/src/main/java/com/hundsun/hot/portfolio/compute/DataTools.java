package com.hundsun.hot.portfolio.compute;

import java.util.List;

import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class DataTools {
	
	public static int PARA_NUM_ONE = 1;
	
	/**
	 * @Description 将矩阵处理为matlab识别的矩阵
	 * @param data
	 * @return MWNumericArray
	 */
	protected static MWNumericArray initData(double[][] data){
		MWNumericArray result =null;
		if(data != null){
			result = new MWNumericArray(data, MWClassID.DOUBLE);
		}
		return result;
	}
	
	/**
	 * @Description 将矩阵处理为matlab识别的矩阵
	 * @param data
	 * @return MWNumericArray
	 */
	protected static MWNumericArray initData(double[] data){
		MWNumericArray result =null;
		if(data != null){
			result = new MWNumericArray(data, MWClassID.DOUBLE);
		}
		return result;
	}
	
	/**
	 * @Description 将基础收益数组处理为计算可用的double数组
	 * @param list
	 * @return double[]
	 */
	protected static double[] dealBaseEarnings(List<BaseEarnings> list) {
		double[] result = null;
		if(list != null && list.isEmpty()!= true){
			int size = list.size();
			result = new double[size];
			for(int i = 0 ;i < size ;i++){
				result[i] = list.get(i).getStockEarnings();
			}
		}
		return result;
	}
	
	/**
	 * @Description 将matlab运算结果解析为矩阵
	 * @param object
	 * @return
	 * @return double[][]
	 */
	protected static double[] dealResult(Object[] object) {
		double[] result = null;
		if(object != null){
			MWNumericArray mArray = (MWNumericArray)object[0];
			Object resObject = mArray.toDoubleArray();
			double[][] temp = (double[][]) resObject;
			result = new double[temp.length];
			for(int  i = 0 ; i< temp.length ;i++){
				result[i] = temp[i][0];
			}
		}
		return result;
	}
	
}

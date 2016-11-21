package com.hundsun.hot.portfolio.compute.implement;

import java.util.List;

import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class DataTools {
	
	public static int PARA_NUM_ONE = 1;
	public static int PARA_NUM_TWO = 2;
	
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
	 * @Description 将基础收益数组处理为计算可用的double数组，但是只允许List为单支股票的基础收益
	 * @param dataList
	 * @return double[]
	 */
	protected static double[] dealBaseEarnings(List<BaseEarnings> dataList) {
		double[] result = null;
		if(dataList == null || dataList.isEmpty()){
			return result;
		}
		String tempCode = dataList.get(0).getStockCode();
		if(tempCode != null){
			for(BaseEarnings baseEarnings : dataList){
				if(!baseEarnings.getStockCode().equals(tempCode)){
					return result;
				}
			}
		}
		int size = dataList.size();
		result = new double[size];
		for(int i = 0 ;i < size ;i++){
			result[i] = dataList.get(i).getStockEarnings();
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

package com.hundsun.hot.portfolio.demo;


import com.hundsun.hot.portfolio.compute.Std;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class Compute {

	private static double[][] computeStd(double[][] dataForStd) {
		try {
			Std std = new Std();
			MWNumericArray mwNumericArray = new MWNumericArray(dataForStd, MWClassID.DOUBLE);
			Object[] result = std.pSTD(1, mwNumericArray);
			System.out.println(result[0].toString());
		} catch (MWException e) {
			e.printStackTrace();
		}
		return dataForStd;
	}

	public static void main(String[] args) {
		double[][] dataForStd = { { 1, 2, 3 }, { 12, 32, 32 } };
		computeStd(dataForStd);
	}

}

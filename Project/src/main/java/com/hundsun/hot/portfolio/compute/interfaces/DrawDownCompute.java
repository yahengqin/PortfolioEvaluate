package com.hundsun.hot.portfolio.compute.interfaces;

import java.util.List;

import com.hundsun.hot.portfolio.model.BaseEarnings;

public interface DrawDownCompute extends BaseCompute {
	
	double computeSingle(List<BaseEarnings> dataList);
	
}

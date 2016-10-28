package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.hot.portfolio.compute.interfaces.DrawDownCompute;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.mapper.MaxDrawDownMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.model.MaxDrawDown;
import com.hundsun.hot.portfolio.service.interfaces.MaxDrawDownService;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.DateTools;

@Service
public class MaxDrawDownSrvImpl implements MaxDrawDownService {

	@Autowired
	private MaxDrawDownMapper drawDownmapper;
	
	@Autowired
	private BaseEarningsMapper baseEarnMapper;
	
	@Autowired
	private DrawDownCompute drawDownCompute;

	@Override
	public int delete(String stockCode) {
		if (stockCode != null) {
			return drawDownmapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(MaxDrawDown record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return drawDownmapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public MaxDrawDown getRecordByKey(String stockCode) {
		MaxDrawDown result = null;
		if (stockCode != null) {
			result = drawDownmapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<MaxDrawDown> getAll() {
		List<MaxDrawDown> result = null;
		result = drawDownmapper.selectAll();
		return result;
	}

	@Override
	public int update(MaxDrawDown record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return drawDownmapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

	@Override
	public MaxDrawDown computeLasestData(String stockCode) {
		MaxDrawDown result = null;
		if(stockCode != null){
			result = new MaxDrawDown();
			result.setMaxDrawDown20(doCompute(stockCode, CommonData.DAY_20));
			result.setMaxDrawDown120(doCompute(stockCode, CommonData.DAY_120));
			result.setMaxDrawDown250(doCompute(stockCode, CommonData.DAY_250));
			result.setMaxDrawDown500(doCompute(stockCode, CommonData.DAY_500));
			result.setStockCode(stockCode);
		}
		return result;
	}
	
	private double doCompute(String stockCode,int dayPrevious){
		List<BaseEarnings> listForCompute = null;
		listForCompute = baseEarnMapper.getBaseEarningsPrevious(stockCode, DateTools.getToday(), dayPrevious);
		double res = drawDownCompute.computeSingle(listForCompute);
		return res;
	}


}

package com.hundsun.hot.portfolio.service.implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.hot.portfolio.compute.interfaces.VarCompute;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.mapper.VarRatioMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.model.VarRatio;
import com.hundsun.hot.portfolio.service.interfaces.VarRatioService;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.DateTools;

@Service
public class VarRatioSrvImpl implements VarRatioService {

	@Autowired
	private VarRatioMapper varMapper;
	
	@Autowired
	private BaseEarningsMapper baseEarnMapper;
	
	@Autowired
	private VarCompute varCompute;

	@Override
	public int delete(String stockCode) {
		if (stockCode != null) {
			return varMapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(VarRatio record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return varMapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public VarRatio getRecordByKey(String stockCode) {
		VarRatio result = null;
		if (stockCode != null) {
			result = varMapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<VarRatio> getAll() {
		List<VarRatio> result = null;
		result = varMapper.selectAll();
		return result;
	}

	@Override
	public int update(VarRatio record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return varMapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

	@Override
	public VarRatio computeLasestData(String stockCode) {
		VarRatio result = null;
		if(stockCode != null){
			result = new VarRatio();
			result.setVarRatio250(doCompute(stockCode, CommonData.DAY_20));
			result.setStockCode(stockCode);
		}
		return result;
	}
	
	private double doCompute(String stockCode,int dayPrevious){
		List<BaseEarnings> listForCompute = null;
		listForCompute = baseEarnMapper.getBaseEarningsPrevious(stockCode, DateTools.getToday(), dayPrevious);
		double res = varCompute.computeSingle(listForCompute);
		return res;
	}

}

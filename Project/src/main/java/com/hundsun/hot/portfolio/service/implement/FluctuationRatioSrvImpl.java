package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.hot.portfolio.compute.FluctuationCompute;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.mapper.FluctuationRatioMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.model.FluctuationRatio;
import com.hundsun.hot.portfolio.service.interfaces.FluctuationRatioService;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.DateTools;
@Service
public class FluctuationRatioSrvImpl implements FluctuationRatioService {

	@Autowired
	private FluctuationRatioMapper fluMapper;
	
	@Autowired
	private BaseEarningsMapper baseEarnMapper;
	
	@Autowired
	private FluctuationCompute fluCompute;
	
	@Override
	public int delete(String stockCode) {
		if(stockCode != null){
			return fluMapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(FluctuationRatio record) {
		if(record !=null){
			if(record.getStockCode() != null){
				return fluMapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public int update(FluctuationRatio record) {
		if(record !=null){
			if(record.getStockCode() != null){
				return fluMapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

	@Override
	public FluctuationRatio getRecordByKey(String stockCode) {
		FluctuationRatio result = null;
		if(stockCode != null){
			result = fluMapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<FluctuationRatio> getAll() {
		List<FluctuationRatio> result = null;
		result = fluMapper.selectAll();
		return result;
	}

	@Override
	public FluctuationRatio computeLasestData(String stockCode) {
		FluctuationRatio result = null;
		if(stockCode != null){
			result = new FluctuationRatio();
			result.setFluctuationRatio20(doCompute(stockCode, CommonData.DAY_20));
			result.setFluctuationRatio120(doCompute(stockCode, CommonData.DAY_120));
			result.setFluctuationRatio250(doCompute(stockCode, CommonData.DAY_250));
			result.setFluctuationRatio500(doCompute(stockCode, CommonData.DAY_500));
			result.setStockCode(stockCode);
		}
		return result;
	}
	
	private double doCompute(String stockCode,int dayPrevious){
		List<BaseEarnings> listForCompute = null;
		listForCompute = baseEarnMapper.getBaseEarningsPrevious(stockCode, DateTools.getToday(), dayPrevious);
		double[] res = fluCompute.execute(listForCompute);
		return res[CommonData.INDEX_0];
	}

}

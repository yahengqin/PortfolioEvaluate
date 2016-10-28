package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.hot.portfolio.compute.interfaces.SharpCompute;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.mapper.SharpRatioMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.model.SharpRatio;
import com.hundsun.hot.portfolio.service.interfaces.SharpRatioService;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.DateTools;
@Service
public class SharpRatioSrvImpl implements SharpRatioService {

	@Autowired
	private SharpRatioMapper sharpMapper;
	
	@Autowired
	private BaseEarningsMapper baseEarnMapper;
	
	@Autowired
	private SharpCompute sharpCompute;
	
	@Override
	public int delete(String stockCode) {
		if(stockCode != null){
			return sharpMapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(SharpRatio record) {
		if(record != null){
			if(record.getStockCode()!= null){
				return sharpMapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public SharpRatio getRecordByKey(String stockCode) {
		SharpRatio result = null;
		if(stockCode != null){
			result = sharpMapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<SharpRatio> getAll() {
		List<SharpRatio> result = null;
		result =  sharpMapper.selectAll();
		return result;
	}

	@Override
	public int update(SharpRatio record) {
		if(record != null){
			if(record.getStockCode() != null){
				return sharpMapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

	@Override
	public SharpRatio computeLasestData(String stockCode) {
		SharpRatio result = null;
		if(stockCode != null){
			result = new SharpRatio();
			result.setSharpRatio20(doCompute(stockCode, CommonData.DAY_20));
			result.setSharpRatio120(doCompute(stockCode, CommonData.DAY_120));
			result.setSharpRatio250(doCompute(stockCode, CommonData.DAY_250));
			result.setSharpRatio500(doCompute(stockCode, CommonData.DAY_500));
			result.setStockCode(stockCode);
		}
		return result;
	}
	
	private double doCompute(String stockCode,int dayPrevious){
		List<BaseEarnings> listForCompute = null;
		listForCompute = baseEarnMapper.getBaseEarningsPrevious(stockCode, DateTools.getToday(), dayPrevious);
		double res = sharpCompute.computeSingle(listForCompute);
		return res;
	}

}

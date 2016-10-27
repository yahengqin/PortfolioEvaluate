package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.hot.portfolio.compute.interfaces.SumEarningsCompute;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.mapper.SumEarningsMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.model.SumEarnings;
import com.hundsun.hot.portfolio.service.interfaces.SumEarningsService;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.DateTools;
@Service
public class SumEarningsSrvImpl implements SumEarningsService {

	@Autowired
	private SumEarningsMapper sumMapper;
	
	@Autowired
	private BaseEarningsMapper baseEarnMapper;
	
	@Autowired
	private SumEarningsCompute sumEarningsCompute;
	
	@Override
	public int delete(String stockCode) {
		if(stockCode != null){
			return sumMapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(SumEarnings record) {
		if(record != null){
			if(record.getStockCode() != null){
				return sumMapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public SumEarnings getRecordByKey(String stockCode) {
		SumEarnings result =  null;
		if(stockCode != null){
			result = sumMapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<SumEarnings> getAll() {
		List<SumEarnings> result = null;
		result= sumMapper.selectAll();
		return result;
	}

	@Override
	public int update(SumEarnings record) {
		if(record != null){
			if(record.getStockCode() != null){
				return sumMapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

	@Override
	public SumEarnings computeLasestData(String stockCode) {
		SumEarnings result = null;
		if(stockCode != null){
			result = new SumEarnings();
			result.setSumEarnings20(doCompute(stockCode, CommonData.DAY_20));
			result.setSumEarnings120(doCompute(stockCode, CommonData.DAY_120));
			result.setSumEarnings250(doCompute(stockCode, CommonData.DAY_250));
			result.setSumEarnings500(doCompute(stockCode, CommonData.DAY_500));
			result.setStockCode(stockCode);
		}
		return result;
	}
	
	private double doCompute(String stockCode,int dayPrevious){
		List<BaseEarnings> listForCompute = null;
		listForCompute = baseEarnMapper.getBaseEarningsPrevious(stockCode, DateTools.getToday(), dayPrevious);
		double res = sumEarningsCompute.computeSingle(listForCompute);
		return res;
	}

}

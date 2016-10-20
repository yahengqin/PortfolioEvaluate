package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;
import com.hundsun.hot.portfolio.service.interfaces.BaseEarningsService;
@Service
public class BaseEarningsSrvImpl implements BaseEarningsService {
	
	@Autowired
	private BaseEarningsMapper mapper;

	@Override
	public int delete(String stockCode, Integer tradeDay) {
		if(stockCode != null && tradeDay != null){
			return mapper.deleteByPrimaryKey(stockCode, tradeDay);
		}else{
			return -1;	
		}
	}

	@Override
	public int insert(BaseEarnings record) {
		if(record != null){
			if(record.getStockCode() != null && record.getTradeDay()!= null){
				mapper.insert(record);
			}
		}
		return 0;
	}

	@Override
	public BaseEarnings getRecordByKey(String stockCode, Integer tradeDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseEarnings> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByKey(BaseEarnings record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getStockCodeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseEarnings> getStockBaseEarnings(String stockCode, Integer startDate, Integer endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.hot.portfolio.mapper.SumEarningsMapper;
import com.hundsun.hot.portfolio.model.SumEarnings;
import com.hundsun.hot.portfolio.service.interfaces.SumEarningsService;
@Service
public class SumEarningsSrvImpl implements SumEarningsService {

	@Autowired
	private SumEarningsMapper mapper;
	
	@Override
	public int delete(String stockCode) {
		if(stockCode != null){
			return mapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(SumEarnings record) {
		if(record != null){
			if(record.getStockCode() != null){
				return mapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public SumEarnings getRecordByKey(String stockCode) {
		SumEarnings result =  null;
		if(stockCode != null){
			result = mapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<SumEarnings> getAll() {
		List<SumEarnings> result = null;
		result= mapper.selectAll();
		return result;
	}

	@Override
	public int update(SumEarnings record) {
		if(record != null){
			if(record.getStockCode() != null){
				return mapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

}

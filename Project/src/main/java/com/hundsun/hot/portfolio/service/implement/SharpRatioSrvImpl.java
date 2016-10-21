package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.hot.portfolio.mapper.SharpRatioMapper;
import com.hundsun.hot.portfolio.model.SharpRatio;
import com.hundsun.hot.portfolio.service.interfaces.SharpRatioService;
@Service
public class SharpRatioSrvImpl implements SharpRatioService {

	@Autowired
	private SharpRatioMapper mapper;
	
	@Override
	public int delete(String stockCode) {
		if(stockCode != null){
			return mapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(SharpRatio record) {
		if(record != null){
			if(record.getStockCode()!= null){
				return mapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public SharpRatio getRecordByKey(String stockCode) {
		SharpRatio result = null;
		if(stockCode != null){
			result = mapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<SharpRatio> getAll() {
		List<SharpRatio> result = null;
		result =  mapper.selectAll();
		return result;
	}

	@Override
	public int update(SharpRatio record) {
		if(record != null){
			if(record.getStockCode() != null){
				return mapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

}

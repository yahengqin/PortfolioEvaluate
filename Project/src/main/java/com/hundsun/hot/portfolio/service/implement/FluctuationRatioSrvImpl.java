package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.hot.portfolio.mapper.FluctuationRatioMapper;
import com.hundsun.hot.portfolio.model.FluctuationRatio;
import com.hundsun.hot.portfolio.service.interfaces.FluctuationRatioService;
@Service
public class FluctuationRatioSrvImpl implements FluctuationRatioService {

	@Autowired
	private FluctuationRatioMapper mapper;
	
	@Override
	public int delete(String stockCode) {
		if(stockCode != null){
			return mapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(FluctuationRatio record) {
		if(record !=null){
			if(record.getStockCode() != null){
				return mapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public int update(FluctuationRatio record) {
		if(record !=null){
			if(record.getStockCode() != null){
				return mapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

	@Override
	public FluctuationRatio getRecordByKey(String stockCode) {
		FluctuationRatio result = null;
		if(stockCode != null){
			result = mapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<FluctuationRatio> getAll() {
		List<FluctuationRatio> result = null;
		result = mapper.selectAll();
		return result;
	}

}

package com.hundsun.hot.portfolio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.hot.portfolio.mapper.MaxDrawDownMapper;
import com.hundsun.hot.portfolio.model.MaxDrawDown;
import com.hundsun.hot.portfolio.service.interfaces.MaxDrawDownService;

@Service
public class MaxDrawDownSrvImpl implements MaxDrawDownService {

	@Autowired
	private MaxDrawDownMapper mapper;

	@Override
	public int delete(String stockCode) {
		if (stockCode != null) {
			return mapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(MaxDrawDown record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return mapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public MaxDrawDown getRecordByKey(String stockCode) {
		MaxDrawDown result = null;
		if (stockCode != null) {
			result = mapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<MaxDrawDown> getAll() {
		List<MaxDrawDown> result = null;
		result = mapper.selectAll();
		return result;
	}

	@Override
	public int update(MaxDrawDown record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return mapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

}

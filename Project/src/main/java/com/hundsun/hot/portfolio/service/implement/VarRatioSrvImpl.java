package com.hundsun.hot.portfolio.service.implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hundsun.hot.portfolio.mapper.VarRatioMapper;
import com.hundsun.hot.portfolio.model.VarRatio;
import com.hundsun.hot.portfolio.service.interfaces.VarRatioService;

@Service
public class VarRatioSrvImpl implements VarRatioService {

	@Autowired
	private VarRatioMapper mapper;

	@Override
	public int delete(String stockCode) {
		if (stockCode != null) {
			return mapper.deleteByPrimaryKey(stockCode);
		}
		return -1;
	}

	@Override
	public int insert(VarRatio record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return mapper.insert(record);
			}
		}
		return -1;
	}

	@Override
	public VarRatio getRecordByKey(String stockCode) {
		VarRatio result = null;
		if (stockCode != null) {
			result = mapper.selectByPrimaryKey(stockCode);
		}
		return result;
	}

	@Override
	public List<VarRatio> getAll() {
		List<VarRatio> result = null;
		result = mapper.selectAll();
		return result;
	}

	@Override
	public int update(VarRatio record) {
		if (record != null) {
			if (record.getStockCode() != null) {
				return mapper.updateByPrimaryKey(record);
			}
		}
		return -1;
	}

}

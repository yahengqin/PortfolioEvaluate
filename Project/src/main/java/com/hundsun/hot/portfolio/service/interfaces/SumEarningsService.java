package com.hundsun.hot.portfolio.service.interfaces;

import com.hundsun.hot.portfolio.model.SumEarnings;
import java.util.List;

public interface SumEarningsService {
	
    int delete(String stockCode);

    int insert(SumEarnings record);

    SumEarnings getRecordByKey(String stockCode);

    List<SumEarnings> getAll();

    int update(SumEarnings record);
    
    SumEarnings computeLasestData(String stockCode);
    
}
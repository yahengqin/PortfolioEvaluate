package com.hundsun.hot.portfolio.service.interfaces;

import com.hundsun.hot.portfolio.model.MaxDrawDown;
import java.util.List;

public interface MaxDrawDownService {
	
    int delete(String stockCode);

    int insert(MaxDrawDown record);

    MaxDrawDown getRecordByKey(String stockCode);

    List<MaxDrawDown> getAll();

    int update(MaxDrawDown record);
    
    MaxDrawDown computeLasestData(String stockCode);
}
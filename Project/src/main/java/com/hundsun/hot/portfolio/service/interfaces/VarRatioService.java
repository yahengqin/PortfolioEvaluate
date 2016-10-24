package com.hundsun.hot.portfolio.service.interfaces;

import com.hundsun.hot.portfolio.model.VarRatio;
import java.util.List;

public interface VarRatioService {
	
    int delete(String stockCode);

    int insert(VarRatio record);

    VarRatio getRecordByKey(String stockCode);

    List<VarRatio> getAll();

    int update(VarRatio record);
    
    VarRatio computeLasestData(String stockCode);
}
package com.hundsun.hot.portfolio.service.interfaces;

import com.hundsun.hot.portfolio.model.FluctuationRatio;
import java.util.List;

public interface FluctuationRatioService{

    int delete(String stockCode);

    int insert(FluctuationRatio record);

    int update(FluctuationRatio record);

    FluctuationRatio getRecordByKey(String stockCode);

    List<FluctuationRatio> getAll();
    
    FluctuationRatio computeLasestData(String stockCode);
}
package com.hundsun.hot.portfolio.service.interfaces;

import com.hundsun.hot.portfolio.model.SharpRatio;
import java.util.List;

public interface SharpRatioService {
    int delete(String stockCode);

    int insert(SharpRatio record);

    SharpRatio getRecordByKey(String stockCode);

    List<SharpRatio> getAll();

    int update(SharpRatio record);
    
    SharpRatio computeLasestData(String stockCode);
}
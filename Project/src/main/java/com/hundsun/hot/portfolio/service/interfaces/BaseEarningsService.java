package com.hundsun.hot.portfolio.service.interfaces;

import com.hundsun.hot.portfolio.model.BaseEarnings;
import java.util.List;

public interface BaseEarningsService {
	
    int delete(String stockCode, Integer tradeDay);

    int insert(BaseEarnings record);

    BaseEarnings getRecordByKey( String stockCode, Integer tradeDay);

    List<BaseEarnings> getAll();

    int update(BaseEarnings record);
    
    /**
     * @Description 获取所有的股票列表
     * @return List<String>
     */
    List<String> getStockCodeList();
    
    /**
     * @Description 获取股票在一段时间内的收益数据,时间片段为开区间
     * @param stockCode
     * @param startDate
     * @param endDate
     * @return List<BaseEarnings>
     */
    List<BaseEarnings> getStockBaseEarnings(String stockCode ,Integer startDate, Integer endDate);
    
	/**
	 * @Description 获取指定日期前N天的基础收益数据
	 * @param stockCode
	 * @param startDate
	 * @param previousDay
	 * @return List<BaseEarnings>
	 */
	List<BaseEarnings> getBaseEarningsPrevious(String stockCode, Integer startDate, Integer previousDay);

}
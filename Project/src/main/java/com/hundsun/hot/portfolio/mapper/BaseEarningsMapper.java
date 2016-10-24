package com.hundsun.hot.portfolio.mapper;

import com.hundsun.hot.portfolio.model.BaseEarnings;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseEarningsMapper {
	
	int deleteByPrimaryKey(@Param("stockCode") String stockCode, @Param("tradeDay") Integer tradeDay);

	int insert(BaseEarnings record);

	BaseEarnings selectByPrimaryKey(@Param("stockCode") String stockCode, @Param("tradeDay") Integer tradeDay);

	List<BaseEarnings> selectAll();

	int updateByPrimaryKey(BaseEarnings record);

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
	List<BaseEarnings> getStockBaseEarnings(@Param("stockCode") String stockCode, @Param("startDate") Integer startDate,
			@Param("endDate") Integer endDate);

	/**
	 * @Description 获取指定日期前N天的基础收益数据
	 * @param stockCode
	 * @param startDate
	 * @param previousDay
	 * @return List<BaseEarnings>
	 */
	List<BaseEarnings> getBaseEarningsPrevious(@Param("stockCode") String stockCode,
			@Param("startDate") Integer startDate, @Param("previousDay") Integer previousDay);
}
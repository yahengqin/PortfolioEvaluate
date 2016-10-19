package com.hundsun.hot.portfolio.mapper;

import com.hundsun.hot.portfolio.model.FluctuationRatio;
import java.util.List;

public interface FluctuationRatioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock_fluctuation_ratio
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    int deleteByPrimaryKey(String stockCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock_fluctuation_ratio
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    int insert(FluctuationRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock_fluctuation_ratio
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    FluctuationRatio selectByPrimaryKey(String stockCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock_fluctuation_ratio
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    List<FluctuationRatio> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_stock_fluctuation_ratio
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    int updateByPrimaryKey(FluctuationRatio record);
}
package com.hundsun.hot.portfolio.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseEarnings {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock_base_earnings.stock_code
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    private String stockCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock_base_earnings.trade_day
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    private Integer tradeDay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock_base_earnings.stock_earnings
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    private Double stockEarnings;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stock_base_earnings.earnings_type
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    private String earningsType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock_base_earnings.stock_code
     *
     * @return the value of t_stock_base_earnings.stock_code
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock_base_earnings.stock_code
     *
     * @param stockCode the value for t_stock_base_earnings.stock_code
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock_base_earnings.trade_day
     *
     * @return the value of t_stock_base_earnings.trade_day
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public Integer getTradeDay() {
        return tradeDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock_base_earnings.trade_day
     *
     * @param tradeDay the value for t_stock_base_earnings.trade_day
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public void setTradeDay(Integer tradeDay) {
        this.tradeDay = tradeDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock_base_earnings.stock_earnings
     *
     * @return the value of t_stock_base_earnings.stock_earnings
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public Double getStockEarnings() {
        return stockEarnings;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock_base_earnings.stock_earnings
     *
     * @param stockEarnings the value for t_stock_base_earnings.stock_earnings
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public void setStockEarnings(Double stockEarnings) {
        this.stockEarnings = stockEarnings;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stock_base_earnings.earnings_type
     *
     * @return the value of t_stock_base_earnings.earnings_type
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public String getEarningsType() {
        return earningsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stock_base_earnings.earnings_type
     *
     * @param earningsType the value for t_stock_base_earnings.earnings_type
     *
     * @mbg.generated Tue Oct 18 16:28:59 CST 2016
     */
    public void setEarningsType(String earningsType) {
        this.earningsType = earningsType == null ? null : earningsType.trim();
    }
    
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
    @Override
    public String toString(){
    	return ToStringBuilder.reflectionToString(this);
    }
}
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : hot_portfolio_evaluate

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-09-11 11:44:21
*/
CREATE DATABASE
IF NOT EXISTS hot_portfolio_evaluate DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE hot_portfolio_evaluate;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_stock_base_earnings
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_base_earnings`;
CREATE TABLE `t_stock_base_earnings` (
  `stock_code` varchar(20) NOT NULL,
  `trade_day` int(10) NOT NULL COMMENT '记录规则如：20160911',
  `stock_earnings` double DEFAULT NULL,
  `earnings_type` char(2) DEFAULT NULL COMMENT '0：个股收益率；1：行业收益率；2：沪深300收益率；',
  KEY `stock_day` (`stock_code`,`trade_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_fluctuation_ratio
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_fluctuation_ratio`;
CREATE TABLE `t_stock_fluctuation_ratio` (
  `stock_code` varchar(20) NOT NULL,
  `fluctuation_ratio_20` double DEFAULT NULL,
  `fluctuation_ratio_120` double DEFAULT NULL,
  `fluctuation_ratio_250` double DEFAULT NULL,
  `fluctuation_ratio_500` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_max_draw_down
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_max_draw_down`;
CREATE TABLE `t_stock_max_draw_down` (
  `stock_code` varchar(20) NOT NULL,
  `max_draw_down_20` double DEFAULT NULL,
  `max_draw_down_120` double DEFAULT NULL,
  `max_draw_down_250` double DEFAULT NULL,
  `max_draw_down_500` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_sharp_ratio
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_sharp_ratio`;
CREATE TABLE `t_stock_sharp_ratio` (
  `stock_code` varchar(20) NOT NULL,
  `sharp_ratio_20` double DEFAULT NULL,
  `sharp_ratio_120` double DEFAULT NULL,
  `sharp_ratio_250` double DEFAULT NULL,
  `sharp_ratio_500` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_sum_earnings
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_sum_earnings`;
CREATE TABLE `t_stock_sum_earnings` (
  `stock_code` varchar(20) NOT NULL,
  `sum_earnings_20` double DEFAULT NULL,
  `sum_earnings_120` double DEFAULT NULL,
  `sum_earnings_250` double DEFAULT NULL,
  `sum_earnings_500` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_var_ratio
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_var_ratio`;
CREATE TABLE `t_stock_var_ratio` (
  `stock_code` varchar(20) NOT NULL,
  `var_ratio_250` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

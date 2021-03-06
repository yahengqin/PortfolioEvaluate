/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : hot_portfolio_evaluate

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-11-18 17:27:04
*/
CREATE DATABASE
IF NOT EXISTS hot_portfolio_evaluate DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE hot_portfolio_evaluate;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_portfolio_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_portfolio_base_info`;
CREATE TABLE `t_portfolio_base_info` (
  `portfolio_id` int(11) NOT NULL,
  `create_time` int(11) DEFAULT NULL,
  `modify_time` int(11) DEFAULT NULL,
  `portfolio_value` double DEFAULT NULL,
  `score` double DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_portfolio_detail_info
-- ----------------------------
DROP TABLE IF EXISTS `t_portfolio_detail_info`;
CREATE TABLE `t_portfolio_detail_info` (
  `portfolio_id` int(11) NOT NULL,
  `stock_code` varchar(20) NOT NULL,
  `ratio` double DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`,`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_portfolio_history_modify
-- ----------------------------
DROP TABLE IF EXISTS `t_portfolio_history_modify`;
CREATE TABLE `t_portfolio_history_modify` (
  `portfolio_id` int(11) NOT NULL,
  `stock_code` varchar(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `ratio_before` double DEFAULT NULL,
  `ratio_after` double DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`,`stock_code`,`modify_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_portfolio_history_value
-- ----------------------------
DROP TABLE IF EXISTS `t_portfolio_history_value`;
CREATE TABLE `t_portfolio_history_value` (
  `portfolio_id` int(11) NOT NULL,
  `trade_day` int(10) NOT NULL,
  `portfolio_value` double DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`,`trade_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_base_earnings
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_base_earnings`;
CREATE TABLE `t_stock_base_earnings` (
  `stock_code` varchar(20) NOT NULL,
  `trade_day` int(10) NOT NULL COMMENT '记录规则如：20160911',
  `stock_earnings` double NOT NULL,
  `earnings_type` char(2) DEFAULT NULL COMMENT '0：个股收益率；1：行业收益率；2：沪深300收益率；',
  PRIMARY KEY (`stock_code`,`trade_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_base_info`;
CREATE TABLE `t_stock_base_info` (
  `stock_code` varchar(20) NOT NULL,
  `market` varchar(20) DEFAULT NULL,
  `stock_name` varchar(40) DEFAULT NULL,
  `industry_code` varchar(20) DEFAULT NULL,
  `industry_type` varchar(20) DEFAULT NULL,
  `industry_name` varchar(40) DEFAULT NULL,
  `trade_status` int(5) NOT NULL DEFAULT '5',
  PRIMARY KEY (`stock_code`)
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
  `fluctuation_ratio_500` double DEFAULT NULL,
  PRIMARY KEY (`stock_code`)
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
  `max_draw_down_500` double DEFAULT NULL,
  PRIMARY KEY (`stock_code`)
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
  `sharp_ratio_500` double DEFAULT NULL,
  PRIMARY KEY (`stock_code`)
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
  `sum_earnings_500` double DEFAULT NULL,
  PRIMARY KEY (`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_stock_var_ratio
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_var_ratio`;
CREATE TABLE `t_stock_var_ratio` (
  `stock_code` varchar(20) NOT NULL,
  `var_ratio_250` double DEFAULT NULL,
  PRIMARY KEY (`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `user_id` int(11) NOT NULL,
  `user_acco` varchar(30) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `work_id` int(11) DEFAULT NULL,
  `wechat_id` varchar(30) DEFAULT NULL,
  `phone_num` int(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_acco` (`user_acco`),
  UNIQUE KEY `work_id` (`work_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_portfolio
-- ----------------------------
DROP TABLE IF EXISTS `t_user_portfolio`;
CREATE TABLE `t_user_portfolio` (
  `user_id` int(11) NOT NULL,
  `portfilio_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`portfilio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

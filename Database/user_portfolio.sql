/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : hot_portfolio_evaluate

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-11-11 17:15:20
*/

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
  `yesterday_earnings` double DEFAULT NULL,
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
-- Table structure for t_stock_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_base_info`;
CREATE TABLE `t_stock_base_info` (
  `stock_code` varchar(20) NOT NULL,
  `market` varchar(10) DEFAULT NULL,
  `stock_name` varchar(40) DEFAULT NULL,
  `stock_style` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `work_id` int(11) DEFAULT NULL,
  `wechat_id` varchar(30) DEFAULT NULL,
  `phone_num` int(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
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

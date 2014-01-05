/*
Navicat MySQL Data Transfer

Source Server         : mySQLchenrui
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : sampledb

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2014-01-02 23:37:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `ip` varchar(23) default NULL,
  `login_datetime` datetime default NULL,
  PRIMARY KEY  (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(30) default NULL,
  `credits` int(11) default NULL,
  `password` varchar(32) default NULL,
  `last_visit` datetime default NULL,
  `last_ip` varchar(23) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', null, '123456', null, null);

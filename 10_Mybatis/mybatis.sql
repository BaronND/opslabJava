/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : 127.0.0.1:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-12-03 22:10:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for loader
-- ----------------------------
DROP TABLE IF EXISTS `loader`;
CREATE TABLE `loader` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loader
-- ----------------------------
INSERT INTO `loader` VALUES ('10001', '李明班主任');
INSERT INTO `loader` VALUES ('10002', '王帅班主任');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(10) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201600011', '小明', '1');
INSERT INTO `student` VALUES ('201600021', '小强', '1');
INSERT INTO `student` VALUES ('201600032', '美丽', '1');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `l_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '一年级一班', '10001');

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `id` varchar(32) NOT NULL,
  `name` varchar(200) NOT NULL,
  `nick` varchar(255) NOT NULL,
  `age` int(100) NOT NULL,
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('mybatis', 'mybatis', '数据库操作利器', '10', '1');
INSERT INTO `t_userinfo` VALUES ('test', '测试账号', 'Map修改后的昵称', '20', '0');
INSERT INTO `t_userinfo` VALUES ('test2', '测试', '测试昵称', '20', '1');

/*
Navicat MySQL Data Transfer

Source Server         : lijianhua
Source Server Version : 50557
Source Host           : 172.18.81.146:3306
Source Database       : leejh_test2

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-08-09 17:42:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for treedata
-- ----------------------------
DROP TABLE IF EXISTS `treedata`;
CREATE TABLE `treedata` (
  `id` varchar(255) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treedata
-- ----------------------------
INSERT INTO `treedata` VALUES ('1', 'Tree', '0', null, null);
INSERT INTO `treedata` VALUES ('11', 'Language', '1', null, null);
INSERT INTO `treedata` VALUES ('111', 'Java', '11', null, null);
INSERT INTO `treedata` VALUES ('112', 'C++', '11', null, null);
INSERT INTO `treedata` VALUES ('113', 'C#', '11', null, null);
INSERT INTO `treedata` VALUES ('1141', 'USA', '114', '1501116100000', '1501116100000');
INSERT INTO `treedata` VALUES ('11411', 'BBC', '1141', '1501116100000', '1501116100000');
INSERT INTO `treedata` VALUES ('12', 'IT', '1', null, null);
INSERT INTO `treedata` VALUES ('121', 'iOS', '12', null, null);
INSERT INTO `treedata` VALUES ('122', 'English', '12', '1501077050000', '1501077050000');
INSERT INTO `treedata` VALUES ('13', 'CEO', '1', '1501062890000', '1501062890000');
INSERT INTO `treedata` VALUES ('131', 'SVP', '13', '1501067870000', '1501067870000');
INSERT INTO `treedata` VALUES ('132', 'new item1', '13', '1501078220000', '1501078220000');
INSERT INTO `treedata` VALUES ('133', 'CCCC', '13', '1501077440000', '1501077440000');
INSERT INTO `treedata` VALUES ('14', 'new item13', '1', '1501077050000', '1501077050000');

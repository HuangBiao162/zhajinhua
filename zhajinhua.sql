/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50557
 Source Host           : localhost:3306
 Source Schema         : zhajinhua

 Target Server Type    : MySQL
 Target Server Version : 50557
 File Encoding         : 65001

 Date: 17/08/2021 17:40:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card_info
-- ----------------------------
DROP TABLE IF EXISTS `card_info`;
CREATE TABLE `card_info`  (
  `cid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uid` bigint(11) NOT NULL COMMENT '玩家id',
  `rid` bigint(11) NOT NULL COMMENT '房间号',
  `card_content` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '牌内容大小与颜色组合',
  `card_size` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '牌面大小',
  `card_color` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '牌色',
  `card_score` bigint(20) NOT NULL COMMENT '牌分，牌越大牌分越大',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for history_info
-- ----------------------------
DROP TABLE IF EXISTS `history_info`;
CREATE TABLE `history_info`  (
  `hid` bigint(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cid` bigint(11) NOT NULL COMMENT '场次id',
  `rid` bigint(11) NOT NULL COMMENT '房间id',
  `uid` bigint(11) NOT NULL COMMENT '玩家id',
  `win` bigint(11) NOT NULL COMMENT '赢多少积分',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of history_info
-- ----------------------------
INSERT INTO `history_info` VALUES (00000000001, 0, 1, 1, -5, '2021-08-17 17:29:23');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `rid` bigint(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `cid` bigint(8) UNSIGNED ZEROFILL NOT NULL COMMENT '场次id',
  `uid` bigint(8) NOT NULL COMMENT '玩家id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` bigint(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '玩家id',
  `rid` bigint(11) NOT NULL COMMENT '房间号',
  `cid` bigint(11) NOT NULL COMMENT '场次号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '玩家昵称',
  `integral` bigint(8) UNSIGNED ZEROFILL NOT NULL COMMENT '玩家积分，房间解散后或新进房间应该设为0',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (00000000004, 0, 0, '李四', 00000000, '2021-08-17 16:54:53');
INSERT INTO `user_info` VALUES (00000000005, 0, 0, '李四', 00000000, '2021-08-17 16:56:20');
INSERT INTO `user_info` VALUES (00000000006, 0, 0, '李四', 00000000, '2021-08-17 16:57:29');
INSERT INTO `user_info` VALUES (00000000007, 0, 0, '李四', 00000000, '2021-08-17 16:58:56');
INSERT INTO `user_info` VALUES (00000000008, 0, 0, '李四', 00000000, '2021-08-17 16:59:38');

SET FOREIGN_KEY_CHECKS = 1;

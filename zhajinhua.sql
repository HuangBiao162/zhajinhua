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

 Date: 18/08/2021 20:09:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card_info
-- ----------------------------
DROP TABLE IF EXISTS `card_info`;
CREATE TABLE `card_info`  (
  `cid` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uid` bigint(11) NOT NULL COMMENT '玩家id',
  `rnum` bigint(11) NOT NULL COMMENT '房间号',
  `round` bigint(11) NOT NULL DEFAULT 0 COMMENT '当前回合数',
  `amount` bigint(11) NOT NULL DEFAULT 0 COMMENT '该轮总积分',
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
  `hid` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cid` bigint(11) NOT NULL COMMENT '场次id',
  `rnum` bigint(11) NOT NULL COMMENT '房间id',
  `uid` bigint(11) NOT NULL COMMENT '玩家id',
  `win` bigint(11) NOT NULL COMMENT '赢多少积分',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of history_info
-- ----------------------------
INSERT INTO `history_info` VALUES (1, 0, 1, 1, -5, '2021-08-17 17:29:23');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `rid` bigint(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `cid` bigint(8) NOT NULL COMMENT '场次id',
  `uid` bigint(8) NOT NULL COMMENT '玩家id',
  `rnum` bigint(8) NOT NULL DEFAULT 0 COMMENT '房间号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '房间密码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '玩家id',
  `rnum` bigint(11) NOT NULL COMMENT '房间号',
  `cid` bigint(11) NOT NULL COMMENT '场次号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '玩家昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `integral` bigint(11) NOT NULL COMMENT '玩家积分，房间解散后或新进房间应该设为0',
  `master` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否为庄，默认0，,庄为1',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (4, 0, 0, '李四', '', -1, 0, '2021-08-17 16:54:53');
INSERT INTO `user_info` VALUES (5, 0, 0, '李四', '', 0, 0, '2021-08-17 16:56:20');
INSERT INTO `user_info` VALUES (6, 0, 0, '李四', '', 0, 0, '2021-08-17 16:57:29');
INSERT INTO `user_info` VALUES (7, 0, 0, '李四', '', 0, 0, '2021-08-17 16:58:56');
INSERT INTO `user_info` VALUES (8, 0, 0, '李四', '', 0, 0, '2021-08-17 16:59:38');
INSERT INTO `user_info` VALUES (9, 0, 0, '张三', '123456', 0, 0, '2021-08-18 15:55:40');
INSERT INTO `user_info` VALUES (10, 0, 0, '李四', '123456', 0, 0, '2021-08-18 15:57:44');
INSERT INTO `user_info` VALUES (11, 0, 0, '李四', '123456', 0, 0, '2021-08-18 15:58:45');

SET FOREIGN_KEY_CHECKS = 1;

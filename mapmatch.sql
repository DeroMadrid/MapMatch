/*
 Navicat Premium Data Transfer

 Source Server         : 存储子模块
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : mapmatch

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 19/03/2023 16:33:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `username` varchar(255) CHARACTER SET utf32 COLLATE utf32_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf32 COLLATE utf32_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('frenkie', '1323');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : my_pc
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : ks

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 21/12/2022 17:57:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员用户名',
  `pass_word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员姓名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'wc', 'wc', '王创', '10012341234', '翻斗大街');

-- ----------------------------
-- Table structure for alarm
-- ----------------------------
DROP TABLE IF EXISTS `alarm`;
CREATE TABLE `alarm`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '报警id',
  `data_index` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '报警记录',
  `is_read` int(0) NOT NULL DEFAULT 0 COMMENT '是否已经已读',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_al_data`(`data_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alarm
-- ----------------------------
INSERT INTO `alarm` VALUES (6, '当前时间2022-12-21 17:21:31   NO2超标，数值为85', 0);
INSERT INTO `alarm` VALUES (7, '当前时间2022-12-21 17:22:04   NO2超标，数值为87   SO2超标，数值为17', 0);

-- ----------------------------
-- Table structure for alarm_rule
-- ----------------------------
DROP TABLE IF EXISTS `alarm_rule`;
CREATE TABLE `alarm_rule`  (
  `temperatrue` float NOT NULL COMMENT '数据的警戒值',
  `humidity` float NOT NULL,
  `PM25` float NOT NULL,
  `CO` float NOT NULL,
  `NO2` float NOT NULL,
  `SO2` float NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alarm_rule
-- ----------------------------
INSERT INTO `alarm_rule` VALUES (40, 0.85, 80, 1, 80, 15);

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '数据记录的id',
  `collect_device` bigint(0) NOT NULL COMMENT '采集设备',
  `collect_location` bigint(0) NOT NULL COMMENT '采集地点',
  `collect_time` datetime(0) NOT NULL COMMENT '采集时间',
  `temperature` float NULL DEFAULT NULL COMMENT '温度值',
  `humidity` int(0) NULL DEFAULT NULL COMMENT '湿度值',
  `PM25` int(0) NULL DEFAULT NULL COMMENT 'pm2.5',
  `CO` float NULL DEFAULT NULL COMMENT '一氧化碳',
  `NO2` int(0) NULL DEFAULT NULL COMMENT '二氧化氮',
  `SO2` int(0) NULL DEFAULT NULL COMMENT '二氧化硫',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_co_device`(`collect_device`) USING BTREE,
  INDEX `fk_co_location`(`collect_location`) USING BTREE,
  CONSTRAINT `fk_co_device` FOREIGN KEY (`collect_device`) REFERENCES `device_item` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_co_location` FOREIGN KEY (`collect_location`) REFERENCES `place` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES (25, 25, 1, '2022-12-21 09:21:27', 22.5, 1, 13, NULL, 85, 2);
INSERT INTO `data` VALUES (26, 25, 1, '2022-12-21 09:22:04', 33.9, 0, 21, NULL, 87, 17);
INSERT INTO `data` VALUES (27, 25, 1, '2022-12-21 17:27:50', 34.5, 1, 16, 0.12, 65, 9);

-- ----------------------------
-- Table structure for device_info
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '设备型号id',
  `device_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备型号名',
  `manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '厂商名',
  `device_life` int(0) NOT NULL COMMENT '设备可以用几年',
  `device_left` int(0) NOT NULL DEFAULT 0 COMMENT '当前可用剩余设备数量',
  `temperature` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '温度是否能采集',
  `humidity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '湿度能否采集',
  `PM25` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT 'pm2.5',
  `CO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT 'CO',
  `NO2` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT 'NO2',
  `SO2` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT 'SO2',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_info
-- ----------------------------
INSERT INTO `device_info` VALUES (2, 'A设备', 'A厂商', 2, 4, '支持', '支持', '支持', '支持', '支持', '支持');

-- ----------------------------
-- Table structure for device_item
-- ----------------------------
DROP TABLE IF EXISTS `device_item`;
CREATE TABLE `device_item`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '设备item编号',
  `device_cate` bigint(0) NOT NULL COMMENT '设备型号',
  `install_status` int(0) NOT NULL DEFAULT 0 COMMENT '该设备状态',
  `install_location` bigint(0) NULL DEFAULT NULL COMMENT '安装的地点',
  `install_time` datetime(0) NULL DEFAULT NULL COMMENT '安装日期',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '预计退役日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_device`(`device_cate`) USING BTREE,
  INDEX `fk_location`(`install_location`) USING BTREE,
  CONSTRAINT `fk_device` FOREIGN KEY (`device_cate`) REFERENCES `device_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_location` FOREIGN KEY (`install_location`) REFERENCES `place` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_item
-- ----------------------------
INSERT INTO `device_item` VALUES (25, 2, 1, 1, '2022-12-21 08:52:50', '2024-12-21 08:52:50');
INSERT INTO `device_item` VALUES (26, 2, 1, 2, '2022-12-21 08:52:57', '2024-12-21 08:52:57');
INSERT INTO `device_item` VALUES (27, 2, 1, 3, '2022-12-21 08:53:03', '2024-12-21 08:53:03');
INSERT INTO `device_item` VALUES (28, 2, 1, 4, '2022-12-21 08:53:08', '2024-12-21 08:53:08');

-- ----------------------------
-- Table structure for place
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '地点id',
  `longitude` double NOT NULL COMMENT '地点经度',
  `latitude` double NOT NULL COMMENT '地点维度',
  `place_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of place
-- ----------------------------
INSERT INTO `place` VALUES (1, 112.460223, 34.626339, '洛龙区市政府');
INSERT INTO `place` VALUES (2, 112.402427, 34.663965, '涧西区政府');
INSERT INTO `place` VALUES (3, 112.43449520685112, 34.66619363154539, '西工区政府');
INSERT INTO `place` VALUES (4, 112.47556627375056, 34.68964220501026, '老城区政府');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id，自增',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码  使用MD5',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱，用来联系',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, 'rhw', 'e4ad856731c1b986c99da3474f31559f', 'rhw', 'rhw');

SET FOREIGN_KEY_CHECKS = 1;

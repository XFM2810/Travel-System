/*
 Navicat Premium Data Transfer

 Source Server         : 实验室服务器
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 172.16.2.21:3306
 Source Schema         : lvtu

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 21/11/2020 23:21:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mat
-- ----------------------------
DROP TABLE IF EXISTS `mat`;
CREATE TABLE `mat`  (
  `mat_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '结伴游帖子id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '发起人id',
  `mat_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `mat_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `mat_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游玩地点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`mat_id`) USING BTREE,
  INDEX `FK_Reference_2`(`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mat
-- ----------------------------

-- ----------------------------
-- Table structure for mat_reply
-- ----------------------------
DROP TABLE IF EXISTS `mat_reply`;
CREATE TABLE `mat_reply`  (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '申请id',
  `mat_id` int(11) NULL DEFAULT NULL COMMENT '结伴游id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `reply_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请内容',
  `create_time` datetime(0) NOT NULL COMMENT '申请时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '0未处理，1通过，2拒绝',
  PRIMARY KEY (`reply_id`) USING BTREE,
  INDEX `FK_Reference_3`(`mat_id`) USING BTREE,
  INDEX `FK_Reference_4`(`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`mat_id`) REFERENCES `mat` (`mat_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mat_reply
-- ----------------------------

-- ----------------------------
-- Table structure for tourim_strategy
-- ----------------------------
DROP TABLE IF EXISTS `tourim_strategy`;
CREATE TABLE `tourim_strategy`  (
  `strategy_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '攻略id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `strategy_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '攻略标题',
  `strategy_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '攻略内容',
  `strategy_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旅游路线',
  `strategy_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '攻略图片',
  `is_show` int(11) NULL DEFAULT NULL COMMENT '0隐藏，1显示',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旅游城市',
  `strategy_likes` int(11) NULL DEFAULT NULL COMMENT '喜欢数',
  `strategy_collections` int(11) NULL DEFAULT NULL COMMENT '收藏数',
  `strategy_shares` int(11) NULL DEFAULT NULL COMMENT '分享数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`strategy_id`) USING BTREE,
  INDEX `FK_Reference_1`(`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tourim_strategy
-- ----------------------------
INSERT INTO `tourim_strategy` VALUES (4, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', '1d', 1, '武汉', 1, NULL, NULL, '2020-11-20 11:32:51', '2020-11-20 21:01:25');
INSERT INTO `tourim_strategy` VALUES (5, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', 'sad', 1, '武汉', 2, NULL, NULL, '2020-11-20 11:35:55', '2020-11-20 21:01:27');
INSERT INTO `tourim_strategy` VALUES (8, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', 'sad', 1, '武汉', NULL, NULL, NULL, '2020-11-21 06:12:49', '2020-11-21 06:12:49');
INSERT INTO `tourim_strategy` VALUES (9, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', 'sad', 1, '武汉', NULL, NULL, NULL, '2020-11-21 07:16:32', '2020-11-21 07:16:32');
INSERT INTO `tourim_strategy` VALUES (10, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', 'sad', 1, '武汉', NULL, NULL, NULL, '2020-11-21 07:17:39', '2020-11-21 07:17:39');
INSERT INTO `tourim_strategy` VALUES (11, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', 'sad', 1, '武汉', NULL, NULL, NULL, '2020-11-21 07:24:58', '2020-11-21 07:24:58');
INSERT INTO `tourim_strategy` VALUES (12, 1, '武汉三日游', '三天的旅程很好', '武大，华科，东湖，武汉大桥', 'sad', 1, '武汉', NULL, NULL, NULL, '2020-11-21 07:27:30', '2020-11-21 07:27:30');

-- ----------------------------
-- Table structure for tourim_strategy_appraise
-- ----------------------------
DROP TABLE IF EXISTS `tourim_strategy_appraise`;
CREATE TABLE `tourim_strategy_appraise`  (
  `appraise_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '攻略评价id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `strategy_id` int(11) NULL DEFAULT NULL COMMENT '攻略id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`appraise_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tourim_strategy_appraise
-- ----------------------------
INSERT INTO `tourim_strategy_appraise` VALUES (2, 1, 2, '12', '2020-11-21 22:24:03');
INSERT INTO `tourim_strategy_appraise` VALUES (5, 2, 1, '很不错', '2020-11-21 14:56:26');
INSERT INTO `tourim_strategy_appraise` VALUES (6, 2, 1, '很不错', '2020-11-21 15:06:57');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `telephone` int(11) NULL DEFAULT NULL COMMENT '电话号码',
  `description` int(11) NULL DEFAULT NULL COMMENT '签名',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2', '2', 2, 2, '2', NULL, NULL);

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection`  (
  `collection_id` int(11) NOT NULL COMMENT '收藏id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `strategy_id` int(11) NULL DEFAULT NULL COMMENT '攻略id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES (1, 1, 4, NULL);
INSERT INTO `user_collection` VALUES (2, 1, 5, NULL);

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : rules

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/09/2019 18:07:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `rule_content` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `rule_type` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES (1, 'Hello Test', 'rule \"Hello Test\" when message:Message(name == \"Test\") then System.out.println(\"Hello Test\"); triggerRuleNameList.add(\"Hello Test\"); end ', 'Message');
INSERT INTO `rule` VALUES (2, 'Hello 123', 'rule \"Hello 123\" when message:Message(name == \"123\") then System.out.println(\"Hello 123\"); triggerRuleNameList.add(\"Hello 123\"); end', 'Message');
INSERT INTO `rule` VALUES (3, 'Long Street', 'rule \"Long Street\" when address:Address(street == \"Long\") then System.out.println(\"Oh, Long Street\"); triggerRuleNameList.add(\"Long Street\"); end', 'Address');
INSERT INTO `rule` VALUES (4, 'Big Street', 'rule \"Big Street\" when address:Address(street == \"Big\") then System.out.println(\"Oh, Big Street\"); triggerRuleNameList.add(\"Big Street\"); end', 'Address');

SET FOREIGN_KEY_CHECKS = 1;

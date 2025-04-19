/*
Navicat MySQL Data Transfer

Source Server         : hhh
Source Server Version : 50085
Source Host           : localhost:3306
Source Database       : ssm_test2

Target Server Type    : MYSQL
Target Server Version : 50085
File Encoding         : 65001

Date: 2025-04-19 00:22:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuNO` int(25) NOT NULL default '0',
  `name` varchar(225) default NULL,
  `sex` varchar(225) default NULL,
  `nation` varchar(225) default NULL,
  `telephone` varchar(225) default NULL,
  `birthday` date default NULL,
  `address` varchar(225) default NULL,
  `photo` varchar(225) default NULL,
  `resume` varchar(225) default NULL,
  PRIMARY KEY  (`stuNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO student VALUES ('1', '张三', '男', '汉', '13800138000', '2003-05-15', '北京市海淀区', 'zhangsan.jpg', '热爱学习，积极向上');
INSERT INTO student VALUES ('2', '李四', '女', '汉', '13900139000', '2003-08-20', '上海市浦东新区', 'lisi.jpg', '性格开朗，爱好广泛');
INSERT INTO student VALUES ('3', '王五', '男', '汉', '13700137000', '2004-02-10', '广东省广州市', 'wangwu.jpg', '擅长运动，团队意识强');
INSERT INTO student VALUES ('4', '火狐', '男', '汉', '111116', '2025-04-02', '北京', '4.jpg', '乐观');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(30) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tel` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'aaa', 'aaa', '123456', '123456@aaa');
INSERT INTO user VALUES ('2', 'bbb', '$2a$10$ZvtGis0biN/MnuAwC0.Jnuv0KCDy54ObgrcfqcjsVV3SGZUOMP9Rq', '123456', '123456@2');
INSERT INTO user VALUES ('3', 'ccc', '$2a$10$zPLvwdUFCWxLmg/gbZe6heeIz26KcqSeZTyD9nOTNWwoAUkgGqpyG', '1326665', '3131@321');
INSERT INTO user VALUES ('4', 'ddd', 'ddd', 'ddd', 'ddd@55');
INSERT INTO user VALUES ('5', 'eee', 'eee', '151616', '13@161651');
INSERT INTO user VALUES ('6', 'eee', 'eee', '46541651', '1616@31');
INSERT INTO user VALUES ('7', 'xxx', 'xxx', '123456789', '1326@566');

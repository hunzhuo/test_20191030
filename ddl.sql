/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : wb_alone_tmp

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-11-10 19:38:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for org_department
-- ----------------------------
-- DROP TABLE IF EXISTS `org_department`;
CREATE TABLE `org_department` (
  `id` char(36) NOT NULL,
  `parent_id` char(36) DEFAULT NULL,
  `organization_id` varchar(36) NOT NULL,
  `inner_code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `short_name` varchar(50) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `effective_date` datetime NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `tenant_id` varchar(50) NOT NULL,
  `sys_id` varchar(50) NOT NULL,
  `principal` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `def12` varchar(50) DEFAULT NULL,
  `def16` varchar(50) DEFAULT NULL,
  `def14` varchar(50) DEFAULT NULL,
  `def13` varchar(50) DEFAULT NULL,
  `def04` varchar(50) DEFAULT NULL,
  `def10` varchar(50) DEFAULT NULL,
  `def09` varchar(50) DEFAULT NULL,
  `def05` varchar(50) DEFAULT NULL,
  `def18` varchar(50) DEFAULT NULL,
  `def15` varchar(50) DEFAULT NULL,
  `def08` varchar(50) DEFAULT NULL,
  `def19` varchar(50) DEFAULT NULL,
  `def17` varchar(50) DEFAULT NULL,
  `def11` varchar(50) DEFAULT NULL,
  `def01` varchar(50) DEFAULT NULL,
  `def20` varchar(50) DEFAULT NULL,
  `def02` varchar(50) DEFAULT NULL,
  `def07` varchar(50) DEFAULT NULL,
  `def06` varchar(50) DEFAULT NULL,
  `def03` varchar(50) DEFAULT NULL,
  `ts` datetime DEFAULT NULL,
  `dr` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for org_organization
-- ----------------------------
-- DROP TABLE IF EXISTS `org_organization`;
CREATE TABLE `org_organization` (
  `id` char(36) NOT NULL,
  `parent_id` char(36) DEFAULT NULL,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `short_name` varchar(50) DEFAULT NULL,
  `inner_code` varchar(50) DEFAULT NULL,
  `sys_id` varchar(50) DEFAULT NULL,
  `tenant_id` varchar(50) NOT NULL,
  `principal` varchar(50) NOT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `contact_address` varchar(50) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `effective_date` datetime NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `def01` varchar(50) DEFAULT NULL,
  `def04` varchar(50) DEFAULT NULL,
  `def17` varchar(50) DEFAULT NULL,
  `def05` varchar(50) DEFAULT NULL,
  `def20` varchar(50) DEFAULT NULL,
  `def10` varchar(50) DEFAULT NULL,
  `def16` varchar(50) DEFAULT NULL,
  `def19` varchar(50) DEFAULT NULL,
  `def12` varchar(50) DEFAULT NULL,
  `def13` varchar(50) DEFAULT NULL,
  `def03` varchar(50) DEFAULT NULL,
  `def09` varchar(50) DEFAULT NULL,
  `def11` varchar(50) DEFAULT NULL,
  `def06` varchar(50) DEFAULT NULL,
  `def15` varchar(50) DEFAULT NULL,
  `def08` varchar(50) DEFAULT NULL,
  `def02` varchar(50) DEFAULT NULL,
  `def07` varchar(50) DEFAULT NULL,
  `def18` varchar(50) DEFAULT NULL,
  `def14` varchar(50) DEFAULT NULL,
  `ts` datetime DEFAULT NULL,
  `dr` smallint(6) DEFAULT '0',
  `contact_phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for org_orgs
-- ----------------------------
-- DROP TABLE IF EXISTS `org_orgs`;
CREATE TABLE `org_orgs` (
  `id` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键',
  `code` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `fatherid` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '父ID',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `tenantid` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '租户ID',
  `sysid` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '系统ID',
  `innercode` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '内部编码',
  `orgtype1` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型1',
  `orgtype2` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型2',
  `orgtype3` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型3',
  `orgtype4` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型4',
  `orgtype5` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型5',
  `orgtype6` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型6',
  `orgtype7` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型7',
  `orgtype8` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型8',
  `orgtype9` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型9',
  `orgtype10` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组织类型10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for org_type
-- ----------------------------
-- DROP TABLE IF EXISTS `org_type`;
CREATE TABLE `org_type` (
  `id` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键',
  `code` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
  `tenantid` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '租户ID',
  `sysid` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '系统ID',
  `fieldname` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '组织类型名称',
  `serviceclass` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '服务接口',
  `entityclassname` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '对应实体',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- DROP TABLE IF EXISTS `ref_refinfo`;
CREATE TABLE `ref_refinfo` (
  `pk_ref` varchar(200) NOT NULL,
  `refname` varchar(300) DEFAULT NULL,
  `refcode` varchar(300) DEFAULT NULL,
  `refclass` varchar(300) DEFAULT NULL,
  `refurl` varchar(300) DEFAULT NULL,
  `md_entitypk` varchar(300) DEFAULT NULL,
  `productType` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`pk_ref`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


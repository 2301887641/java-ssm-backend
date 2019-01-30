-- ----------------------------
--  Table structure for `mall_user`  用户表
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) NOT NULL COMMENT '角色0-管理员,1-普通用户',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `mall_user` VALUES ('1', 'admin', '427338237BD929443EC5D48E24FD2B1A', 'admin@happymmall.com', '13800138000', '问题', '答案', '1', '2016-11-06 16:56:45', '2017-04-04 19:27:36'), ('13', 'geely', '08E9A6EA287E70E7E3F7C982BF7923AC', 'geely@happymmall.com', '13800138000', '问题', '答案', '0', '2016-11-19 22:19:25', '2016-11-19 22:19:25'), ('17', 'rosen', '095AC193FE2212EEC7A93E8FEFF11902', 'rosen1@happymmall.com', '13800138000', '问题', '答案', '0', '2017-03-17 10:51:33', '2017-04-09 23:13:26'), ('21', 'soonerbetter', 'DE6D76FE7C40D5A1A8F04213F2BEFBEE', 'test06@happymmall.com', '13800138000', '105204', '105204', '0', '2017-04-13 21:26:22', '2017-04-13 21:26:22');


-- ----------------------------
-- Table structure for mall_dict   字典表
-- ----------------------------
DROP TABLE IF EXISTS mall_dict;
CREATE TABLE mall_dict (
	id INT(11) NOT NULL AUTO_INCREMENT,
	create_time timestamp  not null  default CURRENT_TIMESTAMP,
	update_time timestamp  not null  default CURRENT_TIMESTAMP,
  type_code varchar(20) not null default "" comment "数据字典类别代码",
  type_name varchar(64) not null default "" comment "数据字典类别名称",
  item_name varchar(64) not null default "" comment "数据字典项目名称",
  item_code varchar(20) not null default "" comment "数据字典项目(可为空)",
  description varchar(64) default "" comment "备注",
  enable char(1) default 1 comment "1:启用 2:停用",
  priority int(10) default 0 comment "排序字段",
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mall_verify_code   验证码表
-- ----------------------------
DROP TABLE IF EXISTS mall_verify_code;
CREATE TABLE mall_verify_code (
	id INT(11) NOT NULL AUTO_INCREMENT,
	create_time timestamp  not null  default CURRENT_TIMESTAMP,
	update_time timestamp  not null  default CURRENT_TIMESTAMP,
  type varchar(50) not null default "" comment "验证码业务类型",
  template varchar(150) not null default "" comment "模板内容",
  template_name varchar(30) not null default "" comment "模板名称",
	PRIMARY KEY (id),
	UNIQUE KEY `type_unique` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `mall`.`mall_verify_code` (`id`, `create_time`, `update_time`, `type`, `template`, `template_name`) VALUES (1, '2019-01-30 03:12:39', '2019-01-30 03:12:41', '1', '注册短信', '短信注册');

-- ----------------------------
-- Table structure for mall_verify_code_record   验证码记录表
-- ----------------------------
DROP TABLE IF EXISTS mall_verify_code_record;
CREATE TABLE mall_verify_code_record (
	id INT(11) NOT NULL AUTO_INCREMENT,
	create_time timestamp  not null  default CURRENT_TIMESTAMP,
	update_time timestamp  not null  default CURRENT_TIMESTAMP,
	count int(10) default 1 comment "发送记录数",
	phone char(11) not null default 0 comment "手机号",
  code char(6) not null default "" comment "已发送验证码",
  type varchar(20) not null default "" comment "验证码业务类型",
  send_time timestamp not null  default CURRENT_TIMESTAMP comment "验证码发送时间 以这个时间为准因为发送和过期是同时插入实体的",
  expire_time timestamp not null  default CURRENT_TIMESTAMP comment "验证码过期时间",
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
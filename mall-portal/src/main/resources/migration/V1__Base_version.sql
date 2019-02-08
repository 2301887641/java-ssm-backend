-- ----------------------------
--  Table structure for `mall_user`  用户表
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `username` varchar(50) NOT NULL COMMENT '用户名 就是手机号',
  `password` varchar(64) NOT NULL COMMENT '用户密码，MD5加密或sha256散列加密',
  `email` varchar(50) DEFAULT NULL,
  `is_admin` tinyint(1) NOT NULL default 1 COMMENT '是否管理员 1不是 2是',
  create_time timestamp  not null  default CURRENT_TIMESTAMP,
	update_time timestamp  not null  default CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  type tinyint(1) not null default 0 comment "验证码业务类型",
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
	target char(11) not null comment "目标对象 手机号或邮箱",
  code char(6) not null default "" comment "已发送验证码",
  type tinyint(1) not null default 0 comment "验证码业务类型",
  send_time timestamp not null  default CURRENT_TIMESTAMP comment "验证码发送时间 以这个时间为准因为发送和过期是同时插入实体的",
  expire_time timestamp not null  default CURRENT_TIMESTAMP comment "验证码过期时间",
  is_checked tinyint(1) not null default 0 comment "是否已验证 0没有 1已验证",
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
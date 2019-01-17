-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS mall_user;
CREATE TABLE mall_user (
	id INT(11) NOT NULL AUTO_INCREMENT,
	create_time timestamp  not null  default CURRENT_TIMESTAMP,
	update_time timestamp  not null  default CURRENT_TIMESTAMP,
	mobile CHAR(11)  DEFAULT '' comment '手机号',
	username VARCHAR(36)  DEFAULT '' comment '账号',
	email VARCHAR(46)  DEFAULT '' comment '邮箱',
	password VARCHAR(64)  DEFAULT '' comment '密码',
	salt VARCHAR(32) DEFAULT '' comment '密码盐',
  avatar VARCHAR(100) DEFAULT '' comment '头像',
	administrator TINYINT(1) DEFAULT 0 comment '是否超级管理员 1超管',
	status TINYINT(4) DEFAULT 0 comment '账号状态 0正常',
	register_ip CHAR(15)  DEFAULT '' comment '登陆ip',
	PRIMARY KEY (id),
	UNIQUE KEY (mobile),
	UNIQUE KEY (username),
	UNIQUE KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO mall.mall_user (id, mobile, username, email, password, salt, avatar, administrator, status, register_ip) VALUES (1,'15865658745', 'admin', '15478541254@126.com', '$2a$10$AXJY/pLHIJKk3c8F5L6sfeaS6ypLI0IpWfBhYfxepJerb0ZO3xMt2', 'sdfsdf', 'dfgdgdfg', 1, 0, '192.168.2.12');

-- ----------------------------
-- Table structure for mall_dict
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
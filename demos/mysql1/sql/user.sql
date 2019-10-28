CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键, 无业务意义',
  `card_id` varchar(45) NOT NULL COMMENT '身份证号',
  `phone` varchar(15) NOT NULL COMMENT '手机号',
  `name` varchar(45) NOT NULL,
  `age` int(4) NOT NULL DEFAULT 0,
  `remark` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `card_id_UNIQUE` (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表'

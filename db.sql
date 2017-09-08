/**创建访问日志存储表*/
DROP TABLE IF EXISTS `access_log`;
CREATE TABLE `access_log` (
  `id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '访问时间',
  `province` varchar(50) COMMENT '所在省',
  `url` varchar(2000) COMMENT '当前页面url',
  `host` varchar(50) COMMENT '当前页面域名如http://baidu.com',
  `referrer_host` varchar(50) COMMENT '上一页面域名',
  `referer` varchar(2000) COMMENT '引用页面url,HTTP_REFERER',
  `page_title` varchar(255) COMMENT '页面标题',
  `meta_keyword` varchar(255) COMMENT '页面关键字',
  `meta_description` varchar(255) COMMENT '页面摘要',
  `browser` varchar(50) COMMENT '浏览器',
  `language` varchar(50) COMMENT '当前浏览器语言',
  `os` varchar(50) COMMENT '操作系统',
  `screen_width` int(4) COMMENT '屏幕分辩率宽度',
  `screen_height` int(4) COMMENT '屏幕分辩率高度',
  `hostname` varchar(50) COMMENT 'hostname',
  `mac_address` varchar(50) COMMENT 'mac地址',
  `user_id` varchar(50) COMMENT '用户id',
  `date_yyyy` int(4) NOT NULL COMMENT '年',
  `date_mm` int(2) NOT NULL COMMENT '月',
  `date_dd` int(2) NOT NULL COMMENT '日',
  `date_hh` int(2) NOT NULL COMMENT '时',
  `date_minute` int(2) NOT NULL COMMENT '分',
  `date_ss` int(2) NOT NULL COMMENT '秒',
  `ip` varchar(255) COMMENT '访问ip',
  `city` varchar(50) COMMENT '所在市',
  `county` varchar(50) COMMENT '县/旗',
  `street` varchar(255) COMMENT '街道',
  `street_number` varchar(255) COMMENT '门址',
  `address` varchar(500) COMMENT '简要地址',
  `address_detail` varchar(1000) COMMENT '详细地址信息',
  `city_code` int(10) COMMENT '城市编码',
  `color_depth` int(2) COMMENT '颜色深度',
  `cookie_enabled` int(1) DEFAULT '0' COMMENT '浏览器是否启用cookie\\0否1是',
  `flash_enabled` int(1) DEFAULT '0' COMMENT '浏览器是否安装flash插件\\0否1是',
  `flash_version` int(1) DEFAULT '0' COMMENT 'flash版本',
  `java_enabled` int(1) DEFAULT '0' COMMENT '来检测当前浏览器是否支持 Java小程序applet\\0否1是',
  `content_id` varchar(50) COMMENT '内容id',
  `site_id` varchar(50) COMMENT '站点id',
  `site_name` varchar(255) COMMENT '站点名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

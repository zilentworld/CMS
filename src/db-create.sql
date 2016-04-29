CREATE TABLE `cms_role` (
  `cms_role_code` varchar(5) NOT NULL DEFAULT '',
  `cms_role_desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cms_role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cms_templates` (
  `template_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(20) NOT NULL,
  `webpath` varchar(100) DEFAULT NULL,
  `template_img_name` varchar(100) DEFAULT NULL,
  `default_banner_img` varchar(100) DEFAULT NULL,
  `default_footer_img` varchar(100) DEFAULT NULL,
  `default_background_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user` (
  `cms_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_username` varchar(50) NOT NULL,
  `cms_password` varchar(50) NOT NULL,
  `cms_user_type_code` varchar(15) NOT NULL,
  `cms_register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cms_user_id`),
  KEY `fk_cms_user_1_idx` (`cms_user_type_code`),
  CONSTRAINT `fk_cms_user_type_code` FOREIGN KEY (`cms_user_type_code`) REFERENCES `cms_user_type` (`cms_user_type_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user_role` (
  `cms_user_type_code` varchar(5) DEFAULT NULL,
  `role_code` varchar(5) DEFAULT NULL,
  KEY `fk_cms_user_type_code` (`cms_user_type_code`),
  CONSTRAINT `cms_user_role_ibfk_1` FOREIGN KEY (`cms_user_type_code`) REFERENCES `cms_user_type` (`cms_user_type_code`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user_site` (
  `cms_user_site_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_id` bigint(20) NOT NULL,
  `blog_url` varchar(50) NOT NULL,
  `blog_template` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_published` int(1) DEFAULT NULL,
  PRIMARY KEY (`cms_user_site_id`),
  KEY `fk_cms_user_id` (`cms_user_id`),
  CONSTRAINT `cms_user_site_ibfk_1` FOREIGN KEY (`cms_user_id`) REFERENCES `cms_user` (`cms_user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user_type` (
  `cms_user_type_code` varchar(10) NOT NULL DEFAULT '',
  `cms_user_type_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cms_user_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `site_comment` (
  `site_comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `site_user_id` bigint(20) NOT NULL,
  `site_post_id` bigint(20) DEFAULT NULL,
  `site_comment_content` varchar(1000) DEFAULT NULL,
  `comment_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cms_user_site_id` bigint(20) NOT NULL,
  PRIMARY KEY (`site_comment_id`),
  KEY `fk_site_user_id` (`site_user_id`),
  KEY `fk_site_post_id` (`site_post_id`),
  CONSTRAINT `site_comment_ibfk_1` FOREIGN KEY (`site_user_id`) REFERENCES `site_user` (`site_user_id`) ON UPDATE CASCADE,
  CONSTRAINT `site_comment_ibfk_2` FOREIGN KEY (`site_post_id`) REFERENCES `site_post` (`site_post_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE TABLE `site_post` (
  `site_post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_site_id` bigint(20) NOT NULL,
  `site_user_id` bigint(20) DEFAULT NULL,
  `site_post_title` varchar(100) DEFAULT NULL,
  `site_post_content` varchar(50000) DEFAULT NULL,
  `site_post_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`site_post_id`),
  KEY `fk_site_user_id` (`site_user_id`),
  CONSTRAINT `site_post_ibfk_1` FOREIGN KEY (`site_user_id`) REFERENCES `site_user` (`site_user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

CREATE TABLE `site_settings` (
  `site_settings_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_site_id` bigint(20) DEFAULT NULL,
  `banner_img` varchar(100) DEFAULT NULL,
  `background_img` varchar(100) DEFAULT NULL,
  `footer_img` varchar(100) DEFAULT NULL,
  `preview_results` int(11) DEFAULT NULL,
  PRIMARY KEY (`site_settings_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

CREATE TABLE `site_user` (
  `site_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_site_id` bigint(20) NOT NULL,
  `site_user_username` varchar(50) DEFAULT NULL,
  `site_user_password` varchar(50) DEFAULT NULL,
  `site_register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_admin` int(1) DEFAULT '0',
  PRIMARY KEY (`site_user_id`),
  KEY `fk_cms_user_site_id` (`cms_user_site_id`),
  CONSTRAINT `site_user_ibfk_1` FOREIGN KEY (`cms_user_site_id`) REFERENCES `cms_user_site` (`cms_user_site_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

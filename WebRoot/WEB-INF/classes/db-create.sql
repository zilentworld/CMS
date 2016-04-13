DROP TABLE IF EXISTS cms_user;
DROP TABLE IF EXISTS cms_role;
DROP TABLE IF EXISTS cms_user_type;
DROP TABLE IF EXISTS cms_user_role;
DROP TABLE IF EXISTS cms_user_site;
DROP TABLE IF EXISTS site_comment;
DROP TABLE IF EXISTS site_post;
DROP TABLE IF EXISTS site_user;

CREATE TABLE `cms_role` (
  `cms_role_code` varchar(5) DEFAULT NULL,
  `cms_role_desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cms_role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `cms_user` (
  `cms_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_username` varchar(50) NOT NULL,
  `cms_password` varchar(50) NOT NULL,
  `cms_user_type_code` varchar(5) NOT NULL,
  `cms_register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cms_role_code` varchar(5),
  PRIMARY KEY (`cms_user_id`),
   FOREIGN KEY fk_cms_role_code(cms_role_code)
   REFERENCES cms_role(cms_role_code)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user_type` (
  `cms_user_type_code` varchar(5) DEFAULT NULL,
  `cms_user_type_desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cms_user_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user_role` (
  `cms_user_type_code` varchar(5) DEFAULT NULL,
  `role_code` varchar(5) DEFAULT NULL,
   FOREIGN KEY fk_cms_user_type_code(cms_user_type_code)
   REFERENCES cms_user_type(cms_user_type_code)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cms_user_site` (
  `cms_user_site_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_id` bigint(20) NOT NULL,
  `cms_url` varchar(50) NOT NULL,
  `cms_theme` varchar(10) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cms_user_site_id`),
   FOREIGN KEY fk_cms_user_id(cms_user_id)
   REFERENCES cms_user(cms_user_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `site_user` (
  `site_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_site_id` bigint(20) NOT NULL,
  `site_user_username` varchar(50) DEFAULT NULL,
  `site_user_password` varchar(50) DEFAULT NULL,
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`site_user_id`),
   FOREIGN KEY fk_cms_user_site_id(cms_user_site_id)
   REFERENCES cms_user_site(cms_user_site_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `site_post` (
  `site_post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cms_user_site_id` bigint(20) NOT NULL,
  `site_user_id` bigint(20) DEFAULT NULL,
  `site_title` varchar(100) DEFAULT NULL,
  `site_content` varchar(50000) DEFAULT NULL,
  `post_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`site_post_id`),
   FOREIGN KEY fk_site_user_id(site_user_id)
   REFERENCES site_user(site_user_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `site_comment` (
  `site_comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `site_user_id` bigint(20) NOT NULL,
  `site_post_id` bigint(20) DEFAULT NULL,
  `site_comment` varchar(1000) DEFAULT NULL,
  `comment_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`site_comment_id`),
   FOREIGN KEY fk_site_user_id(site_user_id)
   REFERENCES site_user(site_user_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT,
   FOREIGN KEY fk_site_post_id(site_post_id)
   REFERENCES site_post(site_post_id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

My	
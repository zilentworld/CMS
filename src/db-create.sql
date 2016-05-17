CREATE TABLE cms_role
(
  cms_role_code VARCHAR(5) PRIMARY KEY NOT NULL,
  cms_role_desc VARCHAR(20)
);
CREATE TABLE cms_templates
(
  template_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  template_name VARCHAR(20) NOT NULL,
  webpath VARCHAR(100),
  template_img_name VARCHAR(100),
  default_banner_img VARCHAR(100),
  default_footer_img VARCHAR(100),
  default_background_img VARCHAR(100),
  template_baselayout VARCHAR(200),
  css_file VARCHAR(100)
);
CREATE TABLE cms_user
(
  cms_user_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cms_username VARCHAR(50) NOT NULL,
  cms_password VARCHAR(50) NOT NULL,
  cms_user_type_code VARCHAR(15) NOT NULL,
  cms_register_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  age INT(11),
  is_enabled INT(1) DEFAULT '1',
  first_name VARCHAR(50),
  middle_name VARCHAR(50),
  last_name VARCHAR(50),
  gender VARCHAR(10),
  CONSTRAINT fk_cms_user_type_code FOREIGN KEY (cms_user_type_code) REFERENCES cms_user_type (cms_user_type_code)
);
CREATE INDEX fk_cms_user_1_idx ON cms_user (cms_user_type_code);
CREATE TABLE cms_user_role
(
  cms_user_type_code VARCHAR(5),
  role_code VARCHAR(5),
  CONSTRAINT cms_user_role_ibfk_1 FOREIGN KEY (cms_user_type_code) REFERENCES cms_user_type (cms_user_type_code)
);
CREATE INDEX fk_cms_user_type_code ON cms_user_role (cms_user_type_code);
CREATE TABLE cms_user_site
(
  cms_user_site_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cms_user_id BIGINT(20) NOT NULL,
  blog_url VARCHAR(50) NOT NULL,
  blog_template VARCHAR(10) NOT NULL,
  create_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  is_published INT(1) DEFAULT '0',
  CONSTRAINT cms_user_site_ibfk_1 FOREIGN KEY (cms_user_id) REFERENCES cms_user (cms_user_id)
);
CREATE INDEX fk_cms_user_id ON cms_user_site (cms_user_id);
CREATE TABLE cms_user_type
(
  cms_user_type_code VARCHAR(10) PRIMARY KEY NOT NULL,
  cms_user_type_desc VARCHAR(50)
);
CREATE TABLE site_links
(
  site_link_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  site_link_name VARCHAR(50),
  site_link_action VARCHAR(50)
);
CREATE TABLE site_links_permission
(
  cms_user_site_id BIGINT(20),
  site_link_id BIGINT(20),
  is_enabled INT(1) DEFAULT '0',
  permission_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT
);
CREATE TABLE site_settings
(
  site_settings_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cms_user_site_id BIGINT(20),
  banner_img VARCHAR(100),
  background_img VARCHAR(100),
  footer_img VARCHAR(100),
  preview_results INT(11)
);
CREATE TABLE site_user
(
  site_user_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cms_user_site_id BIGINT(20) NOT NULL,
  site_user_username VARCHAR(50),
  site_user_password VARCHAR(50),
  site_register_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  is_admin INT(1) DEFAULT '0',
  CONSTRAINT site_user_ibfk_1 FOREIGN KEY (cms_user_site_id) REFERENCES cms_user_site (cms_user_site_id)
);
CREATE INDEX fk_cms_user_site_id ON site_user (cms_user_site_id);
CREATE TABLE site_comment
(
  site_comment_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  site_user_id BIGINT(20) NOT NULL,
  site_post_id BIGINT(20),
  site_comment_content VARCHAR(1000),
  comment_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  cms_user_site_id BIGINT(20) NOT NULL,
  CONSTRAINT site_comment_ibfk_1 FOREIGN KEY (site_user_id) REFERENCES site_user (site_user_id),
  CONSTRAINT site_comment_ibfk_2 FOREIGN KEY (site_post_id) REFERENCES site_post (site_post_id)
);
CREATE INDEX fk_site_post_id ON site_comment (site_post_id);
CREATE INDEX fk_site_user_id ON site_comment (site_user_id);
CREATE TABLE site_post
(
  site_post_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cms_user_site_id BIGINT(20) NOT NULL,
  site_user_id BIGINT(20),
  site_post_title VARCHAR(100),
  site_post_content VARCHAR(50000),
  site_post_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
  CONSTRAINT site_post_ibfk_1 FOREIGN KEY (site_user_id) REFERENCES site_user (site_user_id)
);
CREATE INDEX fk_site_user_id ON site_post (site_user_id);

INSERT INTO cms.cms_user_type (cms_user_type_code, cms_user_type_desc) VALUES ('cms_admin', 'cms admin user');
INSERT INTO cms.cms_user_type (cms_user_type_code, cms_user_type_desc) VALUES ('cms_user', 'cms user');

INSERT INTO cms.cms_templates (template_name, webpath, template_img_name, default_banner_img, default_footer_img, default_background_img, template_baselayout) VALUES ('Template1', '/images/', 'template1.png', 'banner1.jpg', 'footer1.png', null, 'template1.jsp');
INSERT INTO cms.cms_templates (template_name, webpath, template_img_name, default_banner_img, default_footer_img, default_background_img, template_baselayout) VALUES ('Template2', '/images/', 'template2.png', 'banner2.jpg', 'footer2.png', null, 'template2.jsp');
INSERT INTO cms.cms_templates (template_name, webpath, template_img_name, default_banner_img, default_footer_img, default_background_img, template_baselayout) VALUES ('Template3', '/images/', 'template3.png', 'banner3.jpg', 'footer3.png', null, 'template3.jsp');

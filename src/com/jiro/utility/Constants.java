package com.jiro.utility;

public final class Constants {

    //CMS Paths
    public static final String CMS_PATH_TO_PENDING = "/home/dev-pc/CMS/pending/";
    public static final String CMS_PATH_TO_SITE = "/WEB-INF/jsp/sitePages/";
    public static final String CMS_PATH_TO_TEMPLATES = "/WEB-INF/jsp/templates/";
    public static final String CMS_PATH_TO_TILES = "/WEB-INF/tiles.xml";
    public static final String CMS_PATH_TO_WEBAPPS = "/opt/tomcat/webapps/";
    
    //CMS Session Attributes
    public static final String CMS_SESSION_CMS_USER = "cms_user";
    public static final String CMS_SESSION_USERNAME = "cms_username";
    public static final String CMS_SESSION_USER_TYPE_CODE = "cms_user_type_code";
    public static final String CMS_SESSION_CMS_TEMPLATE = "cms_template";
    public static final String CMS_SESSION_BLOG_URL = "blog_site_url";
    
    //Site Session Attributes
    public static final String SITE_SESSION_MAP_VARIABLE = "siteMapVars";
    public static final String SITE_SESSION_SITE_USER = "siteUser";
    public static final String SITE_SESSION_SITE_USER_ID = "siteUserId";
    public static final String SITE_SESSION_SITE_USER_NAME = "siteUsername";
    
    //Error Messages for CMS
    public static final String CMS_ERROR_USERNAME_REQUIRED = "Username is required";
    public static final String CMS_ERROR_USERNAME_SHORT = "Username is too short";
    public static final String CMS_ERROR_USERNAME_TAKEN = "Username has been taken";
    public static final String CMS_ERROR_USERNAME_NOT_EXIST = "Username does not exist";
    public static final String CMS_ERROR_INVALID_LOGIN = "Invalid username/password.";
    public static final String CMS_ERROR_USERNAME_INVALID_CHAR = "Username contains invalid characters";
    public static final String CMS_ERROR_PASSWORD_REQUIRED = "Password is required";
    public static final String CMS_ERROR_REPEATPASS_REQUIRED = "Repeat Password is required";
    public static final String CMS_ERROR_PASS_NOTSAME = "Password must be the same";
    public static final String CMS_ERROR_GENERIC_ERROR = "An error occured. Kindly restart the process";
    public static final String CMS_ERROR_GENERIC_REGISTER = "An error occurred. Kindly register again";
    public static final String CMS_ERROR_BLOG_URL_TAKEN = "Site name is taken";
    
    //Error Messages for SITE
    public static final String SITE_ERROR_USERNAME_REQUIRED = "Username is required";
    public static final String SITE_ERROR_USERNAME_SHORT = "Username is too short";
    public static final String SITE_ERROR_USERNAME_TAKEN = "Username has been taken";
    public static final String SITE_ERROR_USERNAME_NOT_EXIST = "Username does not exist";
    public static final String SITE_ERROR_INVALID_LOGIN = "Invalid username/password.";
    public static final String SITE_ERROR_USERNAME_INVALID_CHAR = "Username contains invalid characters";
    public static final String SITE_ERROR_PASSWORD_REQUIRED = "Password is required";
    public static final String SITE_ERROR_REPEATPASS_REQUIRED = "Repeat Password is required";
    public static final String SITE_ERROR_PASS_NOTSAME = "Password must be the same";
    public static final String SITE_ERROR_GENERIC_ERROR = "An error occured. Kindly restart the process";
    public static final String SITE_ERROR_GENERIC_REGISTER = "An error occurred. Kindly register again";
    public static final String SITE_ERROR_BLOG_URL_TAKEN = "Site name is taken";
    public static final String SITE_ERROR_NEW_POST_TITLE_EMPTY = "Title must not be empty";
    public static final String SITE_ERROR_NEW_POST_CONTENT_EMPTY = "Content must not be empty";
    public static final String SITE_ERROR_NEW_POST_USER_EMPTY = "An error occured, kindly relog.";
    public static final String SITE_ERROR_NEW_POST_ERROR = "An error occured, kindly create a new post again";
        
    //CMS Variables
    public static final String CMS_DEFAULT_USER_TYPE = "cms_user";
    
    //Integer values for CMS
    public static final int CMS_USERNAME_MIN_LENGTH = 5;
    
    //CMS Regex
    public static final String REGEX_USERNAME = "^[a-z0-9_-]{3,15}$";
    
    private Constants() {}

}
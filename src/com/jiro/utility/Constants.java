package com.jiro.utility;

public final class Constants {
    
    //CMS Session Attributes
    public static final String CMS_SESSION_CMS_USER = "cms_user";
    public static final String CMS_SESSION_USERNAME = "cms_username";
    public static final String CMS_SESSION_USER_TYPE_CODE = "cms_user_type_code";
    public static final String CMS_SESSION_CMS_TEMPLATE = "cms_template";
    
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
    
    //Integer values for CMS
    public static final int CMS_USERNAME_MIN_LENGTH = 5;
    
    //CMS Regex
    public static final String CMS_REGEX_USERNAME = "^[a-z0-9_-]{3,15}$";
    
    private Constants() {}

}
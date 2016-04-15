package com.jiro.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.CmsUser;
import com.jiro.service.CmsUserService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsUser cmsUser;
    private CmsUserService cmsUserService;
    private Map<String, Object> sessionMap;
    
    public CmsUser getCmsUser() {
        return cmsUser;
    }

    public void setCmsUser(CmsUser cmsUser) {
        this.cmsUser = cmsUser;
    }

    public CmsUserService getCmsUserService() {
        return cmsUserService;
    }

    public void setCmsUserService(CmsUserService cmsUserService) {
        this.cmsUserService = cmsUserService;
    }
    
    @Override
    public String execute() throws Exception {
        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUser);
        sessionMap.put(Constants.CMS_SESSION_USERNAME, cmsUser.getCmsUsername());
        sessionMap.put(Constants.CMS_SESSION_USER_TYPE_CODE, cmsUser.getCmsUserTypeCode());
        return "SUCCESS";
    }

    @Override
    public void validate() {
        if(StringUtils.isEmpty(cmsUser.getCmsUsername())) {
            addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_USERNAME_REQUIRED);
        } else if(StringUtils.isEmpty(cmsUser.getCmsPassword())) {
            addFieldError("cmsUser.cmsPassword", Constants.CMS_ERROR_PASSWORD_REQUIRED);
        } else if(!cmsUserService.checkExistingCmsUser(cmsUser)) {
            addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_USERNAME_NOT_EXIST);
            cmsUser.setCmsPassword("");
        } else if(!cmsUserService.checkLogin(cmsUser)) {
            addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_INVALID_LOGIN);
            cmsUser.setCmsPassword("");            
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}

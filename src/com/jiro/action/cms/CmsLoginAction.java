package com.jiro.action.cms;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.cms.CmsUser;
import com.jiro.service.cms.CmsUserService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class CmsLoginAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsUser cmsUser;
    private CmsUserService cmsUserService;
    private String cmsTemplateId;
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
    
    
    public String getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(String cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }
    
    public String cmsLoginAction() {
        cmsUser = cmsUserService.getByLogin(cmsUser);
        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUser);
        System.out.println("cmsLoginAction:cmsUsername:"+cmsUser.getCmsUsername());
        
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        cmsUser = cmsUserService.getByLogin(cmsUser);
        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUser);
        
        return SUCCESS;
    }
    
    @SkipValidation
    public String showCmsLogin() {
        return SUCCESS;
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
//        try {
//            Long.parseLong(cmsTemplateId);
//        } catch (Exception e) {
//            addFieldError("cmsUserRegister.cmsUsername", Constants.CMS_ERROR_GENERIC_ERROR);
//        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}

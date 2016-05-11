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
    private Map<String, Object> sessionMap;
    private String sourcePage;
    private String cmsTemplateId;
    private String urlName;

    public String getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(String cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(String sourcePage) {
        this.sourcePage = sourcePage;
    }

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

    public String cmsLoginAction() {
        cmsUser = cmsUserService.getByLogin(cmsUser);
        if(cmsUser == null)
            return ERROR;

        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUser);
        System.out.println("cmsLoginAction:cmsUsername:"+cmsUser.getCmsUsername());
        
        return SUCCESS;
    }

    @SkipValidation
    public String processLogout() {
        cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
        if(cmsUser != null) {
            sessionMap.remove(Constants.CMS_SESSION_CMS_USER);
        }

        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        cmsUser = cmsUserService.getByLogin(cmsUser);
        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUser);
        System.out.println("cmsLoginAction:execute:sourcePage:"+sourcePage);
        System.out.println("cmsLoginAction:execute:urlName:"+urlName);

        return SUCCESS;
    }
    
    @SkipValidation
    public String showCmsLogin() {
        return SUCCESS;
    }

    @Override
    public void validate() {
        System.out.println("cmsLoginAction:validate:sourcePage:"+sourcePage);
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
        cmsUser = cmsUserService.getByLogin(cmsUser);

        if("UserSites".equals(sourcePage) && "cms_admin".equals(cmsUser.getCmsUserType().getCmsUserTypeCode())) {
            addFieldError("cmsUser.cmsUsername", "Cannot use admin account");
            cmsUser.setCmsPassword("");
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}

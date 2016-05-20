package com.jiro.action.cms;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.cms.CmsUser;
import com.jiro.service.cms.CmsUserService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CmsLoginAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private CmsUserService cmsUserService;
    private CmsUser cmsUser;
    private Map<String, Object> sessionMap;
    private String sourcePage;
    private String cmsTemplateId;
    private String urlName;

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
        boolean failed = false;
        if(StringUtils.isEmpty(cmsUser.getCmsUsername())) {
            addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_USERNAME_REQUIRED);
            failed = true;
        } else if(StringUtils.isEmpty(cmsUser.getCmsPassword())) {
            addFieldError("cmsUser.cmsPassword", Constants.CMS_ERROR_PASSWORD_REQUIRED);
            failed = true;
        } else if(!cmsUserService.checkExistingCmsUser(cmsUser)) {
            addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_USERNAME_NOT_EXIST);
            cmsUser.setCmsPassword("");
            failed = true;
        }
        if(!failed) {
            boolean cont = cmsUserService.checkLoginUserPass(cmsUser);
            if (!cont) {
                addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_INVALID_LOGIN);
                cmsUser.setCmsPassword("");
            } else {
                cmsUser = cmsUserService.getByLogin(cmsUser);
                if (cmsUser.getIsEnabled() == 0) {
                    addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_ACCT_DISABLED);
                    cmsUser.setCmsPassword("");
                }

                if (("UserSites".equals(sourcePage) || "TemplateList".equals(sourcePage) ) && "cms_admin".equals(cmsUser.getCmsUserType().getCmsUserTypeCode())) {
                    addFieldError("cmsUser.cmsUsername", Constants.CMS_ERROR_ADMIN_CANNOT);
                    cmsUser.setCmsPassword("");
                }
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

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
    
}

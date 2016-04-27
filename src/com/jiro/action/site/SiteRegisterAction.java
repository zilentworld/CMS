package com.jiro.action.site;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SiteUserService;
import com.jiro.utility.Constants;
import com.jiro.utility.Utility;

public class SiteRegisterAction extends SiteAbstractAction {
    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SiteUserService siteUserService;
    private String repeatPassword;
    private SiteUser siteUser;
    
    public SiteUserService getSiteUserService() {
        return siteUserService;
    }

    public void setSiteUserService(SiteUserService siteUserService) {
        this.siteUserService = siteUserService;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }

    @SkipValidation
    public String showRegister() {
        String nextAction = "siteRegister" + getSiteTemplate();
        setNextAction(nextAction);
        System.out.println("showRegister:"+nextAction);
        siteUser = new SiteUser();
        System.out.println("siteRegisterAction:showRegister:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("SiteReg:EXEC");
        System.out.println("exec:nextAction:"+getNextAction());
        String blogUrl = getBlogSiteUrl();
        System.out.println("BLOGURL:"+blogUrl);
        System.out.println("BEFORE SETCMSUSERSITE");
        
        siteUser.setCmsUserSite(getCmsUserSiteService().getByUrl(blogUrl));
        
        System.out.println("AFTER SETCMSUSERSITE");
        if(!siteUserService.saveNewUser(siteUser)) {
            return ERROR;
        }
        
        getSessionMap().put(Constants.SITE_SESSION_SITE_USER_NAME + getBlogSiteUrl(), siteUser.getSiteUserUsername());
        getSessionMap().put(Constants.SITE_SESSION_SITE_USER_ID + getBlogSiteUrl(), siteUser.getSiteUserId());
        
        String nextAction = "home" + getSiteTemplate();
        setNextAction(nextAction);
        System.out.println("exec:nextAction:"+nextAction);
        System.out.println("siteRegisterAction:execute:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }

    @Override
    public void validate() {
        setNextAction("siteRegister" + getSiteTemplate());
        
        if(StringUtils.isEmpty(siteUser.getSiteUserUsername())) {
            System.out.println("1");
            addFieldError("siteUser.siteUserUsername", Constants.SITE_ERROR_USERNAME_REQUIRED);
        } else if(StringUtils.isEmpty(siteUser.getSiteUserPassword())) {
            System.out.println("2");
            addFieldError("siteUser.siteUserPassword", Constants.SITE_ERROR_PASSWORD_REQUIRED);
        } else if(StringUtils.isEmpty(repeatPassword)) {
            resetPasswordFields();
            addFieldError("repeatPassword", Constants.SITE_ERROR_REPEATPASS_REQUIRED);
        } else if (!Utility.checkStringByRegex(siteUser.getSiteUserUsername(), Constants.REGEX_USERNAME)) {
            addFieldError("siteUser.siteUserUsername", Constants.SITE_ERROR_USERNAME_INVALID_CHAR);
        } else if(!repeatPassword.equals(siteUser.getSiteUserPassword())) {
            resetPasswordFields();
            addFieldError("siteUser.siteUserPassword", Constants.SITE_ERROR_PASS_NOTSAME);
            addFieldError("repeatPassword", Constants.SITE_ERROR_PASS_NOTSAME);
        } else if(siteUserService.checkLoginExists(siteUser.getSiteUserUsername(), siteUser.getSiteUserPassword(), getBlogSiteUrl())) {
            addFieldError("siteUser.siteUserUsername", Constants.SITE_ERROR_USERNAME_TAKEN);
        }
    }

    private void resetPasswordFields() {
        siteUser.setSiteUserPassword("");
        repeatPassword = "";
    }
}

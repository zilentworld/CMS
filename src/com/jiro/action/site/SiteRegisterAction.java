package com.jiro.action.site;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SiteUserService;
import com.jiro.utility.Constants;
import com.jiro.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SiteRegisterAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private SiteUserService siteUserService;
    private String repeatPassword;
    private SiteUser siteUser;

    @SkipValidation
    public String showRegister() {
        setNextAction(getBlogSiteUrl() + "/siteRegister");
        System.out.println("showRegister:"+getNextAction());
        siteUser = new SiteUser();
        System.out.println("siteRegisterAction:showRegister:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        System.out.println("SiteReg:EXEC");
        System.out.println("exec:nextAction:"+getNextAction());
        String blogUrl = getBlogSiteUrl();
        System.out.println("BLOGURL:"+blogUrl);
        System.out.println("BEFORE SETCMSUSERSITE");
        
        siteUser.setCmsUserSite(cmsUserSiteService.getByUrl(blogUrl));
        
        System.out.println("AFTER SETCMSUSERSITE");
        if(!siteUserService.saveNewUser(siteUser)) {
            return ERROR;
        }
        
        Map<String, SiteUser> siteSessionMap = (Map<String, SiteUser>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        if(siteSessionMap == null)
            siteSessionMap = new HashMap<String, SiteUser>();
        
        siteSessionMap.put(getBlogSiteUrl(), siteUser);

        getSessionMap().put(Constants.SITE_SESSION_MAP_VARIABLE, siteSessionMap);

        setNextAction(getBlogSiteUrl() + "/home");
        System.out.println("exec:nextAction:"+getNextAction());
        System.out.println("siteRegisterAction:execute:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }

    @Override
    public void validate() {
        setNextAction(getBlogSiteUrl() + "/siteRegister");
        
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

}

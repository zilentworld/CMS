package com.jiro.action.site;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SiteUserService;
import com.jiro.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SiteLoginAction extends SiteAbstractAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private SiteUserService siteUserService;
    private SiteUser siteUser;

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
        siteUser = siteUserService.getByLogin(siteUser.getSiteUserUsername(), siteUser.getSiteUserPassword(), getBlogSiteUrl());
        System.out.println("siteUserSession:id:" + getSiteUserSessionId() + " = " + siteUser.getSiteUserId());
        System.out.println("siteUserSession:name:" + getSiteUserSessionName() + " = " + siteUser.getSiteUserUsername());
        Map<String, SiteUser> siteSessionMap = (Map<String, SiteUser>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        if (siteSessionMap == null)
            siteSessionMap = new HashMap<String, SiteUser>();

        siteSessionMap.put(getBlogSiteUrl(), siteUser);

        getSessionMap().put(Constants.SITE_SESSION_MAP_VARIABLE, siteSessionMap);

        setNextAction(getBlogSiteUrl() + "/home");
        System.out.println("siteLoginAction:execute:blogSiteUrl:" + getBlogSiteUrl());
        System.out.println("TEST");

        System.out.println(
                ((SiteUser) ((Map<String, SiteUser>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE)).get(getBlogSiteUrl())).getSiteUserId()
        );
        System.out.println(
                ((SiteUser) ((Map<String, SiteUser>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE)).get(getBlogSiteUrl())).getSiteUserUsername()
        );
        System.out.println("END TEST");
        return SUCCESS;
    }

    @SkipValidation
    public String showLogin() {
        System.out.println("siteLoginAction:showLogin:blogSiteUrl:" + getBlogSiteUrl());

        setNextAction(getBlogSiteUrl() + "/siteLogin");
        System.out.println("nextAction:" + getNextAction());

        return SUCCESS;
    }

    @Override
    public void validate() {
        setNextAction(getBlogSiteUrl() + "/siteLogin");
        String username = siteUser.getSiteUserUsername();
        String password = siteUser.getSiteUserPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            addFieldError("siteUser.siteUserUsername", "Invalid login");
        } else if (!siteUserService.checkLoginExists(username, password, getBlogSiteUrl())) {
            addFieldError("siteUser.siteUserPassword", "Invalid login");
        }
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }
}

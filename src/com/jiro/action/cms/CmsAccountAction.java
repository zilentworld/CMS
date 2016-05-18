package com.jiro.action.cms;

import com.jiro.model.cms.CmsUser;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserService;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.service.cms.impl.CmsUserServiceImpl;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Created by dev-pc on 5/6/16.
 */
@Controller
public class CmsAccountAction extends ActionSupport implements SessionAware {


    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    @Autowired
    private CmsUserService cmsUserService;
    private List<CmsUserSite> cmsUserSiteList;
    private List<CmsUser> cmsUserList;
    private CmsUser cmsUser;
    private String cmsUserId;
    private Map<String, Object> sessionMap;

    public String showSiteList() {
        cmsUserSiteList = cmsUserSiteService.getList();

        return SUCCESS;
    }

    public String showUserList() {
        cmsUserList = cmsUserService.getList();
        return SUCCESS;
    }

    public String showUserInfo() {
        cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
        cmsUserId = "" + cmsUser.getCmsUserId();

        return SUCCESS;
    }

    public String showUserSites() {
        cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
        cmsUserSiteList = cmsUserSiteService.getUserSites(cmsUser);
        System.out.println("showUserSites");
        return SUCCESS;
    }

    public String deactivateUser() {
        return changeUserStatus(false);
    }

    public String activateUser() {
        return changeUserStatus(true);
    }

    private String changeUserStatus(boolean status) {
        if(StringUtils.isNumeric(cmsUserId)) {
            cmsUser = cmsUserService.getById(Long.parseLong(cmsUserId));
            cmsUserService.setCmsUserStatus(cmsUser, status);
            return SUCCESS;
        } else
            return ERROR;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public List<CmsUser> getCmsUserList() {
        return cmsUserList;
    }

    public void setCmsUserList(List<CmsUser> cmsUserList) {
        this.cmsUserList = cmsUserList;
    }

    public List<CmsUserSite> getCmsUserSiteList() {
        return cmsUserSiteList;
    }

    public void setCmsUserSiteList(List<CmsUserSite> cmsUserSiteList) {
        this.cmsUserSiteList = cmsUserSiteList;
    }

    public CmsUser getCmsUser() {
        return cmsUser;
    }

    public void setCmsUser(CmsUser cmsUser) {
        this.cmsUser = cmsUser;
    }

    public String getCmsUserId() {
        return cmsUserId;
    }

    public void setCmsUserId(String cmsUserId) {
        this.cmsUserId = cmsUserId;
    }
}

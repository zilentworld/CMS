package com.jiro.action.site;

import java.util.Map; 

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public abstract class SiteAbstractAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final String NEXT = "next";
    private String blogSiteUrl;
    private String nextAction;
    private Map<String, Object> sessionMap;
    private CmsUserSiteService cmsUserSiteService;
    private String siteUserSessionId;
    private String siteUserSessionName;
    
    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }
    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }
    public String getNextAction() {
        return nextAction;
    }
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }
    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }
    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }
    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
    }
    public String getSiteTemplate() {
        System.out.println("getSiteTemplate:"+blogSiteUrl);
        
        return "-" + cmsUserSiteService.getByUrl(blogSiteUrl)
               .getCmsTemplates().getTemplateName()
               .toLowerCase();
    }
    
    public String getSessionUrl() {
        return (String) sessionMap.get(Constants.CMS_SESSION_BLOG_URL);
    }
        
    public String getSiteUserSessionId() {

        this.siteUserSessionId = Constants.SITE_SESSION_SITE_USER_ID + blogSiteUrl;
        return siteUserSessionId;
    }
    public void setSiteUserSessionId(String siteUserSessionId) {
        this.siteUserSessionId = siteUserSessionId;
    }
    public String getSiteUserSessionName() {
        this.siteUserSessionName = Constants.SITE_SESSION_SITE_USER_NAME + blogSiteUrl;
        return siteUserSessionName;
    }
    public void setSiteUserSessionName(String siteUserSessionName) {
        this.siteUserSessionName = siteUserSessionName;
    }
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    @Override
    public String execute() throws Exception {
        return "";
    }
    
    public void validate() {
        
    }
    
}

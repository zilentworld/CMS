package com.jiro.action.cms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class CheckBlogUrlAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CmsUserSiteService cmsUserSiteService;
    private Map<String, Object> sessionMap;
    private String blogSiteUrl;
    private String nextAction;
    private String test;
                    
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
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
    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }
    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if(blogSiteUrl == null || blogSiteUrl == "")
            blogSiteUrl = request.getServletPath().substring(1);
                
        CmsUserSite cmsUserSite = cmsUserSiteService.getByUrl(blogSiteUrl);
        if(cmsUserSite == null)
            return ERROR;
                
        nextAction = "home-" + cmsUserSite.getCmsTemplates().getTemplateName().toLowerCase();

        System.out.println("checkBlogUrl:nextAction:"+nextAction);
        System.out.println("checkBlogUrl:blogSiteUrl:"+blogSiteUrl);
        
        sessionMap.put(Constants.CMS_SESSION_BLOG_URL, cmsUserSite.getBlogUrl());
        
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public String testing() {
        System.out.println("testing:test:"+test+",blogSiteUrl:"+blogSiteUrl);
        return SUCCESS;
    }
    
}

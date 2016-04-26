package com.jiro.cms.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jiro.cms.model.CmsUserSite;
import com.jiro.cms.service.CmsUserSiteService;
import com.jiro.site.action.SiteAbstractAction;
import com.jiro.utility.Constants;

public class CheckBlogUrlAction extends SiteAbstractAction implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CmsUserSiteService cmsUserSiteService;
    private Map<String, Object> sessionMap;
            
    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }
    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String blogSiteUrl = getBlogSiteUrl();
        if(blogSiteUrl == null || blogSiteUrl == "")
            blogSiteUrl = request.getServletPath().substring(1);
        
        System.out.println("blogSiteUrl:"+blogSiteUrl);
        
        CmsUserSite cmsUserSite = cmsUserSiteService.getByUrl(blogSiteUrl);
        if(cmsUserSite == null)
            return ERROR;
                
        String nextAction = "home-" + cmsUserSite.getCmsTemplates().getTemplateName().toLowerCase();
        setNextAction(nextAction);
        
        sessionMap.put(Constants.CMS_SESSION_BLOG_URL, cmsUserSite.getBlogUrl());
        
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}

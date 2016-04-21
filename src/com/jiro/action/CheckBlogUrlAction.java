package com.jiro.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jiro.model.CmsUserSite;
import com.jiro.service.CmsUserSiteService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckBlogUrlAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CmsUserSiteService cmsUserSiteService;
    private String blogSiteUrl;
    private String nextAction;
            
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
    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }
    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("blogSiteUrl2:"+blogSiteUrl);
        return SUCCESS;
    }
    
    public String checkUrl() {
        HttpServletRequest request = ServletActionContext.getRequest();
        if(blogSiteUrl == null || blogSiteUrl == "")
            blogSiteUrl = request.getServletPath().substring(1);
        
        System.out.println("blogSiteUrl:"+blogSiteUrl);
        
        CmsUserSite cmsUserSite = cmsUserSiteService.getByUrl(blogSiteUrl);
        if(cmsUserSite == null)
            return ERROR;
        
        nextAction = "home-" + cmsUserSite.getCmsTemplates().getTemplateName().toLowerCase();
        return SUCCESS;
    }
    

}

package com.jiro.action;

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
        CmsUserSite cmsUserSite = cmsUserSiteService.getByUrl(blogSiteUrl);
        if(cmsUserSite == null)
            return ERROR;
        
        
        return SUCCESS;
    }
    

}

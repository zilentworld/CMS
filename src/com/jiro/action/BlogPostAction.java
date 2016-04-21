package com.jiro.action;

import com.jiro.service.SitePostService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogPostAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePostService sitePostService;
    
    public SitePostService getSitePostService() {
        return sitePostService;
    }
    public void setSitePostService(SitePostService sitePostService) {
        this.sitePostService = sitePostService;
    }
    
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return super.execute();
    }
    
}

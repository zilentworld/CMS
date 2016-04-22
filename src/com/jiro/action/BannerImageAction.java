package com.jiro.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiro.model.SiteSettings;
import com.jiro.service.SiteSettingsService;
import com.opensymphony.xwork2.ActionSupport;

public class BannerImageAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String blogSiteUrl;
    private SiteSettings siteSettings;
    private SiteSettingsService siteSettingsService;
    
    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }
    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }
    public SiteSettingsService getSiteSettingsService() {
        return siteSettingsService;
    }
    public void setSiteSettingsService(SiteSettingsService siteSettingsService) {
        this.siteSettingsService = siteSettingsService;
    }
    public SiteSettings getSiteSettings() {
        return siteSettings;
    }
    public void setSiteSettings(SiteSettings siteSettings) {
        this.siteSettings = siteSettings;
    }
    
    @Override
    public String execute() throws Exception {
        System.out.println("PASOK SA IMG:"+blogSiteUrl);
        siteSettings = siteSettingsService.getByUrl(blogSiteUrl);
        return SUCCESS;
    }
    
}

package com.jiro.action.site;

import com.jiro.model.site.SiteSettings;
import com.jiro.service.site.SiteSettingsService;

public class SiteImageAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SiteSettings siteSettings;
    private SiteSettingsService siteSettingsService;
    
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
        System.out.println("PASOK SA IMG:"+getBlogSiteUrl());
        siteSettings = siteSettingsService.getByUrl(getBlogSiteUrl());
        return SUCCESS;
    }
    
}

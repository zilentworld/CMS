package com.jiro.site.service;

import com.jiro.cms.model.CmsUserSite;
import com.jiro.site.model.SiteSettings;

public interface SiteSettingsService {
    
    public SiteSettings getById(long siteSettingsId);
    
    public SiteSettings getByUrl(String blogUrl);
    
    public SiteSettings setInitialSettings(CmsUserSite cmsUserSite);

}

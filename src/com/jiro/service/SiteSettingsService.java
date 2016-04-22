package com.jiro.service;

import com.jiro.model.CmsUserSite;
import com.jiro.model.SiteSettings;

public interface SiteSettingsService {
    
    public SiteSettings getById(long siteSettingsId);
    
    public SiteSettings getByUrl(String blogUrl);
    
    public SiteSettings setInitialSettings(CmsUserSite cmsUserSite);

}

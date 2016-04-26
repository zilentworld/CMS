package com.jiro.service.site;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteSettings;

public interface SiteSettingsService {
    
    public SiteSettings getById(long siteSettingsId);
    
    public SiteSettings getByUrl(String blogUrl);
    
    public SiteSettings setInitialSettings(CmsUserSite cmsUserSite);

}

package com.jiro.site.service;

import com.jiro.cms.model.CmsUserSite;
import com.jiro.site.model.SiteUser;

public interface SiteUserService {
    
    public boolean checkLogin(String username, String password);
    
    public boolean saveNewUser(SiteUser siteUser);
    
    public SiteUser getById(long siteUserId);
    
    public SiteUser getByUsername(String siteUsername);
    
    public SiteUser getByLogin(String siteUsername, String sitePassword);
    
    public SiteUser siteFirstUser(CmsUserSite cmsUserSite);

}

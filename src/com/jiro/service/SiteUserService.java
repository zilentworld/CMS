package com.jiro.service;

import com.jiro.model.CmsUserSite;
import com.jiro.model.SiteUser;

public interface SiteUserService {
    
    public boolean checkLogin(String username, String password);
    
    public boolean saveNewUser(SiteUser siteUser);
    
    public SiteUser getById(long siteUserId);
    
    public SiteUser getByUsername(String siteUsername);
    
    public SiteUser getByLogin(String siteUsername, String sitePassword);
    
    public SiteUser siteFirstUser(CmsUserSite cmsUserSite);

}

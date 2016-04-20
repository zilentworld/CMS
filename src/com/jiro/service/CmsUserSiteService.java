package com.jiro.service;

import com.jiro.model.CmsUserSite;


public interface CmsUserSiteService {
    
    public CmsUserSite getByUrl(String blogSiteUrl);
    
    public boolean checkBlogUrl(String blogUrl);
    
    public boolean saveNewUserSite(CmsUserSite cmsUserSite);

}

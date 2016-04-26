package com.jiro.cms.service;

import com.jiro.cms.model.CmsUserSite;


public interface CmsUserSiteService {
    
    public CmsUserSite getByUrl(String blogSiteUrl);
    
    public boolean checkBlogUrl(String blogUrl);
    
    public boolean saveNewUserSite(CmsUserSite cmsUserSite);

}

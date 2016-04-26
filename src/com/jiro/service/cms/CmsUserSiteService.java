package com.jiro.service.cms;

import com.jiro.model.cms.CmsUserSite;


public interface CmsUserSiteService {
    
    public CmsUserSite getByUrl(String blogSiteUrl);
    
    public boolean checkBlogUrl(String blogUrl);
    
    public boolean saveNewUserSite(CmsUserSite cmsUserSite);

}

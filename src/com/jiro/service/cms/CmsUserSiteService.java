package com.jiro.service.cms;

import com.jiro.model.cms.CmsUserSite;

import java.util.List;


public interface CmsUserSiteService {
    
    CmsUserSite getByUrl(String blogSiteUrl);
    
    boolean checkBlogUrl(String blogUrl);

    boolean saveNewUserSite(CmsUserSite cmsUserSite);

    List<CmsUserSite> getByPublished(boolean published);

}

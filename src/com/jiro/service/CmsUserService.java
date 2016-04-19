package com.jiro.service;

import com.jiro.model.CmsUser;

public interface CmsUserService {
    
    public boolean createNewCmsUser(CmsUser cmsUser);

    public boolean checkExistingCmsUser(CmsUser cmsUser);
    
    public boolean checkExistingCmsUser(String cmsUsername);

    public boolean checkLogin(CmsUser cmsUser);

    public CmsUser getByLogin(CmsUser cmsUser);
    
    public CmsUser getByLogin(String username, String password);

}

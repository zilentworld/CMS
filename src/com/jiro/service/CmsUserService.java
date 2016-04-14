package com.jiro.service;

import com.jiro.model.CmsUser;

public interface CmsUserService {
    
    public CmsUser createNewCmsUser(CmsUser cmsUser, String cmsUserType);

    public boolean checkExistingCmsUser(CmsUser cmsUser);
    
    public boolean checkExistingCmsUser(String cmsUsername);

}

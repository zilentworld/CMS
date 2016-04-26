package com.jiro.cms.service;

import com.jiro.cms.model.CmsUserType;

public interface CmsUserTypeService {
    
    public boolean checkUserType(String userType);
    
    public CmsUserType getCmsUserType(String cmsUserType);

}

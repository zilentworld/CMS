package com.jiro.service.cms;

import com.jiro.model.cms.CmsUserType;

public interface CmsUserTypeService {
    
    public boolean checkUserType(String userType);
    
    public CmsUserType getCmsUserType(String cmsUserType);

}

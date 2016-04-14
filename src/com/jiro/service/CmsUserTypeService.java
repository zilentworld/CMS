package com.jiro.service;

import com.jiro.model.CmsUserType;

public interface CmsUserTypeService {
    
    public boolean checkUserType(String userType);
    
    public CmsUserType getCmsUserType(String cmsUserType);

}

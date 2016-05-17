package com.jiro.service.cms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.cms.CmsUserTypeDao;
import com.jiro.model.cms.CmsUserType;
import com.jiro.service.cms.CmsUserTypeService;

@Service
public class CmsUserTypeServiceImpl implements CmsUserTypeService {
    
    @Autowired
    private CmsUserTypeDao cmsUserTypeDao;

    @Override
    public boolean checkUserType(String userTypeString) {
        if(cmsUserTypeDao.get(userTypeString) == null)
            return false;
        
        return true;
    }
    
    @Override
    public CmsUserType getCmsUserType(String cmsUserType) {
        return cmsUserTypeDao.get(cmsUserType);
    }

}

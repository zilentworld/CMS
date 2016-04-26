package com.jiro.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.cms.dao.CmsUserTypeDao;
import com.jiro.cms.model.CmsUserType;
import com.jiro.cms.service.CmsUserTypeService;

@Service
public class CmsUserTypeServiceImpl implements CmsUserTypeService {
    
    @Autowired
    CmsUserTypeDao cmsUserTypeDao;
    
    public void setCmsUserTypeDao(CmsUserTypeDao cmsUserTypeDao) {
        this.cmsUserTypeDao = cmsUserTypeDao;
    }

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

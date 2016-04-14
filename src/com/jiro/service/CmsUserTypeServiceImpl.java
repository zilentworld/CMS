package com.jiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.CmsUserTypeDao;
import com.jiro.model.CmsUserType;

@Service
public class CmsUserTypeServiceImpl implements CmsUserTypeService {
    
    @Autowired
    CmsUserTypeDao cmsUserTypeDao;
    
    public CmsUserTypeDao getCmsUserTypeDao() {
        return cmsUserTypeDao;
    }

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

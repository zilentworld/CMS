package com.jiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.CmsUserSiteDao;

@Service
public class CmsUserSiteServiceImpl implements CmsUserSiteService {
    
    @Autowired
    private CmsUserSiteDao cmsUserSiteDao;

    @Override
    public boolean checkCmsUrl(String cmsUrl) {
        if(cmsUserSiteDao.getByUrl(cmsUrl) != null)
            return true;
        else
            return false;
    }

    
}

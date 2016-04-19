package com.jiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.CmsUserSiteDao;
import com.jiro.model.CmsUserSite;

@Service
public class CmsUserSiteServiceImpl implements CmsUserSiteService {
    
    @Autowired
    private CmsUserSiteDao cmsUserSiteDao;
    
    public boolean saveNewUserSite(CmsUserSite cmsUserSite) {
        return cmsUserSiteDao.persist(cmsUserSite) > 0;
    }

    public CmsUserSiteDao getCmsUserSiteDao() {
        return cmsUserSiteDao;
    }

    public void setCmsUserSiteDao(CmsUserSiteDao cmsUserSiteDao) {
        this.cmsUserSiteDao = cmsUserSiteDao;
    }

    @Override
    public boolean checkBlogUrl(String blogUrl) {
        if(cmsUserSiteDao.getByUrl(blogUrl) != null)
            return true;
        else
            return false;
    }
        
}

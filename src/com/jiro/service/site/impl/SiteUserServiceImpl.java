package com.jiro.service.site.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.site.SiteUserDao;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SiteUserService;

@Service
public class SiteUserServiceImpl implements SiteUserService {
    
    @Autowired
    private SiteUserDao siteUserDao;
    

    public void setSiteUserDao(SiteUserDao siteUserDao) {
        this.siteUserDao = siteUserDao;
    }

    @Override
    public boolean checkLoginExists(String username, String password, String siteUrl) {
        return siteUserDao.getByLogin(username, password, siteUrl) != null ? true : false;
    }

    @Override
    public boolean saveNewUser(SiteUser siteUser) {
        return siteUserDao.persist(siteUser) > 0 ? true : false;
    }

    @Override
    public SiteUser getById(long siteUserId) {
        return siteUserDao.getById(siteUserId);
    }

    @Override
    public SiteUser getByUsername(String siteUsername) {
        return siteUserDao.getByUsername(siteUsername);
    }

    @Override
    public SiteUser getByLogin(String siteUsername, String sitePassword, String siteUrl) {
        return siteUserDao.getByLogin(siteUsername, sitePassword, siteUrl);
    }
    
    @Override
    public SiteUser siteFirstUser(CmsUserSite cmsUserSite) {
        if(cmsUserSite == null) {
            return null;
        }
        SiteUser siteUser = new SiteUser(cmsUserSite);
        if(siteUserDao.persist(siteUser) > 0)
            return siteUser;
        else
            return null;
    }

}

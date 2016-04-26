package com.jiro.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.cms.model.CmsUserSite;
import com.jiro.site.dao.SiteUserDao;
import com.jiro.site.model.SiteUser;
import com.jiro.site.service.SiteUserService;

@Service
public class SiteUserServiceImpl implements SiteUserService {
    
    @Autowired
    private SiteUserDao siteUserDao;

    public void setSiteUserDao(SiteUserDao siteUserDao) {
        this.siteUserDao = siteUserDao;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return siteUserDao.getByLogin(username, password) != null ? true : false;
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
    public SiteUser getByLogin(String siteUsername, String sitePassword) {
        return siteUserDao.getByUsername(siteUsername);
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

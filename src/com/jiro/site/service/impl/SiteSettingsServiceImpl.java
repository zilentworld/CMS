package com.jiro.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.cms.model.CmsUserSite;
import com.jiro.site.dao.SiteSettingsDao;
import com.jiro.site.model.SiteSettings;
import com.jiro.site.service.SiteSettingsService;

@Service
public class SiteSettingsServiceImpl implements SiteSettingsService {
    
    @Autowired
    private SiteSettingsDao siteSettingsDao;

    public SiteSettingsDao getSiteSettingsDao() {
        return siteSettingsDao;
    }

    public void setSiteSettingsDao(SiteSettingsDao siteSettingsDao) {
        this.siteSettingsDao = siteSettingsDao;
    }

    @Override
    public SiteSettings getById(long siteSettingsId) {
        return siteSettingsDao.getById(siteSettingsId);
    }

    @Override
    public SiteSettings getByUrl(String blogUrl) {
        return siteSettingsDao.getByUrl(blogUrl);
    }

    @Override
    public SiteSettings setInitialSettings(CmsUserSite cmsUserSite) {
        SiteSettings siteSettings = new SiteSettings(cmsUserSite);
        System.out.println("initial:cmsUserSiteId:"+cmsUserSite.getCmsUserSiteId());
        System.out.println("siteSettings:cmsUserSiteId:"+siteSettings.getCmsUserSite().getCmsUserSiteId());
        if(siteSettingsDao.persist(siteSettings) > 0)
            return siteSettings;
        else
            return null;
    }    

}

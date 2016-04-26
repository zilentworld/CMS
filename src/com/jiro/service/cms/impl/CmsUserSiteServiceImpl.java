package com.jiro.service.cms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.cms.CmsUserSiteDao;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SitePost;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.service.site.SitePostService;
import com.jiro.service.site.SiteSettingsService;
import com.jiro.service.site.SiteUserService;

@Service
public class CmsUserSiteServiceImpl implements CmsUserSiteService {
    
    @Autowired
    private CmsUserSiteDao cmsUserSiteDao;
    @Autowired
    private SiteUserService siteUserService;
    @Autowired
    private SitePostService sitePostService;
    @Autowired
    private SiteSettingsService siteSettingsService;
    
    public void setSiteUserService(SiteUserService siteUserService) {
        this.siteUserService = siteUserService;
    }

    public void setSitePostService(SitePostService sitePostService) {
        this.sitePostService = sitePostService;
    }

    public void setCmsUserSiteDao(CmsUserSiteDao cmsUserSiteDao) {
        this.cmsUserSiteDao = cmsUserSiteDao;
    }
    
    public boolean saveNewUserSite(CmsUserSite cmsUserSite) {
        if(cmsUserSiteDao.persist(cmsUserSite) > 0) {
            SitePost firstPost = sitePostService.siteFirstPost(
                    siteUserService.siteFirstUser(cmsUserSite));
            siteSettingsService.setInitialSettings(cmsUserSite);
            return firstPost != null;
        } else
            return false;
    }

    @Override
    public boolean checkBlogUrl(String blogUrl) {
        if(cmsUserSiteDao.getByUrl(blogUrl) != null)
            return true;
        else
            return false;
    }
    
    @Override
    public CmsUserSite getByUrl(String blogSiteUrl) {
        return cmsUserSiteDao.getByUrl(blogSiteUrl);
    }
    
}

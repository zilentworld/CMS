package com.jiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.CmsUserSiteDao;
import com.jiro.model.CmsUserSite;
import com.jiro.model.SitePost;

@Service
public class CmsUserSiteServiceImpl implements CmsUserSiteService {
    
    @Autowired
    private CmsUserSiteDao cmsUserSiteDao;
    @Autowired
    private SiteUserService siteUserService;
    @Autowired
    private SitePostService sitePostService;
    
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

package com.jiro.service.cms.impl;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUser;
import com.jiro.service.cms.CmsTemplatesService;
import com.jiro.service.cms.CmsUserService;
import com.jiro.service.site.SiteLinksPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jiro.dao.cms.CmsUserSiteDao;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SitePost;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.service.site.SitePostService;
import com.jiro.service.site.SiteSettingsService;
import com.jiro.service.site.SiteUserService;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private SiteLinksPermissionService siteLinksPermissionService;
    @Autowired
    private CmsUserService cmsUserService;
    @Autowired
    private CmsTemplatesService cmsTemplatesService;


    public void setSiteSettingsService(SiteSettingsService siteSettingsService) {
        this.siteSettingsService = siteSettingsService;
    }

    public void setSiteLinksPermissionService(SiteLinksPermissionService siteLinksPermissionService) {
        this.siteLinksPermissionService = siteLinksPermissionService;
    }

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
        System.out.println("saveNewUserSite");
        if(cmsUserSiteDao.persist(cmsUserSite) > 0) {
            System.out.println("saveNewUserSite:saved:");
            SitePost firstPost = sitePostService.siteFirstPost(
                    siteUserService.siteFirstUser(cmsUserSite));
            siteSettingsService.setInitialSettings(cmsUserSite);
            siteLinksPermissionService.addInitialLinks(cmsUserSite);
            System.out.println("saveNewUserSite:saved:firstPost:"+firstPost);
            return firstPost != null;
//            return true;
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

    @Override
    public List<CmsUserSite> getByPublished(boolean published) {
        return cmsUserSiteDao.getByPublished(published ? 1 : 0);
    }

    @Override
    public CmsUserSite getById(long cmsUserSiteId) {
        return cmsUserSiteDao.get(cmsUserSiteId);
    }

    @Override
    public void updatePublishStatus(CmsUserSite cmsUserSite, boolean publishStatus) {
        cmsUserSite.setIsPublished(publishStatus ? 1 : 0);
        cmsUserSiteDao.saveOrUpdate(cmsUserSite);
    }

    @Override
    public List<CmsUserSite> getUserSites(CmsUser cmsUser) {
        return cmsUserSiteDao.getUserSites(cmsUser);
    }

    @Override
    public List<CmsUserSite> getList() {
        return cmsUserSiteDao.getList();
    }

    @Override
    public CmsUserSite createNewCmsUserSite(long cmsUserId, String blogUrl, long cmsTemplateId) {
        System.out.println("createNewCmsUserSite:");
        CmsUserSite cmsUserSite = new CmsUserSite();
        cmsUserSite.setCmsUser(cmsUserService.getById(cmsUserId));
        cmsUserSite.setCmsTemplates(cmsTemplatesService.getById(cmsTemplateId));
        cmsUserSite.setBlogUrl(blogUrl);
        cmsUserSite.setIsPublished(0);
        System.out.println("createNewCmsUserSite:saveNewUserSite:");
        saveNewUserSite(cmsUserSite);
        System.out.println("createNewCmsUserSite:createSiteInitialFiles");
        CmsFileController.createSiteInitialFiles(cmsUserSite);

        return cmsUserSite;
    }
}

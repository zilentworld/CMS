package com.jiro.service.site.impl;

import com.jiro.dao.site.SiteLinksPermissionDao;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteLinks;
import com.jiro.model.site.SiteLinksPermission;
import com.jiro.service.site.SiteLinksPermissionService;
import com.jiro.service.site.SiteLinksService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */
public class SiteLinksPermissionServiceImpl implements SiteLinksPermissionService {


    @Autowired
    private SiteLinksPermissionDao siteLinksPermissionDao;
    @Autowired
    private SiteLinksService siteLinksService;


    public void setSiteLinksService(SiteLinksService siteLinksService) {
        this.siteLinksService = siteLinksService;
    }

    public void setSiteLinksPermissionDao(SiteLinksPermissionDao siteLinksPermissionDao) {
        this.siteLinksPermissionDao = siteLinksPermissionDao;
    }

    @Override
    public void updateSiteLinkPermission(long cmsUserSiteId, long siteLinkId, boolean isEnabled) {
        SiteLinksPermission s = siteLinksPermissionDao.getByOtherIds(cmsUserSiteId, siteLinkId);
        s.setIsEnabled(isEnabled? 1 : 0);
        siteLinksPermissionDao.saveOrUpdate(s);
    }

    @Override
    public List<SiteLinksPermission> getList() {
        return siteLinksPermissionDao.getList();
    }

    @Override
    public void addInitialLinks(CmsUserSite cmsUserSite) {
        System.out.println("addInitialLinks:start:");
        List<SiteLinksPermission> siteLinksPermissionList = new ArrayList<>();
        System.out.println("addInitialLinks:1:");
        List<SiteLinks> siteLinksList = siteLinksService.getSiteLinks();
        System.out.println("addInitialLinks:2:");
        siteLinksList.forEach(siteLinks -> siteLinksPermissionList.add(new SiteLinksPermission(cmsUserSite, siteLinks)));
        System.out.println("addInitialLinks:3:");
        siteLinksPermissionList.forEach(siteLinksPermission -> siteLinksPermissionDao.save(siteLinksPermission));
        System.out.println("addInitialLinks:end:");
    }

}

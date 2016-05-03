package com.jiro.service.site.impl;

import com.jiro.dao.site.SiteLinksPermissionDao;
import com.jiro.model.site.SiteLinksPermission;
import com.jiro.service.site.SiteLinksPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dev-pc on 5/3/16.
 */
public class SiteLinksPermissionServiceImpl implements SiteLinksPermissionService {


    @Autowired
    private SiteLinksPermissionDao siteLinksPermissionDao;

    public SiteLinksPermissionDao getSiteLinksPermissionDao() {
        return siteLinksPermissionDao;
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
}

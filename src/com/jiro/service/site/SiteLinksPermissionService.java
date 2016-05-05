package com.jiro.service.site;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteLinksPermission;

import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */
public interface SiteLinksPermissionService {

    void updateSiteLinkPermission(long cmsUserSiteId, long siteLinkId, boolean isEnabled);

    List<SiteLinksPermission> getList();

    void addInitialLinks(CmsUserSite cmsUserSite);
}

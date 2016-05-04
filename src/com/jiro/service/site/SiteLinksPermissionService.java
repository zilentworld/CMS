package com.jiro.service.site;

import com.jiro.model.site.SiteLinksPermission;

import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */
public interface SiteLinksPermissionService {

    public void updateSiteLinkPermission(long cmsUserSiteId, long siteLinkId, boolean isEnabled);

    public List<SiteLinksPermission> getList();

}

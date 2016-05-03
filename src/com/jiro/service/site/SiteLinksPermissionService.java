package com.jiro.service.site;

/**
 * Created by dev-pc on 5/3/16.
 */
public interface SiteLinksPermissionService {

    public void updateSiteLinkPermission(long cmsUserSiteId, long siteLinkId, boolean isEnabled);

}

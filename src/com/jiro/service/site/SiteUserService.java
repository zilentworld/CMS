package com.jiro.service.site;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteUser;

public interface SiteUserService {

    public boolean checkLoginExists(String username, String password, String siteUrl);

    public boolean saveNewUser(SiteUser siteUser);

    public SiteUser getById(long siteUserId);

    public SiteUser getByUsername(String siteUsername);

    public SiteUser getByLogin(String siteUsername, String sitePassword, String siteUrl);

    public SiteUser siteFirstUser(CmsUserSite cmsUserSite);

}

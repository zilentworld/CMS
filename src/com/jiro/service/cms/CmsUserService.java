package com.jiro.service.cms;

import com.jiro.model.cms.CmsUser;

import java.util.List;

public interface CmsUserService {

    boolean createNewCmsUser(CmsUser cmsUser);

    boolean checkExistingCmsUser(CmsUser cmsUser);

    boolean checkExistingCmsUser(String cmsUsername);

    boolean checkLoginUserPass(CmsUser cmsUser);

    CmsUser getByLogin(CmsUser cmsUser);

    CmsUser getByLogin(String username, String password);

    List<CmsUser> getList();

    CmsUser getById(long cmsUserId);

    void updateCmsUser(CmsUser cmsUser);

    void setCmsUserStatus(CmsUser cmsUser, boolean status);

}

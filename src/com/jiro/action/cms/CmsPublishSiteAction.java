package com.jiro.action.cms;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zilentworld on 5/15/2016.
 */
public class CmsPublishSiteAction extends ActionSupport {

    private CmsUserSiteService cmsUserSiteService;
    private CmsUserSite cmsUserSite;
    private long cmsUserSiteId;

    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }

    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public long getCmsUserSiteId() {
        return cmsUserSiteId;
    }

    public void setCmsUserSiteId(long cmsUserSiteId) {
        this.cmsUserSiteId = cmsUserSiteId;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("cmsPublishSiteAction:execute:cmsUserSiteId:"+cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        cmsUserSiteService.publishSite(cmsUserSite);


        return SUCCESS;
    }

}

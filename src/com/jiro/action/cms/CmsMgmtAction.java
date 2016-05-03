package com.jiro.action.cms;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteLinks;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.service.cms.impl.CmsUserServiceImpl;
import com.jiro.service.cms.impl.CmsUserSiteServiceImpl;
import com.jiro.service.site.SiteLinksPermissionService;
import com.jiro.service.site.SiteLinksService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CmsMgmtAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CmsUserSiteService cmsUserSiteService;
    private List<CmsUserSite> cmsUserSiteLists;
    private SiteLinksService siteLinksService;
    private SiteLinksPermissionService siteLinksPermissionService;
    private List<String> siteHeaders;
    private List<SiteLinks> siteLinks;
    private String publishId;
    private List<String> headerList;
    private String cmsUserSiteId;

    public SiteLinksPermissionService getSiteLinksPermissionService() {
        return siteLinksPermissionService;
    }

    public void setSiteLinksPermissionService(SiteLinksPermissionService siteLinksPermissionService) {
        this.siteLinksPermissionService = siteLinksPermissionService;
    }

    public String getCmsUserSiteId() {
        return cmsUserSiteId;
    }

    public void setCmsUserSiteId(String cmsUserSiteId) {
        this.cmsUserSiteId = cmsUserSiteId;
    }

    public List<String> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(List<String> headerList) {
        this.headerList = headerList;
    }

    public SiteLinksService getSiteLinksService() {
        return siteLinksService;
    }

    public void setSiteLinksService(SiteLinksService siteLinksService) {
        this.siteLinksService = siteLinksService;
    }

    public List<String> getSiteHeaders() {
        return siteHeaders;
    }

    public void setSiteHeaders(List<String> siteHeaders) {
        this.siteHeaders = siteHeaders;
    }

    public List<SiteLinks> getSiteLinks() {
        return siteLinks;
    }

    public void setSiteLinks(List<SiteLinks> siteLinks) {
        this.siteLinks = siteLinks;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }

    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
    }

    public List<CmsUserSite> getCmsUserSiteLists() {
        return cmsUserSiteLists;
    }

    public void setCmsUserSiteLists(List<CmsUserSite> cmsUserSiteLists) {
        this.cmsUserSiteLists = cmsUserSiteLists;
    }

    public String showSiteList() {
        System.out.println("CmsMgmtAction:showSiteList:");
        cmsUserSiteLists = cmsUserSiteService.getByPublished(false);
        System.out.println("CmsMgmtAction:showSiteList:cmsUserSiteLists:size:"+cmsUserSiteLists.size());
        return SUCCESS;
    }

    public String publishSite() {
        System.out.println("publishSite:publishId:"+publishId);

        return SUCCESS;
    }
    
    public String showManageHeaders() {
        System.out.println("showManageHeaders:");
        siteHeaders = siteLinksService.getHeaderNames();
        System.out.println("showManageHeaders:siteHeaders:size:"+siteHeaders.size());
        siteLinks = siteLinksService.getSiteLinks();
        System.out.println("showManageHeaders:siteLinks:size:"+siteLinks.size());
        cmsUserSiteLists = cmsUserSiteService.getByPublished(true);
//        cmsUserSiteLists.forEach(e -> e.getSiteLinksList());
        System.out.println("showManageHeaders:cmsUserSiteLists:size:"+cmsUserSiteLists.size());

        return SUCCESS;
    }

    public String processManageHeaders() {
        System.out.println("processManageHeaders:");
        headerList.forEach(e ->
                siteLinksPermissionService.updateSiteLinkPermission(Long.parseLong(cmsUserSiteId), Long.parseLong(e), true));

        return SUCCESS;
    }
}

package com.jiro.action.cms;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUser;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.model.site.SiteLinks;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.service.site.SiteLinksPermissionService;
import com.jiro.service.site.SiteLinksService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CmsMgmtAction extends ActionSupport implements SessionAware {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    @Autowired
    private SiteLinksService siteLinksService;
    @Autowired
    private SiteLinksPermissionService siteLinksPermissionService;
    private List<CmsUserSite> cmsUserSiteLists;
    private List<String> siteHeaders;
    private List<SiteLinks> siteLinks;
    private String publishId;
    private List<String> headerList;
    private String cmsUserSiteId;
    private String blogSiteUrl;
    private String nextAction;
    private Map<String, Object> sessionMap;

    public String showSiteList() {
        System.out.println("CmsMgmtAction:showSiteList:");
        cmsUserSiteLists = cmsUserSiteService.getList();
        System.out.println("CmsMgmtAction:showSiteList:cmsUserSiteLists:size:" + cmsUserSiteLists.size());
        return SUCCESS;
    }

    public String publishSite() {
        System.out.println("publishSite:cmsUserSiteId:" + cmsUserSiteId);
        System.out.println("publishSite:publishId:" + publishId);
        CmsUserSite cmsUserSite = cmsUserSiteService.getById(Long.parseLong(cmsUserSiteId));
        if (cmsUserSite == null)
            return ERROR;

        CmsFileController.publishSite(cmsUserSite);

        cmsUserSiteService.updatePublishStatus(cmsUserSite, true);

        blogSiteUrl = cmsUserSite.getBlogUrl();
        nextAction = blogSiteUrl + "/home";

        System.out.println("publishSite:blogSiteUrl:" + blogSiteUrl);
        System.out.println("publishSite:nextAction:" + nextAction);

        return SUCCESS;
    }

    public String republishSite() {
        CmsUserSite cmsUserSite = cmsUserSiteService.getById(Long.parseLong(cmsUserSiteId));
        if (cmsUserSite == null)
            return ERROR;

        CmsFileController.updatePublishedSite(cmsUserSite);
        return SUCCESS;
    }

    public String republishAllSites() {
//        cmsUserSiteService.getByPublished(true).forEach(e -> CmsFileController.updatePublishedSite(e));
        cmsUserSiteLists = cmsUserSiteService.getByPublished(true);
        for (CmsUserSite cmsUserSite : cmsUserSiteLists) {
            CmsFileController.updatePublishedSite(cmsUserSite);
        }

        return SUCCESS;
    }

    public String showManageHeaders() {
        System.out.println("showManageHeaders:");
        siteHeaders = siteLinksService.getHeaderNames();
        System.out.println("showManageHeaders:siteHeaders:size:" + siteHeaders.size());
        siteLinks = siteLinksService.getSiteLinks();
        System.out.println("showManageHeaders:siteLinks:size:" + siteLinks.size());
        cmsUserSiteLists = cmsUserSiteService.getByPublished(true);
//        cmsUserSiteLists.forEach(e -> e.getSiteLinksList());
        System.out.println("showManageHeaders:cmsUserSiteLists:size:" + cmsUserSiteLists.size());

        return SUCCESS;
    }

    public String processManageHeaders() {
        System.out.println("processManageHeaders:");
        headerList.forEach(e ->
                siteLinksPermissionService.
                        updateSiteLinkPermission(Long.parseLong(cmsUserSiteId), Long.parseLong(e), true));

        for (SiteLinks s : siteLinksService.getSiteLinks()) {
            if (!headerList.contains(s.getSiteLinkId())) {
                siteLinksPermissionService.
                        updateSiteLinkPermission(Long.parseLong(cmsUserSiteId), s.getSiteLinkId(), false);
            }
        }

        return SUCCESS;
    }

    public String showMySites() {
        System.out.println("showMySites:");
        CmsUser cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);

        cmsUserSiteLists = cmsUserSiteService.getUserSites(cmsUser);
        System.out.println("showMySites:cmsUserSiteList:size:" + cmsUserSiteLists.size());


        return SUCCESS;
    }

    public String showMyUsers() {
        CmsUser cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
        cmsUserSiteLists.clear();
        cmsUserSiteLists.addAll(cmsUser.getCmsUserSites());

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }

    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
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

    public List<CmsUserSite> getCmsUserSiteLists() {
        return cmsUserSiteLists;
    }

    public void setCmsUserSiteLists(List<CmsUserSite> cmsUserSiteLists) {
        this.cmsUserSiteLists = cmsUserSiteLists;
    }

}

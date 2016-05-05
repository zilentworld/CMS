package com.jiro.model.site;

import com.jiro.model.cms.CmsUserSite;

import javax.persistence.*;

/**
 * Created by dev-pc on 5/3/16.
 */
@Entity
@Table(name="site_links_permission")
public class SiteLinksPermission implements Comparable {

    @Id
    @Column(name="permission_id")
    private int permissionId;

    @Column(name="is_enabled")
    private int isEnabled;

    @ManyToOne
    @JoinColumn(name = "cms_user_site_id")
    private CmsUserSite cmsUserSite;

    @ManyToOne
    @JoinColumn(name = "site_link_id")
    private SiteLinks siteLinks;

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public int getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(int isEnabled) {
        this.isEnabled = isEnabled;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public SiteLinks getSiteLinks() {
        return siteLinks;
    }

    public void setSiteLinks(SiteLinks siteLinks) {
        this.siteLinks = siteLinks;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  SiteLinksPermission) {
            SiteLinksPermission s2 = (SiteLinksPermission) o;
            return this.siteLinks.getSiteLinkId() < s2.getSiteLinks().getSiteLinkId() ? 1 : 0;
        }
        return  0;
    }

    public SiteLinksPermission() {
    }

    public SiteLinksPermission(CmsUserSite cmsUserSite, SiteLinks siteLinks) {
        this.cmsUserSite = cmsUserSite;
        this.siteLinks = siteLinks;
        this.isEnabled = 0;
    }
}

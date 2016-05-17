package com.jiro.model.cms;


import com.jiro.model.site.SiteLinksPermission;
import com.jiro.model.site.SiteSettings;
import com.jiro.utility.Constants;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cms_user_site")
public class CmsUserSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cms_user_site_id")
    private long cmsUserSiteId;

    @ManyToOne
    @JoinColumn(name = "cms_user_id")
    private CmsUser cmsUser;

    @Column(name = "blog_url")
    private String blogUrl;

    @ManyToOne
    @JoinColumn(name = "blog_template")
    private CmsTemplates cmsTemplates;

    @Column(name = "create_date", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cmsUserSite", cascade = CascadeType.ALL)
    private SiteSettings siteSettings;

    @Column(name = "is_published")
    private int isPublished;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmsUserSite", fetch = FetchType.LAZY)
    private List<SiteLinksPermission> siteLinksPermissions;

    public List<SiteLinksPermission> getSiteLinksPermissions() {
        return siteLinksPermissions;
    }

    public void setSiteLinksPermissions(List<SiteLinksPermission> siteLinksPermissions) {
        this.siteLinksPermissions = siteLinksPermissions;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public CmsUser getCmsUser() {
        return cmsUser;
    }

    public void setCmsUser(CmsUser cmsUser) {
        this.cmsUser = cmsUser;
    }

    public CmsTemplates getCmsTemplates() {
        return cmsTemplates;
    }

    public void setCmsTemplates(CmsTemplates cmsTemplates) {
        this.cmsTemplates = cmsTemplates;
    }

    public long getCmsUserSiteId() {
        return cmsUserSiteId;
    }

    public void setCmsUserSiteId(long cmsUserSiteId) {
        this.cmsUserSiteId = cmsUserSiteId;
    }

    public SiteSettings getSiteSettings() {
        return siteSettings;
    }

    public void setSiteSettings(SiteSettings siteSettings) {
        this.siteSettings = siteSettings;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(int isPublished) {
        this.isPublished = isPublished;
    }

    public CmsUserSite(CmsUser cmsUser, String blogUrl, CmsTemplates cmsTemplates) {
        this.cmsUser = cmsUser;
        this.blogUrl = blogUrl;
        this.cmsTemplates = cmsTemplates;
    }

    public String getCurrPath() {
        return this.isPublished == 1 ? Constants.getPublishPath() : Constants.getPendingPath();
    }

    public CmsUserSite() {
    }
}

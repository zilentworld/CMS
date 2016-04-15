package com.jiro.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cms_user_site")
public class CmsUserSite {
    
    @Id
    @Column(name="cms_user_site_id")
    private String cmsUserSiteId;
    @Column(name="cms_user_id")
    private String cmsUserId;
    @Column(name="cms_url")
    private String cmsUrl;
    @Column(name="cms_theme")
    private String cmsTheme;
    @Column(name="create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    public String getCmsUserSiteId() {
        return cmsUserSiteId;
    }
    public void setCmsUserSiteId(String cmsUserSiteId) {
        this.cmsUserSiteId = cmsUserSiteId;
    }
    public String getCmsUserId() {
        return cmsUserId;
    }
    public void setCmsUserId(String cmsUserId) {
        this.cmsUserId = cmsUserId;
    }
    public String getCmsUrl() {
        return cmsUrl;
    }
    public void setCmsUrl(String cmsUrl) {
        this.cmsUrl = cmsUrl;
    }
    public String getCmsTheme() {
        return cmsTheme;
    }
    public void setCmsTheme(String cmsTheme) {
        this.cmsTheme = cmsTheme;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
}

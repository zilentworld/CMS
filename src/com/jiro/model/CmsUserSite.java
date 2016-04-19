package com.jiro.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cms_user_site")
public class CmsUserSite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cms_user_site_id")
    private long cmsUserSiteId;
    

    @ManyToOne
    @JoinColumn(name = "cms_user_id")
    private CmsUser cmsUser;
//    @Column(name="cms_user_type_code")
//    private String cmsUserId;
    
    @Column(name="blog_url")
    private String blogUrl;

    @ManyToOne
    @JoinColumn(name = "blog_template")
    private CmsTemplates cmsTemplates;
    
//    @Column(name="blog_template")
//    private String cmsTheme;
    
    @Column(name="create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    
//    public String getCmsUserId() {
//        return cmsUserId;
//    }
//    public void setCmsUserId(String cmsUserId) {
//        this.cmsUserId = cmsUserId;
//    }
    
    
    public String getBlogUrl() {
        return blogUrl;
    }
    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
//    public String getCmsTheme() {
//        return cmsTheme;
//    }
//    public void setCmsTheme(String cmsTheme) {
//        this.cmsTheme = cmsTheme;
//    }
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
    public CmsUserSite() {}

    public CmsUserSite(CmsUser cmsUser, String blogUrl, CmsTemplates cmsTemplates) {
        this.cmsUser = cmsUser;
        this.blogUrl = blogUrl;
        this.cmsTemplates = cmsTemplates;
    }    
}

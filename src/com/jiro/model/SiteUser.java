package com.jiro.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="site_user")
public class SiteUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="site_user_id")
    private long siteUserId;
    
    @ManyToOne
    @JoinColumn(name="cms_user_site_id")
    private CmsUserSite cmsUserSite;

    @Column(name="site_user_username")
    private String siteUserUsername;
    
    @Column(name="site_user_password")
    private String siteUserPassword;

    @Column(name="site_register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siteRegisterDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteUser", fetch = FetchType.LAZY)
    private Set<SitePost> sitePosts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteUser", fetch = FetchType.LAZY)
    private Set<SiteComment> siteComments;

    public long getSiteUserId() {
        return siteUserId;
    }

    public void setSiteUserId(long siteUserId) {
        this.siteUserId = siteUserId;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public String getSiteUserUsername() {
        return siteUserUsername;
    }

    public void setSiteUserUsername(String siteUserUsername) {
        this.siteUserUsername = siteUserUsername;
    }

    public String getSiteUserPassword() {
        return siteUserPassword;
    }

    public void setSiteUserPassword(String siteUserPassword) {
        this.siteUserPassword = siteUserPassword;
    }

    public Date getSiteRegisterDate() {
        return siteRegisterDate;
    }

    public void setSiteRegisterDate(Date siteRegisterDate) {
        this.siteRegisterDate = siteRegisterDate;
    }

    public Set<SitePost> getSitePosts() {
        return sitePosts;
    }

    public void setSitePosts(Set<SitePost> sitePosts) {
        this.sitePosts = sitePosts;
    }

    public Set<SiteComment> getSiteComments() {
        return siteComments;
    }

    public void setSiteComments(Set<SiteComment> siteComments) {
        this.siteComments = siteComments;
    }
    
    public SiteUser() {}
    
    public SiteUser(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
        this.siteUserUsername = cmsUserSite.getCmsUser().getCmsUsername();
        this.siteUserPassword = cmsUserSite.getCmsUser().getCmsPassword();
    }
}

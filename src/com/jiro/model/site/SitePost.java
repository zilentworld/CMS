package com.jiro.model.site;

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

import com.jiro.model.cms.CmsUserSite;

@Entity
@Table(name="site_post")
public class SitePost {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="site_post_id")
    private long sitePostId;

    @ManyToOne
    @JoinColumn(name="cms_user_site_id")
    private CmsUserSite cmsUserSite;
    
    @ManyToOne
    @JoinColumn(name="site_user_id")
    private SiteUser siteUser;
    
    @Column(name="site_post_title")
    private String sitePostTitle;
    
    @Column(name="site_post_content")
    private String sitePostcontent;
    
    @Column(name="site_post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sitePostDate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sitePost", fetch = FetchType.LAZY)
    private Set<SiteComment> siteComments;

    public long getSitePostId() {
        return sitePostId;
    }

    public void setSitePostId(long sitePostId) {
        this.sitePostId = sitePostId;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }

    public String getSitePostTitle() {
        return sitePostTitle;
    }

    public void setSitePostTitle(String sitePostTitle) {
        this.sitePostTitle = sitePostTitle;
    }

    public String getSitePostcontent() {
        return sitePostcontent;
    }

    public void setSitePostcontent(String sitePostcontent) {
        this.sitePostcontent = sitePostcontent;
    }

    public Date getSitePostDate() {
        return sitePostDate;
    }

    public void setSitePostDate(Date sitePostDate) {
        this.sitePostDate = sitePostDate;
    }

    public Set<SiteComment> getSiteComments() {
        return siteComments;
    }

    public void setSiteComments(Set<SiteComment> siteComments) {
        this.siteComments = siteComments;
    }
    
    public SitePost() {}
    
    public SitePost(SiteUser siteUser) {
        this.cmsUserSite = siteUser.getCmsUserSite();
        this.siteUser = siteUser;
        this.sitePostTitle = "First Post";
        this.sitePostcontent = "Hello World!";
    }

}

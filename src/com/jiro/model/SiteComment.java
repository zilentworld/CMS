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
@Table(name="site_comment")
public class SiteComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="site_comment_id")
    private long siteCommentId;
    
    @ManyToOne
    @JoinColumn(name="cms_user_site_id")
    private CmsUserSite cmsUserSite;
    
    @ManyToOne
    @JoinColumn(name="site_user_id")
    private SiteUser siteUser;
    
    @ManyToOne
    @JoinColumn(name="site_post_id")
    private SitePost sitePost;
    
    @Column(name="site_comment")
    private String siteComment;

    @Column(name="comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;
    
    public long getSiteCommentId() {
        return siteCommentId;
    }

    public void setSiteCommentId(long siteCommentId) {
        this.siteCommentId = siteCommentId;
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

    public SitePost getSitePost() {
        return sitePost;
    }

    public void setSitePost(SitePost sitePost) {
        this.sitePost = sitePost;
    }

    public String getSiteComment() {
        return siteComment;
    }

    public void setSiteComment(String siteComment) {
        this.siteComment = siteComment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    
    
}

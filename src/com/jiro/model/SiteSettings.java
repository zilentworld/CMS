package com.jiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="site_settings")
public class SiteSettings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="site_settings_id")
    private long siteSettingsId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cms_user_site_id")
    private CmsUserSite cmsUserSite;
    @Column(name="banner_img")
    private String bannerImg;
    @Column(name="background_img")
    private String backgroundImg;
    @Column(name="footer_img")
    private String footerImg;
    @Column(name="preview_results")
    private int previewResults;
    
    public long getSiteSettingsId() {
        return siteSettingsId;
    }
    public void setSiteSettingsId(long siteSettingsId) {
        this.siteSettingsId = siteSettingsId;
    }
    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }
    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }
    public String getBannerImg() {
        return bannerImg;
    }
    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }
    public String getBackgroundImg() {
        return backgroundImg;
    }
    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }
    public String getFooterImg() {
        return footerImg;
    }
    public void setFooterImg(String footerImg) {
        this.footerImg = footerImg;
    }
    public int getPreviewResults() {
        return previewResults;
    }
    public void setPreviewResults(int previewResults) {
        this.previewResults = previewResults;
    }
    
    public SiteSettings(){}
    
    public SiteSettings(CmsUserSite cmsUserSite) {
        System.out.println("siteSettings:cmsUserSiteId:"+cmsUserSite.getCmsUserSiteId());
        this.cmsUserSite = cmsUserSite;
        this.previewResults = 5;
        this.bannerImg = cmsUserSite.getCmsTemplates().getDefaultBannerImg();
        this.footerImg = cmsUserSite.getCmsTemplates().getDefaultFooterImg();
        this.backgroundImg = cmsUserSite.getCmsTemplates().getDefaultBackgroundImg();
    }
}

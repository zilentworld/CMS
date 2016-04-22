package com.jiro.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cms_templates")
public class CmsTemplates {
    
    @Id
    @Column(name="template_id")
    private long templateId;
    @Column(name="template_name")
    private String templateName;
    @Column(name="webpath")
    private String webpath;
    @Column(name="template_img_name")
    private String templateImgName;
    @Column(name="default_banner_img")
    private String defaultBannerImg;
    @Column(name="default_footer_img")
    private String defaultFooterImg;
    @Column(name="default_background_img")
    private String defaultBackgroundImg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmsTemplates", fetch = FetchType.LAZY)
    private Set<CmsUserSite> cmsUserSites;
    
    public String getDefaultFooterImg() {
        return defaultFooterImg;
    }
    public void setDefaultFooterImg(String defaultFooterImg) {
        this.defaultFooterImg = defaultFooterImg;
    }
    public String getDefaultBackgroundImg() {
        return defaultBackgroundImg;
    }
    public void setDefaultBackgroundImg(String defaultBackgroundImg) {
        this.defaultBackgroundImg = defaultBackgroundImg;
    }
    public String getDefaultBannerImg() {
        return defaultBannerImg;
    }
    public void setDefaultBannerImg(String defaultBannerImg) {
        this.defaultBannerImg = defaultBannerImg;
    }
    public long getTemplateId() {
        return templateId;
    }
    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }
    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getWebpath() {
        return webpath;
    }
    public void setWebpath(String webpath) {
        this.webpath = webpath;
    }
    public String getTemplateImgName() {
        return templateImgName;
    }
    public void setTemplateImgName(String templateImgName) {
        this.templateImgName = templateImgName;
    }
    public Set<CmsUserSite> getCmsUserSites() {
        return cmsUserSites;
    }
    public void setCmsUserSites(Set<CmsUserSite> cmsUserSites) {
        this.cmsUserSites = cmsUserSites;
    }
        
}

package com.jiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    
}

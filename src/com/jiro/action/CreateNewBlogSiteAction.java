package com.jiro.action;

import com.jiro.service.CmsTemplatesService;
import com.opensymphony.xwork2.ActionSupport;

public class CreateNewBlogSiteAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsTemplatesService cmsTemplatesService;
    private String imgSrc;

    public String getImgSrc() {
        return imgSrc;
    }
    
    public CmsTemplatesService getCmsTemplatesService() {
        return cmsTemplatesService;
    }

    public void setCmsTemplatesService(CmsTemplatesService cmsTemplatesService) {
        this.cmsTemplatesService = cmsTemplatesService;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
        
    @Override
    public String execute() throws Exception {
        return "";
    }
    
    public String showTemplate() {
        System.out.println("SHOW TEMPLATE");
        return SUCCESS;
    }
    
    public String pickTemplate() {
        cmsTemplatesService.getByImgSrc(imgSrc);
        return SUCCESS;
    }
}

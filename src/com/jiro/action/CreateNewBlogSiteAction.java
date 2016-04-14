package com.jiro.action;

import com.jiro.model.CmsTemplates;
import com.jiro.service.CmsTemplatesService;
import com.opensymphony.xwork2.ActionSupport;

public class CreateNewBlogSiteAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsTemplates cmsTemplates;
    private CmsTemplatesService cmsTemplatesService;
    private String imgSrc;
    private String errMsg;

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
            
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
        
    public CmsTemplates getCmsTemplates() {
        return cmsTemplates;
    }

    public void setCmsTemplates(CmsTemplates cmsTemplates) {
        this.cmsTemplates = cmsTemplates;
    }

    public String showTemplate() {
        System.out.println("SHOW TEMPLATE");
        return SUCCESS;
    }
    
    @Override
    public String execute() throws Exception {
        cmsTemplates = cmsTemplatesService.getByImgSrc(imgSrc);
        if(cmsTemplates == null) {
            errMsg = "An error occured. Kindly pick a template again.";
            return ERROR;
        }
        System.out.println(cmsTemplates.getTemplateName());
        return SUCCESS;
    }
}

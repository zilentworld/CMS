package com.jiro.action.cms;

import com.jiro.action.site.SiteAbstractAction;
import com.jiro.model.cms.CmsTemplates;
import com.jiro.service.cms.CmsTemplatesService;

public class CreateNewBlogSiteAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsTemplates cmsTemplates;
    private CmsTemplatesService cmsTemplatesService;
    private String imgSrc;
    private String errMsg;
    private long cmsTemplateId;

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
        
    public long getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(long cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("createNewBlogSite:imgSrc:"+imgSrc);
        cmsTemplates = cmsTemplatesService.getByImgSrc(imgSrc);
        if(cmsTemplates == null) {
            errMsg = "An error occured. Kindly pick a template again.";
            return ERROR;
        }
        System.out.println(cmsTemplates.getTemplateName());
//        getSessionMap().put(Constants.CMS_SESSION_CMS_TEMPLATE, cmsTemplates);
        cmsTemplateId = cmsTemplates.getTemplateId();
        
        return SUCCESS;
    }

    @Override
    public void validate() {
        // TODO Auto-generated method stub        
    }

}

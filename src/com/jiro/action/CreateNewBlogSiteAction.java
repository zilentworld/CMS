package com.jiro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.CmsTemplates;
import com.jiro.service.CmsTemplatesService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class CreateNewBlogSiteAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsTemplates cmsTemplates;
    private CmsTemplatesService cmsTemplatesService;
    private String imgSrc;
    private String errMsg;
    private Map<String, Object> sessionMap;

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
        sessionMap.put(Constants.CMS_SESSION_CMS_TEMPLATE, cmsTemplates);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}

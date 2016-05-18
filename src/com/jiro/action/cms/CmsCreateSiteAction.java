package com.jiro.action.cms;

import com.jiro.model.cms.CmsTemplates;
import com.jiro.model.cms.CmsUser;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsTemplatesService;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class CmsCreateSiteAction extends ActionSupport implements SessionAware {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private CmsTemplatesService cmsTemplatesService;
    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    private CmsTemplates cmsTemplates;
    private String urlName;
    private String imgSrc;
    private String errMsg;
    private long cmsTemplateId;
    private String sourcePage;
    private Map<String, Object> sessionMap;

    @SkipValidation
    public String showTemplate() {
        System.out.println("SHOW TEMPLATE");
        return SUCCESS;
    }

    @SkipValidation
    public String pickTemplate() {
        System.out.println("createNewBlogSite:imgSrc:" + imgSrc);
        cmsTemplates = cmsTemplatesService.getByImgSrc(imgSrc);
        if (cmsTemplates == null) {
            errMsg = "An error occured. Kindly pick a template again.";
            return ERROR;
        }
        System.out.println(cmsTemplates.getTemplateName());
        cmsTemplateId = cmsTemplates.getTemplateId();

        return SUCCESS;
    }

    @SkipValidation
    public String showUrlEntry() {
        System.out.println("showURL");
        System.out.println("createSiteAction:execute:showUrlEntry:"+cmsTemplateId);
        return SUCCESS;
    }

    public String processUrl() {
        System.out.println("createSiteAction:execute:urlName:"+urlName);
        System.out.println("createSiteAction:execute:cmsTemplateId:"+cmsTemplateId);
        CmsUser cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
        if(cmsUser == null) {
            sourcePage = "ProcessNewSite";
            return LOGIN;
        }

        return SUCCESS;
    }

    @SkipValidation
    public String processNewSite() {
        System.out.println("processNewSite:urlName:"+urlName);
        System.out.println("processNewSite:cmsTemplateId:"+cmsTemplateId);
        CmsUser cmsUser = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
        System.out.println("processNewSite:cmsUsername:"+cmsUser.getCmsUsername());
        cmsUserSiteService.createNewCmsUserSite(cmsUser.getCmsUserId(),urlName,cmsTemplateId);

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (cmsUserSiteService.checkBlogUrl(urlName)) {
            addFieldError("urlName", Constants.CMS_ERROR_BLOG_URL_TAKEN);
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(String sourcePage) {
        this.sourcePage = sourcePage;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getImgSrc() {
        return imgSrc;
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

    public long getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(long cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }
}

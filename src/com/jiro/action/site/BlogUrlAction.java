package com.jiro.action.site;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUser;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsTemplatesService;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class BlogUrlAction extends ActionSupport implements SessionAware {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    @Autowired
    private CmsTemplatesService cmsTemplatesService;
    private String cmsTemplateId;
    private String msgError;
    private Map<String, Object> sessionMap;
    private CmsUserSite cmsUserSite;
    private String nextAction;
    private String msg;

    @Override
    public String execute() throws Exception {
        cmsUserSite.setCmsUser((CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER));
        System.out.println("cmsusersite:cmsuser:" + ((CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER)).getCmsUserId());

        cmsUserSite.setCmsTemplates(cmsTemplatesService.getById(Long.parseLong(cmsTemplateId)));
        if (!cmsUserSiteService.saveNewUserSite(cmsUserSite)) {
            msgError = Constants.CMS_ERROR_BLOG_URL_TAKEN;
            return ERROR;
        }

        CmsFileController.generateFiles(cmsUserSite);

        msg = "Your site is waiting for publication";

//        nextAction = "home-" + cmsUserSite.getCmsTemplates().getTemplateName().toLowerCase();
//        System.out.println("resultMsg:"+nextAction);

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (cmsUserSiteService.checkBlogUrl(cmsUserSite.getBlogUrl())) {
            addFieldError("cmsUserSite.blogUrl", Constants.CMS_ERROR_BLOG_URL_TAKEN);
        }
        try {
            Long.parseLong(cmsTemplateId);
        } catch (Exception e) {
            addFieldError("cmsUserSite.blogUrl", Constants.CMS_ERROR_GENERIC_ERROR);
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public String getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(String cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

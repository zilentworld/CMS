package com.jiro.action.site;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUser;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsTemplatesService;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class BlogUrlAction extends ActionSupport implements SessionAware {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String cmsTemplateId;
    private String msgError;
    private Map<String, Object> sessionMap;
    private CmsUserSite cmsUserSite;
    private CmsUserSiteService cmsUserSiteService;
    private CmsTemplatesService cmsTemplatesService;
    private String nextAction;
    private String msg;
    private CmsFileController cmsFileController;

    public CmsFileController getCmsFileController() {
        return cmsFileController;
    }

    public void setCmsFileController(CmsFileController cmsFileController) {
        this.cmsFileController = cmsFileController;
    }

    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }

    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
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

    public CmsTemplatesService getCmsTemplatesService() {
        return cmsTemplatesService;
    }

    public void setCmsTemplatesService(CmsTemplatesService cmsTemplatesService) {
        this.cmsTemplatesService = cmsTemplatesService;
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

    @Override
    public String execute() throws Exception {
        cmsUserSite.setCmsUser((CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER));
        System.out.println("cmsusersite:cmsuser:" + ((CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER)).getCmsUserId());

        cmsUserSite.setCmsTemplates(cmsTemplatesService.get(Long.parseLong(cmsTemplateId)));
        if (!cmsUserSiteService.saveNewUserSite(cmsUserSite)) {
            msgError = Constants.CMS_ERROR_BLOG_URL_TAKEN;
            return ERROR;
        }

        cmsFileController.generateFiles(cmsUserSite);

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

}

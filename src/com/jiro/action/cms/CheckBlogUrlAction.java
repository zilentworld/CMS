package com.jiro.action.cms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckBlogUrlAction extends ActionSupport implements SessionAware {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    private Map<String, Object> sessionMap;
    private String blogSiteUrl;
    private String nextAction;
    private String test;
    private String msg;

    @Override
    public String execute() throws Exception {
        System.out.println("checkBlogUrl");
        HttpServletRequest request = ServletActionContext.getRequest();
        if (blogSiteUrl == null || blogSiteUrl == "")
            blogSiteUrl = request.getServletPath().substring(1);

        CmsUserSite cmsUserSite = cmsUserSiteService.getByUrl(blogSiteUrl);
        if (cmsUserSite == null) {
            msg = Constants.CMS_ERROR_SITE_NOT_EXIST;
            return ERROR;
        }

        if (cmsUserSite.getIsPublished() == 0) {
            msg = Constants.CMS_ERROR_SITE_NOT_PUBLISH;
            return ERROR;
        }
        System.out.println("checkBlogUrl:blogSiteUrl:" + blogSiteUrl);

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }

    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

}

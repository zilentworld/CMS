package com.jiro.action.cms;

import com.jiro.model.cms.CmsUser;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by dev-pc on 5/6/16.
 */
public class CmsNavAction extends ActionSupport implements SessionAware {

    private Map<String, Object> sessionmap;

    public String showHome() {
        return SUCCESS;
    }

    public String showAbout() {
        return SUCCESS;
    }

    public String showContactUs() {
        return SUCCESS;
    }

    public String showAccount() {
        CmsUser cmsUser = (CmsUser) sessionmap.get(Constants.CMS_SESSION_CMS_USER);
        if(cmsUser != null && cmsUser.getCmsUserId() > 0) {
            return SUCCESS;
        }
        else
            return LOGIN;
    }

    @Override
    public void setSession(Map<String, Object> sessionmap) {
        this.sessionmap = sessionmap;
    }
}

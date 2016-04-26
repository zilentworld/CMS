package com.jiro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.SiteSettings;
import com.jiro.service.SiteSettingsService;
import com.jiro.utility.Constants;

public class SiteImageAction extends SiteAbstractAction implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SiteSettings siteSettings;
    private SiteSettingsService siteSettingsService;
    private Map<String, Object> sessionMap;
    
    public SiteSettingsService getSiteSettingsService() {
        return siteSettingsService;
    }
    public void setSiteSettingsService(SiteSettingsService siteSettingsService) {
        this.siteSettingsService = siteSettingsService;
    }
    public SiteSettings getSiteSettings() {
        return siteSettings;
    }
    public void setSiteSettings(SiteSettings siteSettings) {
        this.siteSettings = siteSettings;
    }
    
    @Override
    public String execute() throws Exception {
        String blogUrl = (String) sessionMap.get(Constants.CMS_SESSION_BLOG_URL);
        System.out.println("PASOK SA IMG:"+blogUrl);
        siteSettings = siteSettingsService.getByUrl(blogUrl);
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    
}

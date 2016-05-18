package com.jiro.action.site;

import com.jiro.model.site.SiteSettings;
import com.jiro.service.site.SiteSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SiteImageAction extends SiteAbstractAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private SiteSettingsService siteSettingsService;
    private SiteSettings siteSettings;

    @Override
    public String execute() throws Exception {
        System.out.println("PASOK SA IMG:" + getBlogSiteUrl());
        siteSettings = siteSettingsService.getByUrl(getBlogSiteUrl());
        return SUCCESS;
    }

    public SiteSettings getSiteSettings() {
        return siteSettings;
    }

    public void setSiteSettings(SiteSettings siteSettings) {
        this.siteSettings = siteSettings;
    }
}

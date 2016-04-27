package com.jiro.action.cms;

import com.jiro.action.site.SiteAbstractAction;
import com.jiro.model.site.SitePost;
import com.jiro.service.site.SitePostService;

public class NewSitePostAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePostService sitePostService;
    private SitePost sitePost;
        
    public SitePostService getSitePostService() {
        return sitePostService;
    }

    public void setSitePostService(SitePostService sitePostService) {
        this.sitePostService = sitePostService;
    }

    public SitePost getSitePost() {
        return sitePost;
    }

    public void setSitePost(SitePost sitePost) {
        this.sitePost = sitePost;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return super.execute();
    }

    @Override
    public void validate() {
        // TODO Auto-generated method stub
        super.validate();
    }

}

package com.jiro.action.site;

import com.jiro.utility.Constants;

public class SiteLogoutAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        getSessionMap().remove(Constants.SITE_SESSION_SITE_USER_ID);
        getSessionMap().remove(Constants.SITE_SESSION_SITE_USER_NAME);
        
        String nextAction = "home" + getSiteTemplate();
        setNextAction(nextAction);
        System.out.println("logout:"+nextAction);
        System.out.println("siteLogoutAction:execute:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }

}

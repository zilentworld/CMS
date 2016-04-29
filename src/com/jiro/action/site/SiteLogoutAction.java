package com.jiro.action.site;

import java.util.HashMap;
import java.util.Map;

import com.jiro.utility.Constants;


public class SiteLogoutAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        System.out.println("siteLogout:blogSite:"+getBlogSiteUrl());
        
        Map<String, Object> sessionVars = 
                (HashMap<String, Object>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        
        sessionVars.remove(getBlogSiteUrl());
        
        String nextAction = "home" + getSiteTemplate();
        setNextAction(nextAction);
        System.out.println("logout:"+nextAction);
        System.out.println("siteLogoutAction:execute:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }

}

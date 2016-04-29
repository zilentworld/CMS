package com.jiro.action.site;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiro.model.site.SiteComment;
import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SiteCommentService;
import com.jiro.utility.Constants;

public class SiteUserComments extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<SiteComment> userSiteComments;
    private SiteCommentService siteCommentService;
    
    public List<SiteComment> getUserSiteComments() {
        return userSiteComments;
    }

    public void setUserSiteComments(List<SiteComment> userSiteComments) {
        this.userSiteComments = userSiteComments;
    }

    public SiteCommentService getSiteCommentService() {
        return siteCommentService;
    }

    public void setSiteCommentService(SiteCommentService siteCommentService) {
        this.siteCommentService = siteCommentService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        Map<String, Object> varMap = (HashMap<String, Object>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        SiteUser sU = (SiteUser) varMap.get(getBlogSiteUrl());
        long userId = sU.getSiteUserId();
        userSiteComments = siteCommentService.getUserComment(userId, getBlogSiteUrl());
        setNextAction("siteUserComments" + getSiteTemplate());
        System.out.println("siteUserComments:listSize:"+userSiteComments.size());
        
        return SUCCESS;
    }    

}
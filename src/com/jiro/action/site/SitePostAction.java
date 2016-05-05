package com.jiro.action.site;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.site.SitePost;
import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SitePostService;
import com.jiro.utility.Constants;

public class SitePostAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePostService sitePostService;
    private SitePost sitePost;
    private String postType;
    private long postId;
    private String msg;
                
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

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
    
    @SkipValidation
    public String showNewSitePost() {
        setNextAction(getBlogSiteUrl() + "/newSitePost");
        
        return SUCCESS;
    }
    
    @SkipValidation
    public String editSitePost() {
        sitePost = sitePostService.getById(postId);
        setNextAction(getBlogSiteUrl() + "/newSitePost");
        
        return SUCCESS;
    }

    @SkipValidation
    public String deleteSitePost() {
        sitePostService.deleteSitePostById(postId);
        setNextAction(getBlogSiteUrl() + "/home");
        System.out.println("deleteSitePost:nextAction:"+getNextAction());
        
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        Map<String, Object> varMap = (HashMap<String, Object>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        SiteUser sU = (SiteUser) varMap.get(getBlogSiteUrl());
        sitePost.setSiteUser(sU);
        sitePost.setCmsUserSite(getCmsUserSite());
        if("edit".equals(postType)){
            sitePostService.updateSitePost(sitePost);
            postId = sitePost.getSitePostId();
            return SUCCESS;
        } else {
            postId = sitePostService.newSitePost(sitePost);
            if(postId > 0)
                return SUCCESS;
            else {
                msg = Constants.SITE_ERROR_NEW_POST_ERROR;
                return ERROR;
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public void validate() {
        Map<String, Object> varMap = (HashMap<String, Object>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        
        if(!varMap.containsKey(getBlogSiteUrl())) {
            addFieldError("sitePost.sitePostTitle", Constants.SITE_ERROR_NEW_POST_USER_EMPTY);
        } else {
            SiteUser sU = (SiteUser) varMap.get(getBlogSiteUrl());
            if(sU == null || sU.getSiteUserId() <= 0) {
                addFieldError("sitePost.sitePostTitle", Constants.SITE_ERROR_NEW_POST_USER_EMPTY);
            }
        }
        
        if(StringUtils.isEmpty(sitePost.getSitePostTitle())) {
            addFieldError("sitePost.sitePostTitle", Constants.SITE_ERROR_NEW_POST_TITLE_EMPTY);
        }
        if(StringUtils.isEmpty(sitePost.getSitePostContent())) {
            addFieldError("sitePost.sitePostContent", Constants.SITE_ERROR_NEW_POST_CONTENT_EMPTY);
        }
    }

}

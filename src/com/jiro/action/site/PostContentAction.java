package com.jiro.action.site;

import com.jiro.model.site.SitePost;
import com.jiro.service.site.SitePostService;

public class PostContentAction extends SiteAbstractAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePost sitePost;
    private SitePostService sitePostService;
    private String postId;
    
    public SitePostService getSitePostService() {
        return sitePostService;
    }
    public void setSitePostService(SitePostService sitePostService) {
        this.sitePostService = sitePostService;
    }
    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public SitePost getSitePost() {
        return sitePost;
    }
    public void setSitePost(SitePost sitePost) {
        this.sitePost = sitePost;
    }
    
    @Override
    public String execute() throws Exception {
        System.out.println("postContent:postId:"+postId);
        sitePost = sitePostService.getById(Long.parseLong(postId));
//        String nextAction = "postContent-" + sitePost.getCmsUserSite().getCmsTemplates().getTemplateName().toLowerCase();
        String nextAction = "postContent" + getSiteTemplate();
        setNextAction(nextAction);
        System.out.println("postContentAction:execute:blogSiteUrl:"+getBlogSiteUrl());
        System.out.println("postContentAction:execute:nextAction:"+getNextAction());
        
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        // TODO Auto-generated method stub
    }
    
}

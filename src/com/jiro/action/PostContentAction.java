package com.jiro.action;

import com.jiro.model.SitePost;
import com.jiro.service.SitePostService;

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
        String nextAction = "postContent-" + sitePost.getCmsUserSite().getCmsTemplates().getTemplateName().toLowerCase();
        setNextAction(nextAction);
        return SUCCESS;
    }
}

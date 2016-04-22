package com.jiro.action;

import java.util.List;

import com.jiro.model.SitePost;
import com.jiro.service.SitePostService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogPostAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePostService sitePostService;
    private List<SitePost> postPreviewList;
    private String blogSiteUrl;
    private String nextAction;
        
    public String getNextAction() {
        return nextAction;
    }
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }
    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }
    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }
    public List<SitePost> getPostPreviewList() {
        return postPreviewList;
    }
    public void setPostPreviewList(List<SitePost> postPreviewList) {
        this.postPreviewList = postPreviewList;
    }
    public SitePostService getSitePostService() {
        return sitePostService;
    }
    public void setSitePostService(SitePostService sitePostService) {
        this.sitePostService = sitePostService;
    }
    
    @Override
    public String execute() throws Exception {
        System.out.println("blogPostAction:"+blogSiteUrl);
        postPreviewList = sitePostService.getPostPreview(blogSiteUrl, 0, 5);
        return SUCCESS;
    }
    
}

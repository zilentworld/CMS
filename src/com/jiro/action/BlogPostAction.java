package com.jiro.action;

import java.util.List;

import com.jiro.model.SitePost;
import com.jiro.service.SitePostService;

public class BlogPostAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePostService sitePostService;
    private List<SitePost> postPreviewList;
     
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
        System.out.println("blogPostAction:"+getBlogSiteUrl());
        postPreviewList = sitePostService.getPostPreview(getBlogSiteUrl(), 0, 5);
        return SUCCESS;
    }
    
}

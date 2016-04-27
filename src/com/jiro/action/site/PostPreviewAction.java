package com.jiro.action.site;

import java.util.List;

import com.jiro.model.site.SitePost;
import com.jiro.service.site.SitePostService;

public class PostPreviewAction extends SiteAbstractAction {

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
        String blogUrl = getBlogSiteUrl();
        System.out.println("postPreview:blogPostAction:"+blogUrl);
        postPreviewList = sitePostService.getPostPreview(blogUrl, 0, 5);
        System.out.println("postPreviewList:size:"+postPreviewList.size());
        System.out.println("postPreviewAction:execute:nextAction:"+getNextAction());
        System.out.println("postPreviewAction:execute:blogSiteUrl:"+getBlogSiteUrl());
        
        return SUCCESS;
    }
    
}

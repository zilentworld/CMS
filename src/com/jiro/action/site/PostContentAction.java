package com.jiro.action.site;

import java.util.List;

import com.jiro.model.site.SiteComment;
import com.jiro.model.site.SitePost;
import com.jiro.service.site.SiteCommentService;
import com.jiro.service.site.SitePostService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostContentAction extends SiteAbstractAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private SitePostService sitePostService;
    @Autowired
    private SiteCommentService siteCommentService;
    private SitePost sitePost;
    private List<SiteComment> siteComments;
    private String postId;

    @Override
    public String execute() throws Exception {
        System.out.println("postContent:postId:" + postId);
        sitePost = sitePostService.getById(Long.parseLong(postId));
        siteComments = siteCommentService.getPostComments(sitePost.getSitePostId());
        setNextAction(getBlogSiteUrl() + "/postContent");
        System.out.println("postContentAction:execute:blogSiteUrl:" + getBlogSiteUrl());
        System.out.println("postContentAction:execute:nextAction:" + getNextAction());

        return SUCCESS;
    }

    public List<SiteComment> getSiteComments() {
        return siteComments;
    }

    public void setSiteComments(List<SiteComment> siteComments) {
        this.siteComments = siteComments;
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
}

package com.jiro.action.site;

import java.util.HashMap;
import java.util.Map;

import com.jiro.model.site.SiteComment;
import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SiteCommentService;
import com.jiro.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SiteCommentAction extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private SiteCommentService siteCommentService;
    private SiteComment siteComment;
    private String commentType;
    private long postId;
    private long commentId;

    public String deleteComment() {
        siteCommentService.deleteCommentById(commentId);
        setNextAction(getBlogSiteUrl() + "/postContent");
        System.out.println("siteComment:nextAction:"+getNextAction());
        
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        System.out.println("siteCommentAction:execute:");
        Map<String, Object> varMap = (HashMap<String, Object>) getSessionMap().get(Constants.SITE_SESSION_MAP_VARIABLE);
        SiteUser sU = (SiteUser) varMap.get(getBlogSiteUrl());
        siteComment.setSiteUser(sU);
        siteComment.setCmsUserSite(getCmsUserSite());
        System.out.println("siteCommentAction:execute:siteCommentContent:"+siteComment.getSiteCommentContent());
        if("edit".equals(commentType)) {
            System.out.println("siteCommentAction:execute:edit:");
            siteCommentService.updateComment(siteComment);
        } else {
            System.out.println("siteCommentAction:execute:save:");
            siteCommentService.saveNewComment(siteComment);
        }
        postId = siteComment.getSitePost().getSitePostId();
        
        return SUCCESS;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public SiteComment getSiteComment() {
        return siteComment;
    }

    public void setSiteComment(SiteComment siteComment) {
        this.siteComment = siteComment;
    }

}

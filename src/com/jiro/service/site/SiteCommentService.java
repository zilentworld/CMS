package com.jiro.service.site;

import java.util.List;

import com.jiro.model.site.SiteComment;

public interface SiteCommentService {
    
    public SiteComment getById(long sitePostId);

    public List<SiteComment> getUserComment(long siteUserId, String siteUrl);
    
    public List<SiteComment> getPostComments(long postId);
    
    public List<SiteComment> getCommentList();
    
    public long saveNewComment(SiteComment siteComment);
    
    public void updateComment(SiteComment siteComment);
    
    public void deleteComment(SiteComment siteComment);
    
    public void deleteCommentById(long commentId);

}

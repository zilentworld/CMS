package com.jiro.site.service;

import java.util.List;

import com.jiro.site.model.SiteComment;

public interface SiteCommentService {
    
    public SiteComment getById(long sitePostId);
    
    public List<SiteComment> getUserComment(long siteUserId);
    
    public List<SiteComment> getCommentList();

}

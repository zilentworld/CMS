package com.jiro.service.site;

import java.util.List;

import com.jiro.model.site.SiteComment;

public interface SiteCommentService {
    
    public SiteComment getById(long sitePostId);
    
    public List<SiteComment> getUserComment(long siteUserId);
    
    public List<SiteComment> getCommentList();

}

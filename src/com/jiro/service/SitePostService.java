package com.jiro.service;

import java.util.List;

import com.jiro.model.SitePost;
import com.jiro.model.SiteUser;

public interface SitePostService {

    public SitePost getById(long sitePostId);

    public List<SitePost> getList();

    public List<SitePost> getUserPost(long siteUserId);
    
    public List<SitePost> getPostPreview(String siteUrl, int currPage, int maxResults);
    
    public SitePost siteFirstPost(SiteUser siteUser);

}

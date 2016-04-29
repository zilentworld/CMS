package com.jiro.service.site.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.site.SitePostDao;
import com.jiro.model.site.SitePost;
import com.jiro.model.site.SiteUser;
import com.jiro.service.site.SitePostService;

@Service
public class SitePostServiceImpl implements SitePostService {
    
    @Autowired
    private SitePostDao sitePostDao;

    public void setSitePostDao(SitePostDao sitePostDao) {
        this.sitePostDao = sitePostDao;
    }

    @Override
    public SitePost getById(long sitePostId) {
        return sitePostDao.getById(sitePostId);
    }

    @Override
    public List<SitePost> getList() {
        return sitePostDao.getList();
    }

    @Override
    public List<SitePost> getUserPost(long siteUserId) {
        return sitePostDao.getUserPost(siteUserId);
    }

    @Override
    public List<SitePost> getPostPreview(String siteUrl, int currPage, int maxResults) {
        return sitePostDao.getPostPreview(siteUrl, currPage, maxResults);
    }

    @Override
    public SitePost siteFirstPost(SiteUser siteUser) {
        if(siteUser == null)
            return null;
        SitePost sitePost = new SitePost(siteUser);
        if(sitePostDao.persist(sitePost) > 0)
            return sitePost;
        else
            return null;
    }

    @Override
    public long newSitePost(SitePost sitePost) {
        return sitePostDao.persist(sitePost);
    }
    
    @Override
    public void updateSitePost(SitePost sitePost) {
        sitePostDao.saveOrUpdate(sitePost);
    }
    
    @Override
    public void deleteSitePost(SitePost sitePost) {
        sitePostDao.delete(sitePost);
    }
    
    @Override
    public void deleteSitePostById(long postId) {
        sitePostDao.delete(sitePostDao.getById(postId));
    }
    
}

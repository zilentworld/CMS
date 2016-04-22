package com.jiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.SitePostDao;
import com.jiro.model.SitePost;
import com.jiro.model.SiteUser;

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

}

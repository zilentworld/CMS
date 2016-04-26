package com.jiro.service.site.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiro.dao.site.SiteCommentDao;
import com.jiro.model.site.SiteComment;
import com.jiro.service.site.SiteCommentService;

public class SiteCommentServiceImpl implements SiteCommentService {
    
    @Autowired
    private SiteCommentDao siteCommentDao;
    
    public void setSiteCommentDao(SiteCommentDao siteCommentDao) {
        this.siteCommentDao = siteCommentDao;
    }

    @Override
    public SiteComment getById(long sitePostId) {
        return siteCommentDao.getById(sitePostId);
    }

    @Override
    public List<SiteComment> getUserComment(long siteUserId) {
        return siteCommentDao.getUserComment(siteUserId);
    }

    @Override
    public List<SiteComment> getCommentList() {
        return siteCommentDao.getCommentList();
    }

}

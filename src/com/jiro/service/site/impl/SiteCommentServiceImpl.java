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
    public List<SiteComment> getUserComment(long siteUserId, String siteUrl) {
        return siteCommentDao.getUserComment(siteUserId, siteUrl);
    }

    @Override
    public List<SiteComment> getCommentList() {
        return siteCommentDao.getCommentList();
    }

    @Override
    public long saveNewComment(SiteComment siteComment) {
        return siteCommentDao.persist(siteComment);
    }

    @Override
    public void updateComment(SiteComment siteComment) {
        siteCommentDao.saveOrUpdate(siteComment);
    }

    @Override
    public void deleteComment(SiteComment siteComment) {
        siteCommentDao.delete(siteComment);
    }

    @Override
    public void deleteCommentById(long commentId) {
        siteCommentDao.delete(siteCommentDao.getById(commentId));
    }
    
    @Override
    public List<SiteComment> getPostComments(long postId) {
        return siteCommentDao.getPostComments(postId);
    }

}

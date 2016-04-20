package com.jiro.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.SiteComment;

@Repository
public class SiteCommentDao extends GenericDaoImpl {
    
    @Transactional
    public SiteComment getById(long sitePostId) {
        return (SiteComment) super.get(SiteComment.class, sitePostId);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<SiteComment> getUserComment(long siteUserId) {
        return getCurrentSession()
               .createCriteria(SiteComment.class)
               .add(Restrictions.eq("siteUserId", siteUserId))
               .list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<SiteComment> getCommentList() {
        return (List<SiteComment>) super.getList(SiteComment.class);
    }

}

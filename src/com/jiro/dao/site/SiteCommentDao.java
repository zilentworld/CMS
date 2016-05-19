package com.jiro.dao.site;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.site.SiteComment;

@Repository
public class SiteCommentDao extends GenericDaoImpl {
    
    @Transactional
    public SiteComment getById(long sitePostId) {
        return (SiteComment) super.get(SiteComment.class, sitePostId);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<SiteComment> getUserComment(long siteUserId, String siteUrl) {
        return getCurrentSession()
               .createCriteria(SiteComment.class)
               .addOrder(Order.desc("commentDate"))
               .createAlias("siteUser", "siteUser")
               .add(Restrictions.eq("siteUser.siteUserId", siteUserId))
               .createAlias("cmsUserSite", "cmsUserSite")
               .add(Restrictions.eq("cmsUserSite.blogUrl", siteUrl))
               .list();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<SiteComment> getPostComments(long postId) {
        return getCurrentSession()
               .createCriteria(SiteComment.class)
               .createAlias("sitePost", "site_post")
               .add(Restrictions.eq("sitePost.sitePostId", postId))
                .addOrder(Order.desc("commentDate"))
               .list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<SiteComment> getCommentList() {
        return (List<SiteComment>) super.getList(SiteComment.class);
    }

}

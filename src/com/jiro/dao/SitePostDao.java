package com.jiro.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.SitePost;

@Repository
public class SitePostDao extends GenericDaoImpl {

    @Transactional
    public SitePost getById(long sitePostId) {
        return (SitePost) super.get(SitePostDao.class,sitePostId);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<SitePost> getUserPost(long siteUserId) {
        return getCurrentSession()
               .createCriteria(SitePost.class)
               .add(Restrictions.eq("siteUserId", siteUserId))
               .list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<SitePost> getList() {
        return (List<SitePost>) super.getList(SitePost.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<SitePost> getPostPreview(String siteUrl, int currPage, int maxResults) {
        return (List<SitePost>) getCurrentSession()
                .createCriteria(SitePost.class)
                .addOrder(Order.desc("sitePostId"))
                .createAlias("cmsUserSite", "cmsUserSite")
                .add(Restrictions.eq("cmsUserSite.blogUrl", siteUrl))
                .setFirstResult(maxResults * (currPage-1))
                .setMaxResults(maxResults)
                .list();
    }
    
}

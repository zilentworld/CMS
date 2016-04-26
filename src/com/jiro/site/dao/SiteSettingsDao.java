package com.jiro.site.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.site.model.SiteSettings;

@Repository
public class SiteSettingsDao extends GenericDaoImpl {
    
    @Transactional
    public SiteSettings getById(long siteSettingsId) {
        return (SiteSettings) super.get(SiteSettings.class, siteSettingsId);
    }

    @Transactional
    public SiteSettings getByUrl(String blogUrl) {
        return (SiteSettings) getCurrentSession()
                              .createCriteria(SiteSettings.class)
                              .createAlias("cmsUserSite", "cmsUserSite")
                              .add(Restrictions.eq("cmsUserSite.blogUrl", blogUrl))
                              .uniqueResult();
    }

}

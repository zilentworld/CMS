package com.jiro.dao.cms;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.jiro.model.cms.CmsUser;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.cms.CmsUserSite;

@Repository
public class CmsUserSiteDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUserSite get(Serializable value) {
        return (CmsUserSite) super.get(CmsUserSite.class, value);
    }
    
    @Transactional
    public CmsUserSite getByUrl(String blogUrl) {
        return (CmsUserSite) getCurrentSession()
                             .createCriteria(CmsUserSite.class)
                             .add(Restrictions.eq("blogUrl", blogUrl))
                             .uniqueResult();
    }

    @Transactional
    public List<CmsUserSite> getList() {
        return (List<CmsUserSite>) super.getList(CmsUserSite.class);
    }

    @Transactional
    public List<CmsUserSite> getByPublished(int publish) {
        List<CmsUserSite> list = (List<CmsUserSite>) getCurrentSession()
                                    .createCriteria(CmsUserSite.class)
                                    .add(Restrictions.eq("isPublished", publish))
                                    .list();

        list.forEach(e -> Hibernate.initialize(e.getSiteLinksPermissions()));
        list.forEach(e -> Collections.sort(e.getSiteLinksPermissions()));

        return list;
    }
    
}

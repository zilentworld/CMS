package com.jiro.dao.cms;

import java.io.Serializable;

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
    
}

package com.jiro.dao;

import java.io.Serializable;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.CmsUserSite;

@Repository
public class CmsUserSiteDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUserSite get(Serializable value) {
        return (CmsUserSite) super.get(CmsUserSite.class, value);
    }
    
    @Transactional
    public CmsUserSite getByUrl(String cmsUrl) {
        return (CmsUserSite) getCurrentSession()
                             .createCriteria(CmsUserSite.class)
                             .add(Restrictions.eq("cmsUrl", cmsUrl))
                             .uniqueResult();
    }
}

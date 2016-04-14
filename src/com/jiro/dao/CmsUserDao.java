package com.jiro.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.CmsUser;

@Repository
public class CmsUserDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUser get(Serializable value) {
        return (CmsUser) super.get(CmsUser.class, value);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<CmsUser> getByDetachedCriteria(DetachedCriteria detachedCriteria) {
        return (List<CmsUser>) detachedCriteria
                        .getExecutableCriteria(getCurrentSession())
                        .list();
    }
}

package com.jiro.dao.cms;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.cms.CmsUser;

@Repository
public class CmsUserDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUser get(Serializable value) {
        return (CmsUser) super.get(CmsUser.class, value);
    }
    
    @Transactional
    public CmsUser getByLogin(String username, String password) {
        return (CmsUser) getCurrentSession()
                         .createCriteria(CmsUser.class)
                         .add(Restrictions.eq("cmsUsername", username))
                         .add(Restrictions.eq("cmsPassword", password))
                         .uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<CmsUser> getByDetachedCriteria(DetachedCriteria detachedCriteria) {
        return (List<CmsUser>) detachedCriteria
                        .getExecutableCriteria(getCurrentSession())
                        .list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<CmsUser> getList() {
        return (List<CmsUser>) super.getList(CmsUser.class);
    }
}

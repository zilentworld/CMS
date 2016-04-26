package com.jiro.dao.site;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.site.SiteUser;

@Repository
public class SiteUserDao extends GenericDaoImpl {

    @Transactional
    public SiteUser getById(long siteUserId) {
        return (SiteUser) super.get(SiteUser.class, siteUserId);
    }
    
    @Transactional
    public SiteUser getByUsername(String siteUsername) {
        return (SiteUser) getCurrentSession()
                          .createCriteria(SiteUser.class)
                          .add(Restrictions.eq("siteUserUsername", siteUsername))
                          .uniqueResult();
    }
    
    @Transactional
    public SiteUser getByLogin(String siteUsername, String sitePassword) {
        return (SiteUser) getCurrentSession()
                          .createCriteria(SiteUser.class)
                          .add(Restrictions.eq("siteUserUsername", siteUsername))
                          .add(Restrictions.eq("siteUserPassword", sitePassword))
                          .uniqueResult();
    }

}

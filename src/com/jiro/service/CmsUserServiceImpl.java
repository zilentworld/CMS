package com.jiro.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.CmsUserDao;
import com.jiro.model.CmsUser;

@Service
public class CmsUserServiceImpl implements CmsUserService {
    
    @Autowired
    CmsUserTypeService cmsUserTypeService;
    @Autowired
    CmsUserDao cmsUserDao;
    
    public CmsUserTypeService getCmsUserTypeService() {
        return cmsUserTypeService;
    }

    public void setCmsUserTypeService(CmsUserTypeService cmsUserTypeService) {
        this.cmsUserTypeService = cmsUserTypeService;
    }

    public CmsUserDao getCmsUserDao() {
        return cmsUserDao;
    }

    public void setCmsUserDao(CmsUserDao cmsUserDao) {
        this.cmsUserDao = cmsUserDao;
    }

    @Override
    public boolean createNewCmsUser(CmsUser cmsUser) {
        if(cmsUserDao.persist(cmsUser) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean checkExistingCmsUser(CmsUser cmsUser) {
        return checkExistingCmsUser(cmsUser.getCmsUsername());
    }

    @Override
    public boolean checkExistingCmsUser(String cmsUsername) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CmsUser.class);
        detachedCriteria.add(Restrictions.eq("cmsUsername", cmsUsername));
        
        List<CmsUser> cmsUserList = cmsUserDao.getByDetachedCriteria(detachedCriteria);
        if(cmsUserList.size() > 0) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean checkLogin(CmsUser cmsUser) {
        if(cmsUserDao.getByLogin(cmsUser.getCmsUsername(), cmsUser.getCmsPassword()) != null)
            return true;
        else 
            return false;        
    }
}
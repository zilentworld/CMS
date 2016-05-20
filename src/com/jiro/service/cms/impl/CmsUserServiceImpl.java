package com.jiro.service.cms.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.cms.CmsUserDao;
import com.jiro.model.cms.CmsUser;
import com.jiro.service.cms.CmsUserService;
import com.jiro.service.cms.CmsUserTypeService;

@Service
public class CmsUserServiceImpl implements CmsUserService {

    @Autowired
    private CmsUserDao cmsUserDao;

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
    public boolean checkLoginUserPass(CmsUser cmsUser) {
        System.out.println("checkLoginUserPass:"+cmsUser.getCmsUsername()+":"+cmsUser.getCmsPassword());
        if(cmsUserDao.getByLogin(cmsUser.getCmsUsername(), cmsUser.getCmsPassword()) != null)
            return true;
        else 
            return false;        
    }
    

    public CmsUser getByLogin(CmsUser cmsUser) {
        return getByLogin(cmsUser.getCmsUsername(), cmsUser.getCmsPassword());
    }
    
    public CmsUser getByLogin(String username, String password) {
        return cmsUserDao.getByLogin(username, password);
    }

    @Override
    public List<CmsUser> getList() {
        return cmsUserDao.getList();
    }

    @Override
    public CmsUser getById(long cmsUserId) {
        return cmsUserDao.get(cmsUserId);
    }

    @Override
    public void updateCmsUser(CmsUser cmsUser) {
        cmsUserDao.saveOrUpdate(cmsUser);
    }

    @Override
    public void setCmsUserStatus(CmsUser cmsUser, boolean status) {
        cmsUser.setIsEnabled(status ? 1 : 0);
        cmsUserDao.saveOrUpdate(cmsUser);
    }
}

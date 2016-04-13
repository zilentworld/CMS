package com.jiro.dao;

import java.io.Serializable;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.CmsTemplates;

@Repository
public class CmsTemplatesDao extends GenericDaoImpl {
    
    @Transactional
    public CmsTemplates get(Serializable value) {
        // TODO Auto-generated method stub
        return (CmsTemplates) super.get(CmsTemplates.class, value);
    }
    
    public CmsTemplates getByImgSrc(String webpath, String imgName) {
        try {
            return (CmsTemplates) getCurrentSession()
                                  .createCriteria(CmsTemplates.class)
                                  .add(Restrictions.eq("webpath", webpath))
                                  .add(Restrictions.eq("templateImgName", imgName))
                                  .uniqueResult();                              
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

package com.jiro.dao.cms;

import java.io.Serializable; 

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.cms.CmsTemplates;

@Repository
public class CmsTemplatesDao extends GenericDaoImpl {
    
    @Transactional
    public CmsTemplates get(Serializable value) {
        return (CmsTemplates) super.get(CmsTemplates.class, value);
    }
    
    @Transactional
    public CmsTemplates getByImgSrc(String webpath, String imgName) {
        System.out.println("dito:w:"+webpath+",i:"+imgName);
        try {
            System.out.println("getbyimgsrc query");
            return (CmsTemplates) getCurrentSession()
                                  .createCriteria(CmsTemplates.class)
                                  .add(Restrictions.eq("webpath", webpath))
                                  .add(Restrictions.eq("templateImgName", imgName))
                                  .uniqueResult();
        } catch (Exception e) {
            System.out.println("getbyimgsrc exception");
            e.printStackTrace();
            return null;
        }
    }
    
}

package com.jiro.dao.cms;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.cms.CmsUserType;

@Repository
public class CmsUserTypeDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUserType get(Serializable value) {
        return (CmsUserType) super.get(CmsUserType.class, value);
    }

}

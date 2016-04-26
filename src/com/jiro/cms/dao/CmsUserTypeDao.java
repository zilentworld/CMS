package com.jiro.cms.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.cms.model.CmsUserType;
import com.jiro.dao.GenericDaoImpl;

@Repository
public class CmsUserTypeDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUserType get(Serializable value) {
        return (CmsUserType) super.get(CmsUserType.class, value);
    }

}

package com.jiro.dao;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.CmsUserType;

public class CmsUserTypeDao extends GenericDaoImpl {
    
    @Transactional
    public CmsUserType get(Serializable value) {
        return (CmsUserType) super.get(CmsUserType.class, value);
    }

}

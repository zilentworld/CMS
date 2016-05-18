package com.jiro.dao.cms;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.cms.CmsTags;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dev-pc on 5/18/16.
 */

@Repository
public class CmsTagsDao extends GenericDaoImpl {

    @Transactional
    public CmsTags getById(long cmsTagsId) {
        return (CmsTags) super.get(CmsTags.class, cmsTagsId);
    }

    @Transactional
    public List<CmsTags> getList() {
        return (List<CmsTags>) super.getList(CmsTags.class);
    }

}

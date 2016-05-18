package com.jiro.service.cms.impl;

import com.jiro.dao.cms.CmsTagsDao;
import com.jiro.service.cms.CmsTagsService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by dev-pc on 5/18/16.
 */
@Service
public class CmsTagsServiceImpl implements CmsTagsService {

    @Autowired
    private CmsTagsDao cmsTagsDao;

    @Override
    public Map<String, String> getCmsTagsMap() {
        Map<String, String> cmsTagsMap = new HashedMap();
        cmsTagsDao.getList().forEach(cmsTags -> cmsTagsMap.put(cmsTags.getTagname(), cmsTags.getTagReplace()));

        return cmsTagsMap;
    }
}

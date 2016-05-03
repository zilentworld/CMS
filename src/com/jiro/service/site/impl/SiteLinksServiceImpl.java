package com.jiro.service.site.impl;

import com.jiro.dao.site.SiteLinksDao;
import com.jiro.model.site.SiteLinks;
import com.jiro.service.site.SiteLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */
@Service
public class SiteLinksServiceImpl implements SiteLinksService {


    @Qualifier("siteLinksDao")
    @Autowired
    private SiteLinksDao siteLinksDao;

    @Override
    public List<String> getHeaderNames() {
        List<String> strList = new ArrayList<String>();
        siteLinksDao.getList().forEach(e -> strList.add(e.getSiteLinkName()));

        return strList;
    }

    @Override
    public List<SiteLinks> getSiteLinks() {
        return siteLinksDao.getList();
    }
}

package com.jiro.dao.site;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.site.SiteLinks;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */

@Repository
public class SiteLinksDao extends GenericDaoImpl {

    @Transactional
    public SiteLinks getById(long siteLinkId) {
        return (SiteLinks) super.get(SiteLinks.class, siteLinkId);
    }

    @Transactional
    public List<SiteLinks> getList() {
        return (List<SiteLinks>) super.getList(SiteLinks.class);
    }

}

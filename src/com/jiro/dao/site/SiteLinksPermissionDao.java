package com.jiro.dao.site;

import com.jiro.dao.GenericDaoImpl;
import com.jiro.model.site.SiteLinksPermission;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */
@Repository
public class SiteLinksPermissionDao extends GenericDaoImpl {

    @Transactional
    public SiteLinksPermission getById(long permissionId) {
        return (SiteLinksPermission) super.get(SiteLinksPermission.class, permissionId);
    }

    public List<SiteLinksPermission> getList() {
        return (List<SiteLinksPermission>) super.getList(SiteLinksPermission.class);
    }

    @Transactional
    public SiteLinksPermission getByOtherIds(long cmsUserSiteId, long siteLinkId) {
        return (SiteLinksPermission) getCurrentSession()
                .createCriteria(SiteLinksPermission.class)
                .createAlias("cmsUserSite", "cmsUserSite")
                .createAlias("siteLinks", "siteLinks")
                .add(Restrictions.eq("cmsUserSite.cmsUserSiteId", cmsUserSiteId))
                .add(Restrictions.eq("siteLinks.siteLinkId", siteLinkId))
                .uniqueResult();
    }

}

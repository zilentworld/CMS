package com.jiro.model.site;

import com.jiro.model.cms.CmsUserSite;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 5/2/16.
 */

@Entity
@Table(name="site_links")
public class SiteLinks {

    @Id
    @Column(name="site_link_id")
    private long siteLinkId;

    @Column(name="site_link_name")
    private String siteLinkName;

    @Column(name="site_link_action")
    private String siteLinkAction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteLinks", fetch = FetchType.LAZY)
    private Set<SiteLinksPermission> siteLinksPermissions;

    public long getSiteLinkId() {
        return siteLinkId;
    }

    public void setSiteLinkId(long siteLinkId) {
        this.siteLinkId = siteLinkId;
    }

    public String getSiteLinkName() {
        return siteLinkName;
    }

    public void setSiteLinkName(String siteLinkName) {
        this.siteLinkName = siteLinkName;
    }

    public String getSiteLinkAction() {
        return siteLinkAction;
    }

    public void setSiteLinkAction(String siteLinkAction) {
        this.siteLinkAction = siteLinkAction;
    }

    public Set<SiteLinksPermission> getSiteLinksPermissions() {
        return siteLinksPermissions;
    }

    public void setSiteLinksPermissions(Set<SiteLinksPermission> siteLinksPermissions) {
        this.siteLinksPermissions = siteLinksPermissions;
    }
}

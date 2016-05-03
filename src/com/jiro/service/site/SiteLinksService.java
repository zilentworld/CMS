package com.jiro.service.site;

import com.jiro.model.site.SiteLinks;

import java.util.List;

/**
 * Created by dev-pc on 5/3/16.
 */
public interface SiteLinksService {

    public List<String> getHeaderNames();

    public List<SiteLinks> getSiteLinks();

}

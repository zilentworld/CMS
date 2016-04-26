package com.jiro.action.site;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.site.SitePost;
import com.jiro.service.site.SitePostService;
import com.jiro.utility.Constants;

public class PostPreviewAction extends SiteAbstractAction implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private SitePostService sitePostService;
    private List<SitePost> postPreviewList;
    private Map<String, Object> sessionMap;
    
    public List<SitePost> getPostPreviewList() {
        return postPreviewList;
    }
    public void setPostPreviewList(List<SitePost> postPreviewList) {
        this.postPreviewList = postPreviewList;
    }
    public SitePostService getSitePostService() {
        return sitePostService;
    }
    public void setSitePostService(SitePostService sitePostService) {
        this.sitePostService = sitePostService;
    }
    
    @Override
    public String execute() throws Exception {
        String blogUrl = (String) sessionMap.get(Constants.CMS_SESSION_BLOG_URL);
        System.out.println("blogPostAction:"+blogUrl);
        postPreviewList = sitePostService.getPostPreview(blogUrl, 0, 5);
        
        return SUCCESS;
    }
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    
    
}

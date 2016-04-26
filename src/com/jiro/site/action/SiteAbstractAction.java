package com.jiro.site.action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class SiteAbstractAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String blogSiteUrl;
    private String nextAction;
    
    public String getBlogSiteUrl() {
        return blogSiteUrl;
    }
    public void setBlogSiteUrl(String blogSiteUrl) {
        this.blogSiteUrl = blogSiteUrl;
    }
    public String getNextAction() {
        return nextAction;
    }
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }
    
    @Override
    public abstract String execute() throws Exception;
}

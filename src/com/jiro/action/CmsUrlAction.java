package com.jiro.action;

import com.opensymphony.xwork2.ActionSupport;

public class CmsUrlAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String siteUrl;
    
    public String getSiteUrl() {
        return siteUrl;
    }
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
    
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return super.execute();
    }
    @Override
    public void validate() {
        // TODO Auto-generated method stub
        super.validate();
    }
    

}

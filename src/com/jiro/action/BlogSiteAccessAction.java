package com.jiro.action;

import com.opensymphony.xwork2.ActionSupport;

public class BlogSiteAccessAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String siteName;
    public String getSiteName() {
        return siteName;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return super.execute();
    }

}

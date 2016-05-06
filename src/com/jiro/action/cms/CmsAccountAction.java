package com.jiro.action.cms;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by dev-pc on 5/6/16.
 */
public class CmsAccountAction extends ActionSupport {

    public String showSiteList() {
        System.out.println("showSiteList");
        return SUCCESS;
    }

    public String showUserList() {
        System.out.println("showUserList");
        return SUCCESS;
    }

    public String showUserInfo() {
        System.out.println("showUserInfo");
        return SUCCESS;
    }

    public String showUserSites() {
        System.out.println("showUserSites");
        return SUCCESS;
    }

}

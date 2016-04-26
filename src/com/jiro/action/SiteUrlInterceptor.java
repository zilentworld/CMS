package com.jiro.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SiteUrlInterceptor implements Interceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Object actionClass = invocation.getAction();
        SiteAbstractAction siteAbstractAction;
        if(actionClass instanceof SiteAbstractAction) {
            siteAbstractAction = (SiteAbstractAction) actionClass;
            System.out.println("interceptor:"+siteAbstractAction.getBlogSiteUrl());
        }
        return invocation.invoke();
    }

}

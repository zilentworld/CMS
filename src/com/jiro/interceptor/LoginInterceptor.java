package com.jiro.interceptor;

import com.jiro.model.cms.CmsUser;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Created by dev-pc on 5/17/16.
 */
public class LoginInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();

        CmsUser cmsUser = (CmsUser) sessionAttributes.get(Constants.CMS_SESSION_CMS_USER);

        if(cmsUser == null || cmsUser.getCmsUserId() <= 0) {
            return "login-require";
        } else {
            return invocation.invoke();
        }
    }
}

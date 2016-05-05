package com.jiro.cms;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by dev-pc on 5/4/16.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Initialize Sites");
        CmsFileController.setRealPath(servletContextEvent.getServletContext().getRealPath(""));
        CmsFileController.initializeSites();
        System.out.println("Finished Initializing Sites");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Destroy Sites");
        CmsFileController.destroySites();
        System.out.println("Finished Destroying  Sites");
    }
}

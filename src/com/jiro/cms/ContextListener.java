package com.jiro.cms;

import com.jiro.service.cms.CmsTagsService;
import com.jiro.service.cms.impl.CmsTagsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;

/**
 * Created by dev-pc on 5/4/16.
 */
public class ContextListener implements ServletContextListener {

//
//    @Autowired
//    private CmsTagsService cmsTagsService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Initialize Sites");
        CmsFileController.setRealPath(servletContextEvent.getServletContext().getRealPath(""));
        CmsFileController.initializeSites();
//        cmsTagsService.getCmsTagsMap();
//        CmsFileController.setCmsTagsMap(cmsTagsService.getCmsTagsMap());
        System.out.println("Finished Initializing Sites");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Destroy Sites");
//        CmsFileController.destroySites();
        System.out.println("Finished Destroying  Sites");
        // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}

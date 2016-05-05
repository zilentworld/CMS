package com.jiro.cms;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.utility.Constants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by dev-pc on 5/4/16.
 */
public class CmsFileController {

    private static String realPath;

    public static  String getRealPath() {
        return realPath;
    }

    public static void setRealPath(String path) {
        realPath = path;
    }

    public static void generateFiles(CmsUserSite cmsUserSite) {
        System.out.println("getRealPath:" + realPath);

        //copy the sitePages to the ~/pending/<siteUrl>/
        String pathToSitePending = Constants.CMS_PATH_TO_PENDING + cmsUserSite.getBlogUrl() + "/";
        String templateFileName = cmsUserSite.getCmsTemplates().getTemplateBaselayout();

        //copy the latest files
        copySitePagesToPath(pathToSitePending, templateFileName);
    }

    public static void publishSite(CmsUserSite cmsUserSite) {
        String pathToSitePending = Constants.CMS_PATH_TO_PENDING + cmsUserSite.getBlogUrl() + "/";
        File sitePending = new File(pathToSitePending);
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        File sitePublished = new File(Constants.CMS_PATH_TO_PUBLISHED);

        try {
            //copy from pending to generated
            FileUtils.copyDirectoryToDirectory(sitePending, generatedPath);
            //move from pending to published
            FileUtils.moveDirectoryToDirectory(sitePending, sitePublished, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePublishedSite(CmsUserSite cmsUserSite) {

        try {
            String pathToSitePublished = Constants.CMS_PATH_TO_PUBLISHED + cmsUserSite.getBlogUrl() + "/";
            String templateFileName = cmsUserSite.getCmsTemplates().getTemplateBaselayout();
            File sitePublished = new File(pathToSitePublished);

            //delete the published folder first
            FileUtils.deleteDirectory(sitePublished);

            //copy the latest files
            copySitePagesToPath(pathToSitePublished, templateFileName);

            //delete the published folder in the server
            File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED + cmsUserSite.getBlogUrl() + "/");
            FileUtils.deleteDirectory(generatedPath);

            //copy from publish to generated
            generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
            FileUtils.copyDirectoryToDirectory(sitePublished, generatedPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copySitePagesToPath(String pathToDest, String templateName) {
        File dest = new File(pathToDest);
        try {
            //copy from sitePages
            FileUtils.copyDirectory(new File(realPath + Constants.CMS_PATH_TO_SITE), dest, false);

            //copy the template
            File templateFile = new File(realPath + Constants.CMS_PATH_TO_TEMPLATES + templateName);
            FileUtils.copyFileToDirectory(templateFile, dest);

            // and rename it to template.jsp
            File siteTemplate = new File(pathToDest + templateName);
            File siteTemplateName = new File(pathToDest + "template.jsp");
            FileUtils.moveFile(siteTemplate, siteTemplateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeSites() {
        File sitePublished = new File(Constants.CMS_PATH_TO_PUBLISHED);
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        try {
            FileUtils.copyDirectory(sitePublished, generatedPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void destroySites() {
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        try {
            FileUtils.deleteDirectory(generatedPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

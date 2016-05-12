package com.jiro.cms;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.utility.Constants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dev-pc on 5/4/16.
 */
public class CmsFileController {

    private static String realPath;

    public static String getRealPath() {
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

    public static void createSiteInitialFiles(CmsUserSite cmsUserSite) {
        System.out.println("cmsFileController:createSiteInitialFiles:");
        String templateName = cmsUserSite.getCmsTemplates().getTemplateName();
        String siteName = cmsUserSite.getBlogUrl();
        File templatePath = new File(realPath + Constants.CMS_PATH_TO_DEFAULT_FILES + templateName);
        File pendingPath = new File(Constants.CMS_PATH_TO_PENDING + siteName);
        //copy from sitePages
        try {
            FileUtils.copyDirectory(templatePath, pendingPath, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getAllFiles(CmsUserSite cmsUserSite) {
//        System.out.println("getAllFiles:");
        String siteUrl = cmsUserSite.getBlogUrl();
//        System.out.println("getAllFiles:siteUrl:"+siteUrl);
        String currPath = cmsUserSite.getIsPublished() == 1 ?
                Constants.CMS_PATH_TO_PUBLISHED : Constants.CMS_PATH_TO_PENDING;
//        System.out.println("getAllFiles:currPath:"+currPath);
        String sitePath = currPath + siteUrl;
//        System.out.println("getAllFiles:sitePath:"+sitePath);
        List<File> allFiles = new ArrayList<>();
        try {
            Files.walk(Paths.get(sitePath)).forEach(filePath -> {
                System.out.println("in loop:filePath:"+filePath.toString());
//                if (Files.isRegularFile(filePath)) {
                if (filePath.toFile().isFile()) {
                    System.out.println("add to list");
                    allFiles.add(filePath.toFile());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("getAllFiles:allFiles:"+allFiles.size());
        return allFiles;
    }

    public static File getByFileName(CmsUserSite cmsUserSite, String filename) {
        String siteUrl = cmsUserSite.getBlogUrl();
        String currPath = cmsUserSite.getIsPublished() == 1 ?
                Constants.CMS_PATH_TO_PUBLISHED : Constants.CMS_PATH_TO_PENDING;
        String sitePath = currPath + siteUrl;

        try {
            Iterator<Path> iterator = Files.walk(Paths.get(sitePath)).iterator();
            while(iterator.hasNext()) {
                Path p = iterator.next();
                File file = p.toFile();
                if (file.isFile()) {
                    if(file.getName().equals(filename)) {
                        return file;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

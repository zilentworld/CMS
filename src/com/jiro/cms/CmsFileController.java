package com.jiro.cms;

import com.google.common.base.Charsets;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.utility.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

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
//    private static Map<String, String> cmsTagsMap = new HashedMap();
//
//    public static Map<String, String> getCmsTagsMap() {
//        return cmsTagsMap;
//    }
//
//    public static void setCmsTagsMap(Map<String, String> cmsTagsMap) {
//        CmsFileController.cmsTagsMap = cmsTagsMap;
//    }

    public static String getRealPath() {
        return realPath;
    }

    public static void setRealPath(String path) {
        realPath = path;
    }

    public static void generateFiles(CmsUserSite cmsUserSite) {
        System.out.println("getRealPath:" + realPath);

        //copy the sitePages to the ~/pending/<siteUrl>/
        String pathToSitePending = Constants.getPendingPath() + cmsUserSite.getBlogUrl() + "/";
        String templateFileName = cmsUserSite.getCmsTemplates().getTemplateBaselayout();

        //copy the latest files
        copySitePagesToPath(pathToSitePending, templateFileName);
    }

    public static void publishSite(CmsUserSite cmsUserSite) {
        String pathToSitePending = Constants.getPendingPath() + cmsUserSite.getBlogUrl() + "/";
        File sitePending = new File(pathToSitePending);
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        File sitePublished = new File(Constants.getPublishPath());

        try {
            //copy from pending to generated
            FileUtils.copyDirectoryToDirectory(sitePending, generatedPath);
            //move from pending to published
            FileUtils.moveDirectoryToDirectory(sitePending, sitePublished, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        convertHtmlToJsp();
        convertSpecialCmsTags();
    }

    public static void convertHtmlToJsp() {
        String sitePublishedPath = realPath + Constants.CMS_PATH_TO_GENERATED;
        convertHtmlFiles(sitePublishedPath);
    }

    public static void convertHtmlToJsp(CmsUserSite cmsUserSite) {
        String sitePublishedPath = realPath + Constants.CMS_PATH_TO_GENERATED + cmsUserSite.getBlogUrl() + "/html/";
        convertHtmlFiles(sitePublishedPath);
    }

    private static void convertHtmlFiles(String sitePublishedPath) {
        System.out.println("CONVERT HTML TO JSP");
        try {
            Files.walk(Paths.get(sitePublishedPath)).forEach(filePath -> {
                if (filePath.toFile().isFile()) {
                    if ("html".equals(FilenameUtils.getExtension(filePath.toString()))) {
                        System.out.println("convert html to jsp:" + filePath.toString());
                        String newFileName = FilenameUtils.removeExtension(filePath.getFileName().toString()) + ".jsp";
                        System.out.println("jspConverted:" + newFileName);
                        try {
                            //rename file
                            Files.move(filePath, filePath.resolveSibling(newFileName));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertSpecialCmsTags() {
        String sitePublishedPath = realPath + Constants.CMS_PATH_TO_GENERATED;
        putStrutTags(sitePublishedPath);
    }

    public static void convertSpecialCmsTags(CmsUserSite cmsUserSite) {
        String sitePublishedPath = realPath + Constants.CMS_PATH_TO_GENERATED + cmsUserSite.getBlogUrl() + "/html/";
        putStrutTags(sitePublishedPath);
    }

    public static String getPreviewWithTags(CmsUserSite cmsUserSite, String fileContent) {
        String prependStr = "<%@ page contentType=\"text/html; charset=UTF-8\"%>" +
                "<%@ taglib prefix=\"s\" uri=\"/struts-tags\"%>";
        fileContent = prependStr + fileContent;
        Iterator iter = CmsTagsMap.tagsMap.keySet().iterator();
        while (iter.hasNext()) {
            String a = iter.next().toString();
            if (fileContent.contains(a)) {
                String[] actionTag = CmsTagsMap.tagsMap.get(a);
                fileContent = fileContent.replace(a, actionTag[0] + cmsUserSite.getBlogUrl() + actionTag[1]);
            }
        }

        return fileContent;
    }

    private static void putStrutTags(String path) {
        String prependStr = "<%@ page contentType=\"text/html; charset=UTF-8\"%>" +
                "<%@ taglib prefix=\"s\" uri=\"/struts-tags\"%>";
        try {
            Files.walk(Paths.get(path)).forEach(filePath -> {
                if (filePath.toFile().isFile()) {
                    if ("jsp".equals(FilenameUtils.getExtension(filePath.toString()))) {
//                        System.out.println("filePath:" + filePath.toString());
                        File jspFile = filePath.toFile();
                        String fileAsString = null;
                        try {
                            fileAsString = prependStr + com.google.common.io.Files.toString(jspFile, Charsets.UTF_8);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Iterator iter = CmsTagsMap.tagsMap.keySet().iterator();
//                        System.out.println("putStrutTags:jspFile:" + jspFile.toString());
                        while (iter.hasNext()) {
                            String a = iter.next().toString();
//                            System.out.println("putStrutTags:iter:" + a);
                            if (fileAsString.contains(a)) {
//                                System.out.println("beforeReplace:fileAsString:" + fileAsString);
                                String urlFolder = filePath.toFile().getParentFile().getParentFile().getName();
                                String[] actionTag = CmsTagsMap.tagsMap.get(a);
                                fileAsString = fileAsString.replace(a, actionTag[0] + urlFolder + actionTag[1]);
//                                System.out.println("afterReplace:fileAsString:" + fileAsString);
                            }
                        }

                        try {
                            FileUtils.writeStringToFile(jspFile, fileAsString);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePublishedSite(CmsUserSite cmsUserSite) {

        try {
            String pathToSitePublished = Constants.getPublishPath() + cmsUserSite.getBlogUrl() + "/";
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
        File sitePublished = new File(Constants.getPublishPath());
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        try {
            FileUtils.copyDirectory(sitePublished, generatedPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        convertHtmlToJsp();
        convertSpecialCmsTags();
    }

    public static void destroySites() {
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        try {
            FileUtils.deleteDirectory(generatedPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewFile(CmsUserSite cmsUserSite, String newFilename) {
        System.out.println("cmsFileController:addNewFile:");
        String templateName = cmsUserSite.getCmsTemplates().getTemplateName();
        String siteName = cmsUserSite.getBlogUrl();
        String currPath = cmsUserSite.getCurrPath();
        File templatePath = new File(realPath + Constants.CMS_PATH_TO_DEFAULT_FILES + templateName);
        File pendingPath = new File(currPath + siteName + "/html");
        File baseFile = new File(templatePath + "/html/base.html");
        File baseFilePending = new File(pendingPath + "/base.html");
        File newFile = new File(pendingPath + "/" + newFilename + ".html");
        File generatedPath = new File(realPath + Constants.CMS_PATH_TO_GENERATED);
        try {
            System.out.println("paths:");
            System.out.println("templatePath:" + templatePath.getPath());
            System.out.println("baseFile:" + baseFile.getPath());
            System.out.println("pendingPath:" + pendingPath.getPath());
            System.out.println("baseFilePending:" + baseFilePending.getPath());
            System.out.println("newFile:" + newFile.getPath());
            //copy to published path
            FileUtils.copyFileToDirectory(baseFile, pendingPath, false);
            FileUtils.moveFile(baseFilePending, newFile);
            //copy to generated path
            FileUtils.copyFileToDirectory(newFile, generatedPath, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(CmsUserSite cmsUserSite, String fileName) {
        if (!StringUtils.isEmpty(fileName)) {
            String currPath = cmsUserSite.getCurrPath();
            String siteName = cmsUserSite.getBlogUrl();
            File fileToDelete = new File(currPath + siteName + "/html/" + fileName);
            System.out.println("cmsFileController:deleteFile:" + fileToDelete.getPath());
            FileUtils.deleteQuietly(fileToDelete);
        }
    }

    public static void createSiteInitialFiles(CmsUserSite cmsUserSite) {
        System.out.println("cmsFileController:createSiteInitialFiles:");
        String templateName = cmsUserSite.getCmsTemplates().getTemplateName();
        String siteName = cmsUserSite.getBlogUrl();
        File templatePath = new File(realPath + Constants.CMS_PATH_TO_DEFAULT_FILES + templateName);
        File pendingPath = new File(Constants.getPendingPath() + siteName);
        File baseFile = new File(Constants.getPendingPath() + siteName + "/html/base.html");
        //copy from sitePages
        try {
            FileUtils.copyDirectory(templatePath, pendingPath, false);
            //remove base.html
            FileUtils.deleteQuietly(baseFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getAllFiles(CmsUserSite cmsUserSite) {
//        System.out.println("getAllFiles:");
        String siteUrl = cmsUserSite.getBlogUrl();
//        System.out.println("getAllFiles:siteUrl:"+siteUrl);
        String currPath = cmsUserSite.getCurrPath();
        System.out.println("getAllFiles:currPath:" + currPath);
        String sitePath = currPath + siteUrl;
        System.out.println("getAllFiles:sitePath:" + sitePath);
        List<File> allFiles = new ArrayList<>();
        try {
            Files.walk(Paths.get(sitePath)).forEach(filePath -> {
                System.out.println("in loop:filePath:" + filePath.toString());
//                if (Files.isRegularFile(filePath)) {
                if (filePath.toFile().isFile()) {
                    System.out.println("add to list");
                    allFiles.add(filePath.toFile());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("getAllFiles:allFiles:" + allFiles.size());
        return allFiles;
    }

    public static File getByFileName(CmsUserSite cmsUserSite, String filename) {
        String siteUrl = cmsUserSite.getBlogUrl();
        String currPath = cmsUserSite.getCurrPath();
        String sitePath = currPath + siteUrl;

        try {
            Iterator<Path> iterator = Files.walk(Paths.get(sitePath)).iterator();
            while (iterator.hasNext()) {
                Path p = iterator.next();
                File file = p.toFile();
                System.out.println("p:"+p.toString());
                if (file.isFile()) {
                    if (file.getName().toLowerCase().contains(filename.toLowerCase())) {
                        System.out.println("getByFilename:file:filePath:" + file.getPath());
                        return file;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("getByFileName:null:");
        return null;
    }

    public static boolean checkIfFileExists(CmsUserSite cmsUserSite, String filename) {
        String htmlFileName = filename + ".html";
        String currPath = cmsUserSite.getCurrPath();
        File checkFile = new File(currPath + cmsUserSite.getBlogUrl() + "/html/" + htmlFileName);
        System.out.println("checkIfFileExists:htmlFileName:" + htmlFileName);
        System.out.println("checkIfFileExists:currPath:" + currPath);
        System.out.println("checkIfFileExists:checkFile:" + checkFile.getPath());

        return checkFile.exists() && checkFile.isFile();
    }

    public static boolean checkIfFileDeployed(CmsUserSite cmsUserSite, String filename) {
        String htmlFileName = filename + ".jsp";
        String currPath = Constants.CMS_PATH_TO_GENERATED;
        File checkFile = new File(realPath + currPath + cmsUserSite.getBlogUrl() + "/html/" + htmlFileName);

        return checkFile.exists() && checkFile.isFile();
    }

}

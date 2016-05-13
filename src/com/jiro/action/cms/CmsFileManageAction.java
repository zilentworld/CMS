package com.jiro.action.cms;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/12/16.
 */
public class CmsFileManageAction extends ActionSupport {

    private CmsUserSite cmsUserSite;
    private long cmsUserSiteId;
    private CmsUserSiteService cmsUserSiteService;
    private List<File> fileList;
    private String fileName;
    private String fileContent;
    private File file;
    private String filePath;
    private String searchFile;
    private String newFileName;

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getSearchFile() {
        return searchFile;
    }

    public void setSearchFile(String searchFile) {
        this.searchFile = searchFile;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public long getCmsUserSiteId() {
        return cmsUserSiteId;
    }

    public void setCmsUserSiteId(long cmsUserSiteId) {
        this.cmsUserSiteId = cmsUserSiteId;
    }

    public CmsUserSiteService getCmsUserSiteService() {
        return cmsUserSiteService;
    }

    public void setCmsUserSiteService(CmsUserSiteService cmsUserSiteService) {
        this.cmsUserSiteService = cmsUserSiteService;
    }

    public String showCMS() {
        System.out.println("cmsFileManageAction:showCMS:cmsUserSiteId:" + cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        fileList = CmsFileController.getAllFiles(cmsUserSite);

        return SUCCESS;
    }

    public String showEditFile() {
        System.out.println("cmsFileManageAction:showEditFile:fileName:" + fileName);
        System.out.println("cmsFileManageAction:showEditFile:cmsUserSiteId:" + cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        file = CmsFileController.getByFileName(cmsUserSite, fileName);
        updateFileContent(file);

        return SUCCESS;
    }

    public String saveCMS() {
        System.out.println("saveCMS:");
        System.out.println(fileContent);
        System.out.println("cmsFileManageAction:saveCMS:fileName:" + fileName);
        System.out.println("cmsFileManageAction:saveCMS:cmsUserSiteId:" + cmsUserSiteId);

        return SUCCESS;
    }

    public String showPreview() {
        System.out.println("cmsFileManageAction:showPreview:fileName:" + fileName);
        System.out.println("cmsFileManageAction:showPreview:cmsUserSiteId:" + cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        file = CmsFileController.getByFileName(cmsUserSite, fileName);
        filePath = file.getPath();
        System.out.println("cmsFileManageAction:showPreview:filePath:" + filePath);
        updateFileContent(file);
        System.out.println("cmsFileManageAction:showPreview:fileContent:" + fileContent);

        return SUCCESS;
    }

    public String showFilteredCMS() {
        System.out.println("cmsFilemanageAction:showFilteredCms:cmsUserSiteId:"+cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        fileList = new ArrayList<>();
        if(searchFile != null && searchFile.length() > 0)
            fileList.add(CmsFileController.getByFileName(cmsUserSite, searchFile));
        else
            fileList = CmsFileController.getAllFiles(cmsUserSite);

        return SUCCESS;
    }

    private void updateFileContent(File file) {
        try {
            /*List<String> contentList = Files.readLines(file, Charsets.UTF_8);
            StringBuffer sb = new StringBuffer();
            contentList.forEach(e -> sb.append(e));

            fileContent = sb.toString();*/

            fileContent = Files.toString(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.jiro.action.cms;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsFile;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.FileUtility;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/12/16.
 */

@Controller
public class CmsFileManageAction extends ActionSupport {

    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    private CmsUserSite cmsUserSite;
    private long cmsUserSiteId;
    private List<CmsFile> cmsFileList;
    private String fileName;
    private String fileContent;
    private File file;
    private String filePath;
    private String searchFile;
    private String newFileName;
    private String msg;

    public String showCMS() {
        System.out.println("cmsFileManageAction:showCMS:cmsUserSiteId:" + cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        cmsFileList = new ArrayList<>();
        CmsFileController.getAllFiles(cmsUserSite).forEach(files -> cmsFileList.add(new CmsFile(files)));
        System.out.println("cmsFileManageAction:showCMS:msg:" + msg);

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
        if(StringUtils.isEmpty(fileName))
            fileName = "home.html";
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
        cmsFileList = new ArrayList<>();
        if(searchFile != null && searchFile.length() > 0) {
            cmsFileList.add(new CmsFile(CmsFileController.getByFileName(cmsUserSite, searchFile)));
        }
        else {
//            fileList = CmsFileController.getAllFiles(cmsUserSite);
            CmsFileController.getAllFiles(cmsUserSite).forEach(files -> cmsFileList.add(new CmsFile(files)));
        }

        return SUCCESS;
    }

    public String deleteFile() {
        System.out.println("cmsFilemanageAction:deleteFile:cmsUserSiteId:"+cmsUserSiteId);
        System.out.println("cmsFilemanageAction:deleteFile:fileName:"+fileName);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        CmsFileController.deleteFile(cmsUserSite, fileName);

        return SUCCESS;
    }

    private void updateFileContent(File file) {
        try {
            fileContent = Files.toString(file, Charsets.UTF_8);
            CmsFileController.getPreviewWithTags(cmsUserSite, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

    public List<CmsFile> getCmsFileList() {
        return cmsFileList;
    }

    public void setCmsFileList(List<CmsFile> cmsFileList) {
        this.cmsFileList = cmsFileList;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

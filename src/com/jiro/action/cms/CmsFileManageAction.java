package com.jiro.action.cms;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
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
        System.out.println("cmsFileManageAction:showCMS:cmsUserSiteId:"+cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        fileList = CmsFileController.getAllFiles(cmsUserSite);

        System.out.println("showCMs::spw");
        fileList.forEach(e -> {
            System.out.println(e.getName());
            System.out.println(e.getPath());
            System.out.println(e.getParent());
            System.out.println(e.getParent().substring(e.getParent().lastIndexOf('/')));
        });

        return SUCCESS;
    }

    public String showEditFile() {
        System.out.println("cmsFileManageAction:showEditFile:fileName:"+fileName);
        System.out.println("cmsFileManageAction:showEditFile:cmsUserSiteId:"+cmsUserSiteId);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        file = CmsFileController.getByFileName(cmsUserSite, fileName);
        try {
            fileContent = Files.toString(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

}

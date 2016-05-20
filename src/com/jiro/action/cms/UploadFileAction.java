package com.jiro.action.cms;

import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.FileUtility;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by dev-pc on 5/20/16.
 */

@Component
public class UploadFileAction extends ActionSupport {

    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    private long cmsUserSiteId;
    private String msg;

    public String execute() throws Exception{
        System.out.println("uploadFileAction:execute:");
        System.out.println("uploadFileAction:cmsUserSiteId:"+cmsUserSiteId);
        CmsUserSite cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        System.out.println("uploadFileAction:execute:file:"+fileUpload.getPath());
        System.out.println("uploadFileAction:execute:file:"+fileUpload.getAbsolutePath());

        FileUtility.saveFile(fileUpload,fileUploadFileName, cmsUserSite.getCurrFullPath());
        msg = "File have been uploaded successfully.";

        return SUCCESS;
    }

    @Override
    public void validate() {
        if(fileUpload == null) {
            addFieldError("msg","ERROR");
            msg = "There is nothing to upload";
        }
    }

    public String display() {
        return NONE;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCmsUserSiteId() {
        return cmsUserSiteId;
    }

    public void setCmsUserSiteId(long cmsUserSiteId) {
        this.cmsUserSiteId = cmsUserSiteId;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }
}
package com.jiro.action.cms;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 * Created by dev-pc on 5/13/16.
 */
public class CmsAddNewFileAction extends ActionSupport {

    private long cmsUserSiteId;
    private CmsUserSiteService cmsUserSiteService;
    private CmsUserSite cmsUserSite;
    private String newFileName;

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

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    @SkipValidation
    public String showAddFile() {
        System.out.println("showAddFile");
        return SUCCESS;
    }

    public String addNewFile() {
        System.out.println("cmsFileManageAction:addNewFile:cmsUserSiteId:"+cmsUserSiteId);
        System.out.println("cmsFileManageAction:addNewFile:newFileName:"+newFileName);
        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        CmsFileController.addNewFile(cmsUserSite, newFileName);

        return SUCCESS;
    }

    @Override
    public void validate() {
        System.out.println("cmsAddNewFileACtion:validate:");
        if(cmsUserSiteId <= 0) {
            System.out.println("cmsAddNewFileACtion:id not exists1:");
            addFieldError("newFileName","Id not exists");
        }

        cmsUserSite = cmsUserSiteService.getById(cmsUserSiteId);
        if(cmsUserSite == null) {
            System.out.println("cmsAddNewFileACtion:id not exists2:");
            addFieldError("newFileName","Id not exists");
        }

        if(CmsFileController.checkIfFileExists(cmsUserSite, newFileName)) {
            System.out.println("cmsAddNewFileACtion:file already exists:");
            addFieldError("newFileName","File already exists");
        }
    }
}

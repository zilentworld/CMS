package com.jiro.action.cms;

import com.jiro.cms.CmsFileController;
import com.jiro.model.cms.CmsUserSite;
import com.jiro.service.cms.CmsUserSiteService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * Created by dev-pc on 5/16/16.
 */

@Controller
public class CmsSiteNavAction extends ActionSupport {

    @Autowired
    private CmsUserSiteService cmsUserSiteService;
    private String siteUrl;
    private String fileName;
    private String siteFilePath;
    private CmsUserSite cmsUserSite;
    private String msg;
    private String siteHomePath;

    public String testAction() {
        System.out.println("testAction:siteUrl:"+siteUrl);
        msg = "ha!";
        return SUCCESS;
    }

    public String toFile() {
        System.out.println("cmsSiteNavAction:toFile:siteUrl:" + siteUrl);
        System.out.println("cmsSiteNavAction:toFile:fileName:" + fileName);
        siteUrl = sanitizeSlashes(siteUrl);
        fileName = sanitizeSlashes(fileName);
        System.out.println("cmsSiteNavAction:toFile:siteUrl:" + siteUrl);
        System.out.println("cmsSiteNavAction:toFile:fileName:" + fileName);
        if(StringUtils.isEmpty(fileName)) {
            fileName = "home";
        }
        siteFilePath = Constants.CMS_PATH_TO_GENERATED + siteUrl + "/html/" + fileName + ".jsp";
        System.out.println("cmsSiteNavAction:toFile:siteFilePath:" + siteFilePath);

        return getReturnValue();
    }

    @Override
    public String execute() throws Exception {
        siteUrl = sanitizeSlashes(siteUrl);
        System.out.println("cmsSiteNavAction:execute:siteUrl:" + siteUrl);
        System.out.println("cmsSiteNavAction:execute:fileName:" + fileName);
        fileName = "home";
        siteFilePath = Constants.CMS_PATH_TO_GENERATED + siteUrl + "/html/" + fileName + ".jsp";
        siteHomePath = siteUrl + "/" + fileName;
        System.out.println("cmsSiteNavAction:execute:siteHomePath:" + siteHomePath);
        System.out.println("cmsSiteNavAction:execute:siteFilePath:" + siteFilePath);

        return getReturnValue();
    }

    private String getReturnValue() {
        cmsUserSite = cmsUserSiteService.getByUrl(siteUrl);
        if (cmsUserSite == null) {
            msg = Constants.CMS_ERROR_SITE_NOT_EXIST;
            return ERROR;
        }
        if (cmsUserSite.getIsPublished() == 0) {
            msg = Constants.CMS_ERROR_SITE_NOT_PUBLISH;
            return ERROR;
        }
        if (!CmsFileController.checkIfFileDeployed(cmsUserSite, fileName)) {
            msg = Constants.CMS_ERROR_PAGE_NOT_EXISTS;
            return ERROR;
        }

        return SUCCESS;
    }

    private String sanitizeSlashes(String sanitizeString) {
        if (!StringUtils.isEmpty(sanitizeString)) {
//            System.out.println(sanitizeString);
//            System.out.println("charAt(0)");
            while (sanitizeString.charAt(0) == '/') {
//                System.out.println("1:" + sanitizeString);
                sanitizeString = sanitizeString.substring(1, sanitizeString.length());
//                System.out.println("2:" + sanitizeString);
            }
//            System.out.println("charAt(sb.length()):" + sanitizeString.length());
            while (sanitizeString.charAt(sanitizeString.length() - 1) == '/') {
//                System.out.println("3:" + sanitizeString);
                sanitizeString = sanitizeString.substring(0, sanitizeString.length() - 1);
//                System.out.println("4:" + sanitizeString);
            }
//            System.out.println("indexOf('//')");
            while (sanitizeString.indexOf("//") > 0) {
//                System.out.println("5:" + sanitizeString);
                sanitizeString = sanitizeString.replace("//", "/");
//                System.out.println("6:" + sanitizeString);
            }
        }

        return sanitizeString;
    }

    public String getSiteHomePath() {
        return siteHomePath;
    }

    public void setSiteHomePath(String siteHomePath) {
        this.siteHomePath = siteHomePath;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CmsUserSite getCmsUserSite() {
        return cmsUserSite;
    }

    public void setCmsUserSite(CmsUserSite cmsUserSite) {
        this.cmsUserSite = cmsUserSite;
    }

    public String getSiteFilePath() {
        return siteFilePath;
    }

    public void setSiteFilePath(String siteFilePath) {
        this.siteFilePath = siteFilePath;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

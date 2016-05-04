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
    /**
     *
     * @param cmsUserSite = CmsUserSite
     * @param realPath = servletContext.getRealPath("");
     */
    public static void generateFiles(CmsUserSite cmsUserSite, String realPath) {

//        String realPath = servletContext.getRealPath("");
        System.out.println("getRealPath:"+realPath);

        //copy the sitePages to the ~/pending/<siteUrl>/
        String pathToSitePending = Constants.CMS_PATH_TO_PENDING + cmsUserSite.getBlogUrl() + "/";
        File sitePending = new File(pathToSitePending);
        try {
            FileUtils.copyDirectory(new File(realPath + Constants.CMS_PATH_TO_SITE), sitePending, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String templateFileName = cmsUserSite.getCmsTemplates().getTemplateBaselayout();
        File templateFile = new File(realPath + Constants.CMS_PATH_TO_TEMPLATES + templateFileName);

        try {
            FileUtils.copyFileToDirectory(templateFile, sitePending);
            File siteTemplate = new File(pathToSitePending + templateFileName);
            File siteTemplateName = new File(pathToSitePending + "template.jsp");
            FileUtils.moveFile(siteTemplate, siteTemplateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

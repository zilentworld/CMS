package com.jiro.action;

import org.apache.commons.lang3.StringUtils; 

import com.jiro.model.CmsTemplates;
import com.jiro.model.CmsUser;
import com.jiro.service.CmsTemplatesService;
import com.jiro.service.CmsUserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsUser cmsUser;
    private CmsUserService cmsUserService;
    private CmsTemplates cmsTemplates;
    private CmsTemplatesService cmsTemplatesService;
    private String repeatPassword;
    private String cmsUserType;
    private String nextAction;
    private String errMsg;
    private String cmsTemplateId;
    
    public CmsUser getCmsUser() {
        return cmsUser;
    }
    
    public void setCmsUser(CmsUser cmsUser) {
        this.cmsUser = cmsUser;
    }
    
    public CmsUserService getCmsUserService() {
        return cmsUserService;
    }
    
    public void setCmsUserService(CmsUserService cmsUserService) {
        this.cmsUserService = cmsUserService;
    }
    
    public String getCmsUserType() {
        return cmsUserType;
    }
    
    public void setCmsUserType(String cmsUserType) {
        this.cmsUserType = cmsUserType;
    }
        
    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }
    
    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    
    public CmsTemplates getCmsTemplates() {
        return cmsTemplates;
    }

    public void setCmsTemplates(CmsTemplates cmsTemplates) {
        this.cmsTemplates = cmsTemplates;
    }

    public String getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(String cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }
    
    public CmsTemplatesService getCmsTemplatesService() {
        return cmsTemplatesService;
    }

    public void setCmsTemplatesService(CmsTemplatesService cmsTemplatesService) {
        this.cmsTemplatesService = cmsTemplatesService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("REGISTER");
        System.out.println(cmsTemplateId);
        
        cmsTemplates = cmsTemplatesService.get(Long.parseLong(cmsTemplateId));
        
        if(cmsTemplates == null) {
            errMsg = "An error occured. Kindly restart the process";
            return ERROR;
        }

        System.out.println("checkexist");
        if(cmsUserService.checkExistingCmsUser(cmsUser)) {
            errMsg = "An error occurred. Kindly register again";
            return ERROR;
        }

        System.out.println("createnewcms");
        cmsUser = cmsUserService.createNewCmsUser(cmsUser, cmsUserType);
        if(cmsUser == null) {
            errMsg = "An error occurred. Kindly register again";
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public void validate() {
        System.out.println("validation:username:"+cmsUser.getCmsUsername()+",password:"+cmsUser.getCmsPassword()+",repeat:"+repeatPassword);
        if(StringUtils.isEmpty(cmsUser.getCmsUsername())) {
            System.out.println("1");
            addFieldError("cmsUser.cmsUsername", "Username is required");
        }
        if(StringUtils.isEmpty(cmsUser.getCmsPassword())) {
            System.out.println("2");
            addFieldError("cmsUser.cmsPassword", "Password is required");
        }
        if(StringUtils.isEmpty(repeatPassword)) {
            System.out.println("3");
            addFieldError("repeatPassword", "Repeat Password is required");
        }
        if(!repeatPassword.equals(cmsUser.getCmsPassword())) {
            addFieldError("cmsUser.cmsPassword", "Password must be the same");
            addFieldError("repeatPassword", "Password must be the same");
        }
        try {
            Long.parseLong(cmsTemplateId);
        } catch (Exception e) {
            addFieldError("cmsUser.cmsUsername", "An error occured. Kindly restart the process");
        }
    }
    
    

}

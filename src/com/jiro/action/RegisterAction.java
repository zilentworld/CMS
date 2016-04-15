package com.jiro.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.CmsTemplates;
import com.jiro.model.CmsUser;
import com.jiro.service.CmsTemplatesService;
import com.jiro.service.CmsUserService;
import com.jiro.utility.Constants;
import com.jiro.utility.Utility;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private CmsUser cmsUserRegister;
    private CmsUserService cmsUserService;
    private CmsTemplates cmsTemplates;
    private CmsTemplatesService cmsTemplatesService;
    private String repeatPassword;
    private String nextAction;
    private String errMsg;
    private Map<String, Object> sessionMap;
    
    public CmsUser getCmsUserRegister() {
        return cmsUserRegister;
    }
    
    public void setCmsUserRegister(CmsUser cmsUserRegister) {
        this.cmsUserRegister = cmsUserRegister;
    }
    
    public CmsUserService getCmsUserService() {
        return cmsUserService;
    }
    
    public void setCmsUserService(CmsUserService cmsUserService) {
        this.cmsUserService = cmsUserService;
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
    
    public CmsTemplatesService getCmsTemplatesService() {
        return cmsTemplatesService;
    }

    public void setCmsTemplatesService(CmsTemplatesService cmsTemplatesService) {
        this.cmsTemplatesService = cmsTemplatesService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("REGISTER");
//        System.out.println(cmsTemplateId);
        
//        cmsTemplates = cmsTemplatesService.get(Long.parseLong(cmsTemplateId));
        cmsTemplates = (CmsTemplates) sessionMap.get(Constants.CMS_SESSION_CMS_TEMPLATE);
        
        if(cmsTemplates == null) {
            errMsg = "An error occured. Kindly restart the process";
            return ERROR;
        }

        System.out.println("checkexist");
        if(cmsUserService.checkExistingCmsUser(cmsUserRegister)) {
            errMsg = "An error occurred. Kindly register again";
            return ERROR;
        }

        System.out.println("createnewcms");
        cmsUserRegister.setCmsUserTypeCode("cms_user");
        if(cmsUserService.createNewCmsUser(cmsUserRegister)) {
            errMsg = "An error occurred. Kindly register again";
            return ERROR;
        }
        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUserRegister);
        sessionMap.put(Constants.CMS_SESSION_USERNAME, cmsUserRegister.getCmsUsername());
        sessionMap.put(Constants.CMS_SESSION_USER_TYPE_CODE, cmsUserRegister.getCmsUserTypeCode());
        
        return SUCCESS;
    }

    @Override
    public void validate() {
        System.out.println("validation:username:"+cmsUserRegister.getCmsUsername()+",password:"+cmsUserRegister.getCmsPassword()+",repeat:"+repeatPassword);
        if(StringUtils.isEmpty(cmsUserRegister.getCmsUsername())) {
            System.out.println("1");
            addFieldError("cmsUserRegister.cmsUsername", Constants.CMS_ERROR_USERNAME_REQUIRED);
        } else if(StringUtils.isEmpty(cmsUserRegister.getCmsPassword())) {
            System.out.println("2");
            addFieldError("cmsUserRegister.cmsPassword", Constants.CMS_ERROR_PASSWORD_REQUIRED);
        } else if(StringUtils.isEmpty(repeatPassword)) {
            resetPasswords();
            addFieldError("repeatPassword", Constants.CMS_ERROR_REPEATPASS_REQUIRED);
        } else if (!Utility.checkStringByRegex(cmsUserRegister.getCmsUsername(), Constants.CMS_REGEX_USERNAME)) {
            addFieldError("cmsUserRegister.cmsUsername", Constants.CMS_ERROR_USERNAME_INVALID_CHAR);
        } else if(!repeatPassword.equals(cmsUserRegister.getCmsPassword())) {
            resetPasswords();
            addFieldError("cmsUserRegister.cmsPassword", Constants.CMS_ERROR_PASS_NOTSAME);
            addFieldError("repeatPassword", Constants.CMS_ERROR_PASS_NOTSAME);
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    private void resetPasswords() {
        cmsUserRegister.setCmsPassword("");
        repeatPassword = "";
    }
}

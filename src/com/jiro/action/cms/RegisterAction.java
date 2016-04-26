package com.jiro.action.cms;

import java.util.Map; 

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.cms.CmsTemplates;
import com.jiro.model.cms.CmsUser;
import com.jiro.model.cms.CmsUserType;
import com.jiro.service.cms.CmsTemplatesService;
import com.jiro.service.cms.CmsUserService;
import com.jiro.service.cms.CmsUserTypeService;
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
    private CmsUserTypeService cmsUserTypeService;
    private String repeatPassword;
    private String nextAction;
    private String errMsg;
    private String cmsTemplateId;
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
    
    public CmsUserTypeService getCmsUserTypeService() {
        return cmsUserTypeService;
    }

    public void setCmsUserTypeService(CmsUserTypeService cmsUserTypeService) {
        this.cmsUserTypeService = cmsUserTypeService;
    }
    
    public String getCmsTemplateId() {
        return cmsTemplateId;
    }

    public void setCmsTemplateId(String cmsTemplateId) {
        this.cmsTemplateId = cmsTemplateId;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("REGISTER");
//        System.out.println(cmsTemplateId);
        
        cmsTemplates = cmsTemplatesService.get(Long.parseLong(cmsTemplateId));
//        cmsTemplates = (CmsTemplates) sessionMap.get(Constants.CMS_SESSION_CMS_TEMPLATE);
        
        if(cmsTemplates == null) {
            errMsg = Constants.CMS_ERROR_GENERIC_ERROR;
            return ERROR;
        }

        System.out.println("checkexist");
        if(cmsUserService.checkExistingCmsUser(cmsUserRegister)) {
            errMsg = Constants.CMS_ERROR_GENERIC_REGISTER;
            return ERROR;
        }

        System.out.println("createnewcms");
//        cmsUserRegister.setCmsUserTypeCode("cms_user");
        CmsUserType cmsUserType = cmsUserTypeService.getCmsUserType(Constants.CMS_DEFAULT_USER_TYPE);
        if(cmsUserType == null) {
            errMsg = Constants.CMS_ERROR_GENERIC_REGISTER;
            return ERROR;
        }
        System.out.println("create new");
        cmsUserRegister.setCmsUserType(cmsUserType);
        if(cmsUserService.createNewCmsUser(cmsUserRegister)) {
            errMsg = Constants.CMS_ERROR_GENERIC_REGISTER;
            return ERROR;
        }
        System.out.println("get by login");
        cmsUserRegister = cmsUserService.getByLogin(
                cmsUserRegister.getCmsUsername(), 
                cmsUserRegister.getCmsPassword());
        System.out.println("after register, userId:"+cmsUserRegister.getCmsUserId());
        sessionMap.put(Constants.CMS_SESSION_CMS_USER, cmsUserRegister);
        
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
        try {
            Long.parseLong(cmsTemplateId);
        } catch (Exception e) {
            addFieldError("cmsUserRegister.cmsUsername", Constants.CMS_ERROR_GENERIC_ERROR);
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

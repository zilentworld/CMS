package com.jiro.action.cms;

import com.jiro.model.cms.CmsUser;
import com.jiro.service.cms.CmsUserService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by dev-pc on 5/10/16.
 */

@Controller
public class CmsEditUserAction extends ActionSupport implements SessionAware {

    @Autowired
    private CmsUserService cmsUserService;
    private CmsUser cmsUser;
    private String cmsUserId;
    private String errorMsg;
    private String age;
    private String sourcePage;
    private Map<String, Object> sessionMap;

    @SkipValidation
    public String showEditUser() {
        System.out.println("cmsEditUser:execute:showEditUser:sourcePage:"+sourcePage);
        if(StringUtils.isNumeric(cmsUserId)) {
            cmsUser = cmsUserService.getById(Long.parseLong(cmsUserId));
            System.out.println("cmsEditUser:cmsUserId:"+cmsUserId+":SUCCESS");
            return SUCCESS;
        } else {
            System.out.println("cmsEditUser:cmsUserId:"+cmsUserId+":ERROR");
            errorMsg = "Invalid User Id";
            return ERROR;
        }
    }

    @Override
    public String execute() throws Exception {
        try {
            System.out.println("cmsEditUser:execute:");
            System.out.println("cmsEditUser:execute:sourcePage:"+sourcePage);
            CmsUser userToUpdate = cmsUserService.getById(Long.parseLong(cmsUserId));
            userToUpdate.setAge(Integer.parseInt(age));
            userToUpdate.setFirstName(cmsUser.getFirstName());
            userToUpdate.setMiddleName(cmsUser.getMiddleName());
            userToUpdate.setLastName(cmsUser.getLastName());
            userToUpdate.setGender(cmsUser.getGender());

            cmsUserService.updateCmsUser(userToUpdate);

            //refresh session data in case of user update
            CmsUser cmsUserSession = (CmsUser) sessionMap.get(Constants.CMS_SESSION_CMS_USER);
            if(cmsUserSession.getCmsUserId() == userToUpdate.getCmsUserId())
                sessionMap.put(Constants.CMS_SESSION_CMS_USER, userToUpdate);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();

            return ERROR;
        }
    }

    @Override
    public void validate() {
        System.out.println("cmsEditUser:validate:");
        if(!StringUtils.isNumeric(cmsUserId)){
            System.out.println("err0");
            addFieldError("cmsUser.firstName",Constants.CMS_ERROR_ID_INVALID);
            errorMsg = Constants.CMS_ERROR_ID_INVALID;
        } else if(!StringUtils.isAlphaSpace(cmsUser.getFirstName())){
            System.out.println("err1");
            addFieldError("cmsUser.firstName",Constants.CMS_ERROR_FIRST_NAME_INVALID);
            errorMsg = Constants.CMS_ERROR_FIRST_NAME_INVALID;
        } else if(!StringUtils.isAlphaSpace(cmsUser.getMiddleName())){
            System.out.println("err2");
            addFieldError("cmsUser.middleName",Constants.CMS_ERROR_MIDDLE_NAME_INVALID);
            errorMsg = Constants.CMS_ERROR_MIDDLE_NAME_INVALID;
        } else if(!StringUtils.isAlphaSpace(cmsUser.getLastName())){
            System.out.println("err3");
            addFieldError("cmsUser.lastName",Constants.CMS_ERROR_LAST_NAME_INVALID);
            errorMsg = Constants.CMS_ERROR_LAST_NAME_INVALID;
        } else if(!StringUtils.isNumeric(age)){
            System.out.println("err4");
            addFieldError("age",Constants.CMS_ERROR_AGE_INVALID);
            errorMsg = Constants.CMS_ERROR_AGE_INVALID;
        } else if(!StringUtils.isAlphaSpace(cmsUser.getGender())){
            System.out.println("err5");
            addFieldError("cmsUser.gender",Constants.CMS_ERROR_GENDER_INVALID);
            errorMsg = Constants.CMS_ERROR_GENDER_INVALID;
        }
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(String sourcePage) {
        this.sourcePage = sourcePage;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public CmsUser getCmsUser() {
        return cmsUser;
    }

    public void setCmsUser(CmsUser cmsUser) {
        this.cmsUser = cmsUser;
    }

    public String getCmsUserId() {
        return cmsUserId;
    }

    public void setCmsUserId(String cmsUserId) {
        this.cmsUserId = cmsUserId;
    }
}

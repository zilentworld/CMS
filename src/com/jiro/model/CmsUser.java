package com.jiro.model;

import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cms_user")
public class CmsUser {
    
    @Id
    @Column(name="cms_user_id")
    private long cmsUserId;
    @Column(name="cms_username")
    private String cmsUsername;
    @Column(name="cms_password")
    private String cmsPassword;
//    @ManyToOne
//    @JoinColumn(name = "cms_user_type")
//    private CmsUserType cmsUserType;
    @Column(name="cms_user_type_code")
    private String cmsUserTypeCode;
    
    @Column(name="cms_register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cmsRegisterDate;
    
    public long getCmsUserId() {
        return cmsUserId;
    }
    public void setCmsUserId(long cmsUserId) {
        this.cmsUserId = cmsUserId;
    }
    public String getCmsUsername() {
        return cmsUsername;
    }
    public void setCmsUsername(String cmsUsername) {
        this.cmsUsername = cmsUsername;
    }
    public String getCmsPassword() {
        return cmsPassword;
    }
    public void setCmsPassword(String cmsPassword) {
        this.cmsPassword = cmsPassword;
    }

    public String getCmsUserTypeCode() {
        return cmsUserTypeCode;
    }
    public void setCmsUserTypeCode(String cmsUserTypeCode) {
        this.cmsUserTypeCode = cmsUserTypeCode;
    }

//    public CmsUserType getCmsUserType() {
//        return cmsUserType;
//    }
//    public void setCmsUserType(CmsUserType cmsUserType) {
//        this.cmsUserType = cmsUserType;
//    }   
    public Date getCmsRegisterDate() {
        return cmsRegisterDate;
    }
    public void setCmsRegisterDate(Date cmsRegisterDate) {
        this.cmsRegisterDate = cmsRegisterDate;
    }
    
    @Override
    public String toString() {
        return "cmsUserId:"+cmsUserId+",cmsUsername:"+cmsUsername+",cmsPassword:"+cmsPassword ;//+  cmsUserType;
    }
    
}

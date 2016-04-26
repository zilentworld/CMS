package com.jiro.model.cms;

import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cms_user_type")
public class CmsUserType {

    @Id
    @Column(name="cms_user_type_code")
    private String cmsUserTypeCode;
    @Column(name="cms_user_type_desc")
    private String cmsUserTypeDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmsUserType", fetch = FetchType.LAZY)
    private Set<CmsUser> cmsUsers;
    
    public String getCmsUserTypeCode() {
        return cmsUserTypeCode;
    }
    public void setCmsUserTypeCode(String cmsUserTypeCode) {
        this.cmsUserTypeCode = cmsUserTypeCode;
    }
    public String getCmsUserTypeDesc() {
        return cmsUserTypeDesc;
    }
    public void setCmsUserTypeDesc(String cmsUserTypeDesc) {
        this.cmsUserTypeDesc = cmsUserTypeDesc;
    }
    
    public Set<CmsUser> getCmsUsers() {
        return cmsUsers;
    }
    public void setCmsUsers(Set<CmsUser> cmsUsers) {
        this.cmsUsers = cmsUsers;
    }
    
    @Override
    public String toString() {
        return "cmsUserTypeCode:"+cmsUserTypeCode + ", cmsUserTypeDesc:"+cmsUserTypeDesc;
    }

}

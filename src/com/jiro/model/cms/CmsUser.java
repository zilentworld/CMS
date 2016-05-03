package com.jiro.model.cms;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "cms_user_type_code")
    private CmsUserType cmsUserType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmsUser", fetch = FetchType.LAZY)
    private Set<CmsUserSite> cmsUserSites;
    
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

    public Set<CmsUserSite> getCmsUserSites() {
        return cmsUserSites;
    }

    public void setCmsUserSites(Set<CmsUserSite> cmsUserSites) {
        this.cmsUserSites = cmsUserSites;
    }

    public CmsUserType getCmsUserType() {
        return cmsUserType;
    }
    
    public void setCmsUserType(CmsUserType cmsUserType) {
        this.cmsUserType = cmsUserType;
    }
    
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

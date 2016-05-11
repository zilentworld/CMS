package com.jiro.model.cms;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="cms_user")
public class CmsUser {
    
    @Id
    @Column(name="cms_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name="first_name")
    private String firstName;
    @Column(name="middle_name")
    private String middleName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="gender")
    private String gender;
    @Column(name = "is_enabled")
    private int isEnabled;
    
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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getIsEnabled() {
        return isEnabled;
    }
    public void setIsEnabled(int isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setDefaultValues() {
        firstName = "";
        lastName = "";
        middleName = "";
        age = 0;
        gender = "";
        isEnabled = 1;
    }

    @Override
    public String toString() {
        return "cmsUserId:"+cmsUserId+",cmsUsername:"+cmsUsername+",cmsPassword:"+cmsPassword ;//+  cmsUserType;
    }
    
}

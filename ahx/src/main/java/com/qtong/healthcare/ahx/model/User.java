package com.qtong.healthcare.ahx.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


/**
 * Created by ZML on 2015/4/16.
 */
@Entity
@Table(name = "t_user")
@Cacheable(value = true)
public class  User implements Serializable {
    private int userId;

    private String username;

    private String password;

    private boolean enabled;

    private boolean overdue;

    private Date lastUpdate;

    private String mail;

    private Set<Role> roles;
    private String salt;
    private boolean locked;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", password='" + password + '\'' +
                ", overdue=" + overdue +
                ", lastUpdate=" + lastUpdate +
                ", mail='" + mail + '\'' +
                ", tenantId=" + tenant +
                ", salt='" + salt + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role",joinColumns = @JoinColumn(name = "roleId"),inverseJoinColumns = @JoinColumn(name = "userId"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    private Tenant tenant;

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @ManyToOne(targetEntity = Tenant.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "tenantId")
    public Tenant getTenant() {
        return tenant;
    }


    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}

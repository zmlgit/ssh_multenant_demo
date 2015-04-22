package com.qtong.healthcare.ahx.model;

import javax.persistence.*;

/**
 * Created by ZML on 2015/4/22.
 *
 * 组织，包含医院和社区医院或者卫生局下面的医院的联合体
 */
@Entity
@Table(name = "t_organization")
public class Organization {

    private int orgId;

    private String orgName;

    private String description;//组织描述

    private Contacts contacts;//该组织的联系方式

    private Organization parentOrg;//上级组织


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @OneToOne(targetEntity = Contacts.class)
    @JoinColumn(name = "contactId")
    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name="parentId")
    public Organization getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(Organization parentOrg) {
        this.parentOrg = parentOrg;
    }
}

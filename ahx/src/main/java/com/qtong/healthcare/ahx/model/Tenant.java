package com.qtong.healthcare.ahx.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ZML on 2015/4/17.
 */

@Entity
@Table(name = "t_tenant")
public class Tenant {

    private String tenantId;

    private String tentantName;
    @Id
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTentantName() {
        return tentantName;
    }

    public void setTentantName(String tentantName) {
        this.tentantName = tentantName;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId='" + tenantId + '\'' +
                ", tentantName='" + tentantName + '\'' +
                '}';
    }
}

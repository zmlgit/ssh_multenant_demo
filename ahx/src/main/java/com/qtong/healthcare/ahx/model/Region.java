package com.qtong.healthcare.ahx.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZML on 2015/4/22.
 */
@Entity
@Table(name = "t_region")
public class Region implements Serializable {

    private int regionId;

    private String name;

    private String regionNumber;

    private Region parentRegion;

    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionNumber() {
        return regionNumber;
    }

    public void setRegionNumber(String regionNumber) {
        this.regionNumber = regionNumber;
    }

    @ManyToOne(targetEntity = Region.class)
    @JoinColumn(name = "parentId")
    public Region getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(Region parentRegion) {
        this.parentRegion = parentRegion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

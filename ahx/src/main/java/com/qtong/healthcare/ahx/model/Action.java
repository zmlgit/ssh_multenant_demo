package com.qtong.healthcare.ahx.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZML on 2015/4/19.
 */
@Entity
@Table(name="t_aciton")
public class Action implements Serializable {

    private long actionId;

    private String path;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

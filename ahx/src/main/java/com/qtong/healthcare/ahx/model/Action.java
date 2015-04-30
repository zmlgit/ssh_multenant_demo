package com.qtong.healthcare.ahx.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZML on 2015/4/19.
 */
@Entity
@Table(name="t_aciton")
public class Action implements Serializable {

    /**  
	* serialVersionUID:TODO（用一句话描述这个变量表示什么）  
	*  
	* @since Ver 1.1  
	*/  
	
	private static final long serialVersionUID = -3057817057434668193L;

	private long actionId;

	private String name;
	
	private String remark;//备注
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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


    public Action(long actionId, String path) {
        this.actionId = actionId;
        this.path = path;
    }

    public Action() {
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Action(String path) {
        this.path = path;
    }
}

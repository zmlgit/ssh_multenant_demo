package com.qtong.healthcare.ahx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_dictype")
public class DictType {

	private int typeId;

	private String name;

	private String remark;

	private String seq;

	private User editor;

	private Date editTime;

	private Date createTime;

	private User creator;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	@JoinColumn(name = "editor")
	@ManyToOne(targetEntity = User.class)
	public User getEditor() {
		return editor;
	}

	public void setEditor(User editor) {
		this.editor = editor;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JoinColumn(name = "creator")
	@ManyToOne(targetEntity = User.class)
	public User getCreater() {
		return creator;
	}

	public void setCreater(User creater) {
		this.creator = creater;
	}

}

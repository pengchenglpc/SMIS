package com.smis.model.production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 工序
 * @author 李鹏程
 *
 */
@Entity
@Table(name="judqing", schema="grxplusdata")
public class Working {
	private Integer docid;
	private String name;
	private String dept;
	private String number;
	
	@Id
	@Column(name="docid", nullable=false)
	public Integer getDocid() {
		return docid;
	}
	public void setDocid(Integer docid) {
		this.docid = docid;
	}
	
	@Column(name="juding", nullable=true, length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="MemoS", nullable=true, length=50)
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Column(name="gongxuhao", nullable=true, length=45)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}

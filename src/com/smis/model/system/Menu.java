package com.smis.model.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="T_MENU", schema="grxplusdata")
public class Menu {
	//菜单ID
	private String id;
	//菜单名称
	private String menuName;
	//菜单路径
	private String menuUrl;
	//菜单图标
	private String menuIcon;
	//父菜单ID
	private String menuParent;
	//菜单描述
	private String description;
	//创建人
	private String creator;
	//修改人
	private String mender;
	//创建时间
	private String createTime;
	//修改时间
	private String updateTime;
	//是否可用  0为不可用，1为可用
	private Integer available;
	//排序
	private Integer sort;
	//是否为面子菜单 0为叶子菜单，1为非叶子菜单
	private Integer leaf;
	
	@Id
	@Column(name="ID", unique = true, nullable = false, length = 32 )
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="MENU_NAME", nullable = false, length = 100)
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	@Column(name="MENU_URL", nullable = true, length=200)
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	@Column(name="MENU_ICON", nullable=true, length=200)
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	@Column(name="PARENT_ID", nullable=true, length=32)
	public String getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}
	@Transient
	public String getParent(){
		return this.menuParent;
	}
	@Transient
	public String get_parentId(){
		return this.menuParent;
	}
	@Transient
	public String getText(){
		return this.menuName;
	}
	
	@Column(name="DESCRIPTION", nullable=true, length=1000)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="CREATOR", nullable = false, length=32)
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	@Column(name="MENDER", nullable = false, length=32)
	public String getMender() {
		return mender;
	}
	public void setMender(String mender) {
		this.mender = mender;
	}
	
	@Column(name="CREATE_TIME", nullable=false, length=50)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="UPDATE_TIME", nullable=false, length=50)
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	@Column(name="AVAILABLE", nullable=false)
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	@Column(name="SORT", nullable=false)
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	@Column(name="LEAF", nullable=false)
	public Integer getLeaf() {
		return leaf;
	}
	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}
	
}

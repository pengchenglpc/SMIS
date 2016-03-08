package com.smis.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="userlogin", schema="grxplusdata")
public class User {
	private String userId;
	private String userName;
	private String password;
	private String userPlace;
	private String userTel;
	private String userStatus;
	private Date userDate;
	private Integer userOper;
	private Integer userPart;
	private Integer userFlag;
	private String region;
	
	@Id
	@Column(name="UserId", unique = true, nullable = false, length = 50)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="UserName", nullable=false, length=50)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="UserPassWord", nullable=false, length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="UserPlace", nullable=true, length=50)
	public String getUserPlace() {
		return userPlace;
	}
	public void setUserPlace(String userPlace) {
		this.userPlace = userPlace;
	}
	
	@Column(name="UserTel", nullable=true, length=50)
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	@Column(name="UserStatus", nullable=true, length=45)
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "UserDate", nullable = false, length = 10)
	public Date getUserDate() {
		return userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	
	@Column(name="UserOper", nullable=false)
	public Integer getUserOper() {
		return userOper;
	}
	public void setUserOper(Integer userOper) {
		this.userOper = userOper;
	}
	
	@Column(name="UserPart", nullable=false)
	public Integer getUserPart() {
		return userPart;
	}
	public void setUserPart(Integer userPart) {
		this.userPart = userPart;
	}
	
	@Column(name="UserFlag", nullable=false)
	public Integer getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}
	
	@Column(name="region", nullable=false, length=45)
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}

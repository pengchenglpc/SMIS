package com.smis.model.production;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 生产进度
 * @author 李鹏程
 *
 */
@Entity
@Table(name="produceplan", schema="grxplusdata")
public class ProducePlan {
	private String productNo;
	private String comtinueNo;
	private String clientName;
	private Date producePlanDate;
	private Date factFuillDate;
	private String inputName;
	private Date comtiDate;
	private Date sendDate;
	private String working;
	private String comFlag;
	private String comName;
	private String department;
	private String memo;
	private BigDecimal recipientsAmount;
	private String banci;
	private BigDecimal bancipersonnel;
	private BigDecimal artificialHour;
	private BigDecimal bootHour;
	private String buhegeMemo;
	private String buliangpinMemo;
	private String buhegeNo;
	private String planName;
	private BigDecimal rengongAmount;
	
	private Date startDate;
	private Date endDate;
	
	@Id
	@Column(name="ProductNo", nullable=false, length=100)
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
	@Column(name="ComtinueNo", nullable=false, length=100)
	public String getComtinueNo() {
		return comtinueNo;
	}
	public void setComtinueNo(String comtinueNo) {
		this.comtinueNo = comtinueNo;
	}
	
	@Column(name="ClientName", nullable=false, length=100)
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="ProducePlanDate", nullable=true, length=10)
	public Date getProducePlanDate() {
		return producePlanDate;
	}
	public void setProducePlanDate(Date producePlanDate) {
		this.producePlanDate = producePlanDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="FactFuillDate", nullable=true, length=10)
	public Date getFactFuillDate() {
		return factFuillDate;
	}
	public void setFactFuillDate(Date factFuillDate) {
		this.factFuillDate = factFuillDate;
	}
	
	@Column(name="InputName", nullable=true,length=45)
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="ComtiDate", nullable=true, length=10)
	public Date getComtiDate() {
		return comtiDate;
	}
	public void setComtiDate(Date comtiDate) {
		this.comtiDate = comtiDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="SendDate", nullable=false, length=10)
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	@Column(name="Working", nullable=false, length=45)
	public String getWorking() {
		return working;
	}
	public void setWorking(String working) {
		this.working = working;
	}
	
	@Column(name="ComFlag", nullable=true, length=50)
	public String getComFlag() {
		return comFlag;
	}
	public void setComFlag(String comFlag) {
		this.comFlag = comFlag;
	}
	
	@Column(name="ComName", nullable=true, length=50)
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	@Column(name="Department", nullable=true, length=100)
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name="Memo", nullable=true, length=500)
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Column(name="RecipientsAmount", nullable=true, length=18, scale=2)
	public BigDecimal getRecipientsAmount() {
		return recipientsAmount;
	}
	public void setRecipientsAmount(BigDecimal recipientsAmount) {
		this.recipientsAmount = recipientsAmount;
	}
	
	@Column(name="banci", nullable=true, length=100)
	public String getBanci() {
		return banci;
	}
	public void setBanci(String banci) {
		this.banci = banci;
	}
	
	@Column(name="bancipersonnel", nullable=true, length=18, scale=2)
	public BigDecimal getBancipersonnel() {
		return bancipersonnel;
	}
	public void setBancipersonnel(BigDecimal bancipersonnel) {
		this.bancipersonnel = bancipersonnel;
	}
	
	@Column(name="ArtificialHour", nullable=true, length=18, scale=2)
	public BigDecimal getArtificialHour() {
		return artificialHour;
	}
	public void setArtificialHour(BigDecimal artificialHour) {
		this.artificialHour = artificialHour;
	}
	
	@Column(name="BootHour", nullable=true, length=18, scale=2)
	public BigDecimal getBootHour() {
		return bootHour;
	}
	public void setBootHour(BigDecimal bootHour) {
		this.bootHour = bootHour;
	}
	
	@Column(name="buhegeMemo", nullable=true, length=500)
	public String getBuhegeMemo() {
		return buhegeMemo;
	}
	public void setBuhegeMemo(String buhegeMemo) {
		this.buhegeMemo = buhegeMemo;
	}
	
	@Column(name="buliangpinMemo", nullable=true, length=500)
	public String getBuliangpinMemo() {
		return buliangpinMemo;
	}
	public void setBuliangpinMemo(String buliangpinMemo) {
		this.buliangpinMemo = buliangpinMemo;
	}
	
	@Column(name="buhegeNo", nullable=true, length=100)
	public String getBuhegeNo() {
		return buhegeNo;
	}
	public void setBuhegeNo(String buhegeNo) {
		this.buhegeNo = buhegeNo;
	}
	
	@Column(name="PlanName", nullable=true, length=100)
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	
	@Column(name="rengongAmount", nullable=true, length=18, scale=2)
	public BigDecimal getRengongAmount() {
		return rengongAmount;
	}
	public void setRengongAmount(BigDecimal rengongAmount) {
		this.rengongAmount = rengongAmount;
	}
	@Transient
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Transient
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}

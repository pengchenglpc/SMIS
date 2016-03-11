package com.smis.model.production;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="produceplanpersonnel", schema="grxplusdata")
public class ProducePlanPersonnel {
	private Integer docId;
	private String productPersonnelNo;
	private String thingId;
	private String thingName;
	private String thingSpec;
	private String productpersonnelNum;
	private BigDecimal personnelPdFilFill;
	private BigDecimal personnelInvalid;
	private BigDecimal personnelDad;
	private BigDecimal personnelPdfulFillw;
	private BigDecimal personnelInvalidw;
	private BigDecimal personnelDadw;
	private String personnelMemo;
	private String personnelWorking;
	private String inputName;
	private Date inputDate;
	private String zerenPersonnel;
	private String yfFangong;
	private BigDecimal fenZhi;
	private BigDecimal jiangLiFenZhi;
	private String thingXuLieHao;
	private String systemYF;
	private Date factFuillListDate;
	
	@Id
	@Column(name="docid", nullable=false)
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	
	@Column(name="ProductpersonnelNo", nullable=false, length=100)
	public String getProductPersonnelNo() {
		return productPersonnelNo;
	}
	public void setProductPersonnelNo(String productPersonnelNo) {
		this.productPersonnelNo = productPersonnelNo;
	}
	
	@Column(name="ThingID", nullable=false, length=100)
	public String getThingId() {
		return thingId;
	}
	public void setThingId(String thingId) {
		this.thingId = thingId;
	}
	
	@Column(name="ThingName", nullable=true, length=100)
	public String getThingName() {
		return thingName;
	}
	public void setThingName(String thingName) {
		this.thingName = thingName;
	}
	
	@Column(name="ThingSpec", nullable=false, length=100)
	public String getThingSpec() {
		return thingSpec;
	}
	public void setThingSpec(String thingSpec) {
		this.thingSpec = thingSpec;
	}
	
	@Column(name="ProductpersonnelNum", nullable=true, length=100)
	public String getProductpersonnelNum() {
		return productpersonnelNum;
	}
	public void setProductpersonnelNum(String productpersonnelNum) {
		this.productpersonnelNum = productpersonnelNum;
	}
	
	@Column(name="PersonnelPdFilFill", nullable=true, length=18, scale=2)
	public BigDecimal getPersonnelPdFilFill() {
		return personnelPdFilFill;
	}
	public void setPersonnelPdFilFill(BigDecimal personnelPdFilFill) {
		this.personnelPdFilFill = personnelPdFilFill;
	}
	
	@Column(name="PersonnelInvalid", nullable=true, length=18, scale=2)
	public BigDecimal getPersonnelInvalid() {
		return personnelInvalid;
	}
	public void setPersonnelInvalid(BigDecimal personnelInvalid) {
		this.personnelInvalid = personnelInvalid;
	}
	
	@Column(name="PersonnelDad", nullable=true, length=18, scale=2)
	public BigDecimal getPersonnelDad() {
		return personnelDad;
	}
	public void setPersonnelDad(BigDecimal personnelDad) {
		this.personnelDad = personnelDad;
	}
	
	@Column(name="PersonnelPdfulFillw", nullable=true, length=18, scale=2)
	public BigDecimal getPersonnelPdfulFillw() {
		return personnelPdfulFillw;
	}
	public void setPersonnelPdfulFillw(BigDecimal personnelPdfulFillw) {
		this.personnelPdfulFillw = personnelPdfulFillw;
	}
	
	@Column(name="PersonnelDadw", nullable=true, length=18, scale=2)
	public BigDecimal getPersonnelDadw() {
		return personnelDadw;
	}
	public void setPersonnelDadw(BigDecimal personnelDadw) {
		this.personnelDadw = personnelDadw;
	}
	@Column(name="PersonnelInvalidw", nullable=true, length=18, scale=2)
	public BigDecimal getPersonnelInvalidw() {
		return personnelInvalidw;
	}
	public void setPersonnelInvalidw(BigDecimal personnelInvalidw) {
		this.personnelInvalidw = personnelInvalidw;
	}
	
	@Column(name="PersonnelMemo", nullable=true, length=500)
	public String getPersonnelMemo() {
		return personnelMemo;
	}
	public void setPersonnelMemo(String personnelMemo) {
		this.personnelMemo = personnelMemo;
	}
	
	@Column(name="PersonnelWorking", nullable=true, length=60)
	public String getPersonnelWorking() {
		return personnelWorking;
	}
	public void setPersonnelWorking(String personnelWorking) {
		this.personnelWorking = personnelWorking;
	}
	
	@Column(name="InputName", nullable=true, length=50)
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="InputDate", nullable=true, length=10)
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	@Column(name="zerenpersonnel", nullable=true, length=100)
	public String getZerenPersonnel() {
		return zerenPersonnel;
	}
	public void setZerenPersonnel(String zerenPersonnel) {
		this.zerenPersonnel = zerenPersonnel;
	}
	
	@Column(name="YFfangong", nullable=true, length=50)
	public String getYfFangong() {
		return yfFangong;
	}
	public void setYfFangong(String yfFangong) {
		this.yfFangong = yfFangong;
	}
	
	@Column(name="fenzhi", nullable=true, length=18, scale=2)
	public BigDecimal getFenZhi() {
		return fenZhi;
	}
	public void setFenZhi(BigDecimal fenZhi) {
		this.fenZhi = fenZhi;
	}
	
	@Column(name="jianglifenzhi", nullable=true, length=18, scale=2)
	public BigDecimal getJiangLiFenZhi() {
		return jiangLiFenZhi;
	}
	public void setJiangLiFenZhi(BigDecimal jiangLiFenZhi) {
		this.jiangLiFenZhi = jiangLiFenZhi;
	}
	
	@Column(name="Thingxuliehao", nullable=true, length=45)
	public String getThingXuLieHao() {
		return thingXuLieHao;
	}
	public void setThingXuLieHao(String thingXuLieHao) {
		this.thingXuLieHao = thingXuLieHao;
	}
	
	@Column(name="SystemYF", nullable=true, length=45)
	public String getSystemYF() {
		return systemYF;
	}
	public void setSystemYF(String systemYF) {
		this.systemYF = systemYF;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="FactFuillListDate", nullable=true, length=10)
	public Date getFactFuillListDate() {
		return factFuillListDate;
	}
	public void setFactFuillListDate(Date factFuillListDate) {
		this.factFuillListDate = factFuillListDate;
	}
}

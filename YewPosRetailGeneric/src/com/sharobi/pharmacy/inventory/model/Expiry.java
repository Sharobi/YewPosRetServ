package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: exp_t_expiry
 * 
 */

@XmlRootElement
@Entity
@Table(name = "exp_t_expiry")
public class Expiry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "inv_no")
	private String invNo;
	
	@Expose
	@Column(name = "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;
	
	@Expose
	@Column(name = "from_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
	
	@Expose
	@Column(name = "to_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	@Expose
	@Column(name = "remarks")
	private String remarks;
	
	@Expose
	@Column(name = "is_posted")
	private int isPosted;
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "store_id")
	private int storeId;


	@Expose
	@Column(name = "created_by")
	private int createdBy;

	@Expose
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Expose
	@Column(name = "updated_by")
	private int updatedBy;

	@Expose
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private List<ExpiryDetails> expiryDetails;
	
	@Expose
	@Transient
	private String finyrCode;
	//added on 05.07.2019
	@Expose
	@Column(name = "gross_amount")
	private double grossAmount;
	
	@Expose
	@Column(name = "disc_amount")
	private double discAmount;
	
	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Expose
	@Column(name = "roundoff")
	private double roundoff;
	
	@Expose
	@Column(name = "net_amount")
	private double netAmount;
	
	@Expose
	@Column(name = "total_mrp")
	private double totalMrp;
	
	@Expose
	@Transient
	private double cr_amount;
	@Expose
	@Transient
	private double dr_amount;
	@Expose
	@Transient
	private int cr_account_id;
	@Expose
	@Transient
	private int dr_account_id;
	@Expose
	@Transient
	private String qs;
	
	@Expose
	@Column(name = "exp_mode")
	private String expMode;
	
	
	public String getFinyrCode() {
		return finyrCode;
	}

	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public List<ExpiryDetails> getExpiryDetails() {
		return expiryDetails;
	}

	public void setExpiryDetails(List<ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getInvNo() {
		return invNo;
	}

	@XmlElement
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Date getInvDate() {
		return invDate;
	}

	@XmlElement
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	@XmlElement
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	@XmlElement
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsPosted() {
		return isPosted;
	}

	@XmlElement
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	@XmlElement
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@XmlElement
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	@XmlElement
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	@XmlElement
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
    
	public double getGrossAmount() {
		return grossAmount;
	}

	@XmlElement
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	@XmlElement
	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	@XmlElement
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	@XmlElement
	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	@XmlElement
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public double getCr_amount() {
		return cr_amount;
	}

	@XmlElement
	public void setCr_amount(double cr_amount) {
		this.cr_amount = cr_amount;
	}

	public double getDr_amount() {
		return dr_amount;
	}

	@XmlElement
	public void setDr_amount(double dr_amount) {
		this.dr_amount = dr_amount;
	}

	public int getCr_account_id() {
		return cr_account_id;
	}

	@XmlElement
	public void setCr_account_id(int cr_account_id) {
		this.cr_account_id = cr_account_id;
	}

	public int getDr_account_id() {
		return dr_account_id;
	}

	@XmlElement
	public void setDr_account_id(int dr_account_id) {
		this.dr_account_id = dr_account_id;
	}

	public String getQs() {
		return qs;
	}

	@XmlElement
	public void setQs(String qs) {
		this.qs = qs;
	}

	
	public String getExpMode() {
		return expMode;
	}

	public void setExpMode(String expMode) {
		this.expMode = expMode;
	}

	@Override
	public String toString() {
		return "Expiry [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", remarks=" + remarks + ", isPosted=" + isPosted + ", finyrId=" + finyrId + ", companyId="
				+ companyId + ", storeId=" + storeId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", lang=" + lang + ", expiryDetails="
				+ expiryDetails + ", finyrCode=" + finyrCode + ", grossAmount=" + grossAmount + ", discAmount="
				+ discAmount + ", taxAmount=" + taxAmount + ", roundoff=" + roundoff + ", netAmount=" + netAmount
				+ ", totalMrp=" + totalMrp + ", cr_amount=" + cr_amount + ", dr_amount=" + dr_amount
				+ ", cr_account_id=" + cr_account_id + ", dr_account_id=" + dr_account_id + ", qs=" + qs + ", expMode="
				+ expMode + "]";
	}

	
	



}
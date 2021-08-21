/**
 * 
 */
package com.sharobi.pharmacy.sales.model;

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
 * @author Habib
 *
 */
@XmlRootElement
@Entity
@Table(name = "sal_t_salestourplan")
public class SaleTourPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "tourplan_no")
	private String tourPlanNo;

	@Expose
	@Column(name = "tour_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tourDate;

	@Expose
	@Column(name = "salesman_id")
	private int salesmanId;
	
	@Expose
	@Column(name = "no_of_customers")
	private int noOfCustomer;
	
	@Expose
	@Column(name = "country_id")
	private int countryId;
	
	@Expose
	@Column(name = "state_id")
	private int stateId;

	@Expose
	@Column(name = "remarks")
	private String remarks;

	@Expose
	@Column(name = "is_cancel")
	private int isCancel;
	
	@Expose
	@Column(name = "cancel_remarks")
	private String cancelRemarks;
	
	@Expose
	@Column(name = "is_posted")
	private int isPosted;

	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;

	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

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
	private String finyrCode;

	@Expose
	@Transient
	private List<SaleTourPlanDetails> saleTourPlanDetails;

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getTourPlanNo() {
		return tourPlanNo;
	}

	@XmlElement
	public void setTourPlanNo(String tourPlanNo) {
		this.tourPlanNo = tourPlanNo;
	}

	public Date getTourDate() {
		return tourDate;
	}

	@XmlElement
	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	@XmlElement
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	public int getNoOfCustomer() {
		return noOfCustomer;
	}

	@XmlElement
	public void setNoOfCustomer(int noOfCustomer) {
		this.noOfCustomer = noOfCustomer;
	}

	public int getCountryId() {
		return countryId;
	}

	@XmlElement
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	@XmlElement
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsCancel() {
		return isCancel;
	}

	@XmlElement
	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}
	
	public String getCancelRemarks() {
		return cancelRemarks;
	}

	@XmlElement
	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}

	public int getIsPosted() {
		return isPosted;
	}

	@XmlElement
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public List<SaleTourPlanDetails> getSaleTourPlanDetails() {
		return saleTourPlanDetails;
	}

	public void setSaleTourPlanDetails(List<SaleTourPlanDetails> saleTourPlanDetails) {
		this.saleTourPlanDetails = saleTourPlanDetails;
	}

	@Override
	public String toString() {
		return "SaleTourPlan [id=" + id + ", tourPlanNo=" + tourPlanNo + ", tourDate=" + tourDate + ", salesmanId="
				+ salesmanId + ", noOfCustomer=" + noOfCustomer + ", countryId=" + countryId + ", stateId=" + stateId
				+ ", remarks=" + remarks + ", isCancel=" + isCancel + ", cancelRemarks=" + cancelRemarks + ", isPosted="
				+ isPosted + ", isDeleted=" + isDeleted + ", finyrId=" + finyrId + ", storeId=" + storeId
				+ ", companyId=" + companyId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", finyrCode=" + finyrCode
				+ ", saleTourPlanDetails=" + saleTourPlanDetails + "]";
	}
	
	

}

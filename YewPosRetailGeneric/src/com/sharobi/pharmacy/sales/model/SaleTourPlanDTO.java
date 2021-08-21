/**
 * 
 */
package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * @author Habib
 *
 */
@XmlRootElement
public class SaleTourPlanDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "sale_tourplan_id" })
	private int saleTourPlanId;

	@Expose
	@MapToData(columnAliases = { "tourplan_no" })
	private String tourPlanNo;

	@Expose
	@MapToData(columnAliases = { "tour_date" })
	private Date tourDate;
	
	@Expose
	@MapToData(columnAliases = { "salesman_id" })
	private int salesmanId;
	
	@Expose
	@MapToData(columnAliases = { "salesman_name" })
	private String salesmanName;
	
	@Expose
	@MapToData(columnAliases = { "salesman_phone" })
	private String salesmanPhone;
	
	@Expose
	@MapToData(columnAliases = { "no_of_customers" })
	private int noOfCustomer;
	
	@Expose
	@MapToData(columnAliases = { "country_id" })
	private int countryId;
	
	@Expose
	@MapToData(columnAliases = { "country_name" })
	private String countryName;
	
	@Expose
	@MapToData(columnAliases = { "state_id" })
	private int stateId;
	
	@Expose
	@MapToData(columnAliases = { "state_name" })
	private String stateName;
	
	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;
	
	@Expose
	@MapToData(columnAliases = { "is_cancel" })
	private int isCancel;
	
	@Expose
	@MapToData(columnAliases = { "cancel_remarks" })
	private String cancelRemarks;
	
	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;

	public int getSaleTourPlanId() {
		return saleTourPlanId;
	}

	public void setSaleTourPlanId(int saleTourPlanId) {
		this.saleTourPlanId = saleTourPlanId;
	}

	public String getTourPlanNo() {
		return tourPlanNo;
	}

	public void setTourPlanNo(String tourPlanNo) {
		this.tourPlanNo = tourPlanNo;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	

	public String getSalesmanPhone() {
		return salesmanPhone;
	}

	public void setSalesmanPhone(String salesmanPhone) {
		this.salesmanPhone = salesmanPhone;
	}

	public int getNoOfCustomer() {
		return noOfCustomer;
	}

	public void setNoOfCustomer(int noOfCustomer) {
		this.noOfCustomer = noOfCustomer;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}

	public String getCancelRemarks() {
		return cancelRemarks;
	}

	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}

	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	@Override
	public String toString() {
		return "SaleTourPlanDTO [saleTourPlanId=" + saleTourPlanId + ", tourPlanNo=" + tourPlanNo + ", tourDate="
				+ tourDate + ", salesmanId=" + salesmanId + ", salesmanName=" + salesmanName + ", salesmanPhone="
				+ salesmanPhone + ", noOfCustomer=" + noOfCustomer + ", countryId=" + countryId + ", countryName="
				+ countryName + ", stateId=" + stateId + ", stateName=" + stateName + ", remarks=" + remarks
				+ ", isCancel=" + isCancel + ", cancelRemarks=" + cancelRemarks + ", isPosted=" + isPosted + "]";
	}

	
	
	
}

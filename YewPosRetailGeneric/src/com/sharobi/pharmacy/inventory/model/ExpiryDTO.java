package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ExpiryDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "expiry_id" })
	private int expiryId;

	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "from_date" })
	private Date fromDate;
	
	@Expose
	@MapToData(columnAliases = { "to_date" })
	private Date toDate;
	
	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;

	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;
	
	@Expose
	@Transient
	private String lang;
	
	//added on 05.07.2019
	@Expose
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;
	
	@Expose
	@MapToData(columnAliases = { "disc_amount" })
	private double discAmount;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundoff;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp" })
	private double totalMrp;
	
	@Expose
	@MapToData(columnAliases = { "exp_mode" })
	private String expMode;


	private static final long serialVersionUID = 1L;
	
	


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public int getExpiryId() {
		return expiryId;
	}


	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}


	public String getInvNo() {
		return invNo;
	}


	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}


	public Date getInvDate() {
		return invDate;
	}


	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getIsPosted() {
		return isPosted;
	}


	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}


	public double getGrossAmount() {
		return grossAmount;
	}


	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}


	public double getDiscAmount() {
		return discAmount;
	}


	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public double getRoundoff() {
		return roundoff;
	}


	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public double getTotalMrp() {
		return totalMrp;
	}


	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}


	public String getExpMode() {
		return expMode;
	}


	public void setExpMode(String expMode) {
		this.expMode = expMode;
	}


	@Override
	public String toString() {
		return "ExpiryDTO [expiryId=" + expiryId + ", invNo=" + invNo + ", invDate=" + invDate + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", remarks=" + remarks + ", isPosted=" + isPosted + ", lang=" + lang
				+ ", grossAmount=" + grossAmount + ", discAmount=" + discAmount + ", taxAmount=" + taxAmount
				+ ", roundoff=" + roundoff + ", netAmount=" + netAmount + ", totalMrp=" + totalMrp + ", expMode="
				+ expMode + "]";
	}


	

	
}
package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;



@XmlRootElement
public class SerialStockStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "is_checked"})
	private int isChecked;
	
	@Expose
	@MapToData(columnAliases = { "item_id"})
	private int itemId;

	@Expose
	@MapToData(columnAliases = { "unique_identifier_no"})
	private String uniqueIdentifierNo;
	
	@Expose
	@MapToData(columnAliases = { "check_status"})
	private String checkStatus;
	
	@Expose
	@MapToData(columnAliases = { "mrp"})
	private double mrp;
	
	@Expose
	@MapToData(columnAliases = { "purchase_rate"})
	private double purchaseRate;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate"})
	private double saleRate;
	

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public int getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getUniqueIdentifierNo() {
		return uniqueIdentifierNo;
	}

	public void setUniqueIdentifierNo(String uniqueIdentifierNo) {
		this.uniqueIdentifierNo = uniqueIdentifierNo;
	}
	
}
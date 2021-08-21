package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

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
 * Entity implementation class for Entity: pur_t_purchase_details_serial_mapping
 * 
 */

@XmlRootElement
@Entity
@Table(name = "sal_t_sale_details_serial_mapping")
public class SalesDetailsSerialMapper implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "sale_id")
	private int saleId;
	
	@Expose
	@Column(name = "sale_details_id")
	private int saleDetailsId;
	
	@Expose
	@Column(name = "item_id")
	private int itemId;

		
	@Expose
	@Column(name = "batch_no")
	private String batchNo;
	
	@Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	@Expose
	@Column(name = "unique_identifier_no")
	private String uniqueIdentifierNo;
	
	@Expose
	@Column(name = "qty")
	private double qty;
	
	@Expose
	@Column(name = "check_status")
	private String checkStatus;
	
		
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
	@Transient
	private String expiryDateFormat;
	
	@Expose
	@Transient
	private int tmpMappingId;
	
	

	public int getSaleId() {
		return saleId;
	}

	@XmlElement
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getSaleDetailsId() {
		return saleDetailsId;
	}

	@XmlElement
	public void setSaleDetailsId(int saleDetailsId) {
		this.saleDetailsId = saleDetailsId;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	@XmlElement
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public int getTmpMappingId() {
		return tmpMappingId;
	}

	@XmlElement
	public void setTmpMappingId(int tmpMappingId) {
		this.tmpMappingId = tmpMappingId;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	
	public int getItemId() {
		return itemId;
	}

	@XmlElement
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	@XmlElement
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	@XmlElement
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getUniqueIdentifierNo() {
		return uniqueIdentifierNo;
	}

	@XmlElement
	public void setUniqueIdentifierNo(String uniqueIdentifierNo) {
		this.uniqueIdentifierNo = uniqueIdentifierNo;
	}

	

	public double getQty() {
		return qty;
	}

	@XmlElement
	public void setQty(double qty) {
		this.qty = qty;
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

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	@XmlElement
	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	
}
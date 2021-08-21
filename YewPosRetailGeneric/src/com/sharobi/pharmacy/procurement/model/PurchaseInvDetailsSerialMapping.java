package com.sharobi.pharmacy.procurement.model;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;


@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_inv_details_serial_mapping")
public class PurchaseInvDetailsSerialMapping implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public PurchaseInvDetailsSerialMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "purchase_inv_id")
	private int purchaseInvId;
	
	@Expose
	@Column(name = "purchase_inv_details_id")
	private int purchaseInvDetailsId;
	
	
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
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "store_id")
	private int storeId;
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;


	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getPurchaseInvId() {
		return purchaseInvId;
	}

	@XmlElement
	public void setPurchaseInvId(int purchaseInvId) {
		this.purchaseInvId = purchaseInvId;
	}

	public int getPurchaseInvDetailsId() {
		return purchaseInvDetailsId;
	}

	@XmlElement
	public void setPurchaseInvDetailsId(int purchaseInvDetailsId) {
		this.purchaseInvDetailsId = purchaseInvDetailsId;
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

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	@Override
	public String toString() {
		return "PurchaseInvDetailsSerialMapping [id=" + id + ", purchaseInvId=" + purchaseInvId
				+ ", purchaseInvDetailsId=" + purchaseInvDetailsId + ", itemId=" + itemId + ", batchNo=" + batchNo
				+ ", expiryDate=" + expiryDate + ", uniqueIdentifierNo=" + uniqueIdentifierNo + ", qty=" + qty
				+ ", companyId=" + companyId + ", storeId=" + storeId + ", finyrId=" + finyrId + "]";
	}

	
}
